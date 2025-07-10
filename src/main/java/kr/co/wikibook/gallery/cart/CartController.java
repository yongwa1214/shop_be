package kr.co.wikibook.gallery.cart;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.wikibook.gallery.account.etc.AccountConstants;
import kr.co.wikibook.gallery.cart.model.*;
import kr.co.wikibook.gallery.common.util.HttpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<?> postCart(HttpServletRequest httpReq, @RequestBody CartPostReq req){
        log.info("req:{}",req);
        int logginedMemberId = (int)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        req.setMemberId(logginedMemberId);
        int result = cartService.save(req);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<CartGetRes>> getCart(HttpServletRequest httpReq){
        int logginedMemberId = (int)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        List<CartGetRes> result = cartService.findAll(logginedMemberId);
        return ResponseEntity.ok(result);
    }

//    @DeleteMapping
//    public ResponseEntity<?> delCart(HttpServletRequest httpReq, @RequestParam(name = cart_id) int cartId){
//        int logginedMemberId = (int)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
//        CartDeleteReq cartDeleteReq = new CartDeleteReq(logginedMemberId, cartId);
//        int result = cartService.remove(cartDeleteReq);
//        return ResponseEntity.ok(result);
//    }

     @DeleteMapping("/{cartId}")
    public ResponseEntity<?> deleteMemberItem(HttpServletRequest httpReq, @PathVariable int cartId){
        int logginedMemberId = (int)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        CartDeleteReq cartDeleteReq = new CartDeleteReq(logginedMemberId, cartId);
         int result = cartService.remove(cartDeleteReq);

        return ResponseEntity.ok(cartDeleteReq);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMemberCart(HttpServletRequest httpReq){
        int logginedMemberId = (int)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        int result = cartService.clear(logginedMemberId);
        return ResponseEntity.ok(result);
    }
}
