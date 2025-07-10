package kr.co.wikibook.gallery.cart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

@AllArgsConstructor
@Getter

public class CartDeleteReq {
    private int memberId;
    private int cartId;





}
