package com.tomasdev.akhanta.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(value = "products")
public class Product {

    @Id
    private String productId;
    private String title;
    private String description;
    private Integer quantity;
    private Float price;
    private List<String> categories;
    private List<String> images;

}
