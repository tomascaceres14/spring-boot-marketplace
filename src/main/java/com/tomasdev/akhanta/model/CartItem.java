package com.tomasdev.akhanta.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CartItem {
    private String productId;
    private String name;
    private Integer quantity;
    private Double price;
}
