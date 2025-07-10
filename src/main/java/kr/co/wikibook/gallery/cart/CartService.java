package kr.co.wikibook.gallery.cart;

import kr.co.wikibook.gallery.cart.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartService {
    private final CartMapper cartMapper;

    public int save(CartPostReq req){
        return cartMapper.save(req);
    }

    public List<CartGetRes> findAll(int memberId){
        return cartMapper.findAllWithItemByMemberId(memberId);
    }

    public int remove(CartDeleteReq req){
        return cartMapper.deleteByMemberCartIdAndItemId(req);
    }

    public int clear(int memberId){
        return cartMapper.deleteByMemberId(memberId);
    }
}
