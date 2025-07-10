package kr.co.wikibook.gallery.order.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class OrderItemPostDto {
    private int orderId;
    private List<Integer> itemIds;
}
