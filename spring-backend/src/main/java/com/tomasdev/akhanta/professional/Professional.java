package com.tomasdev.akhanta.professional;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@RequiredArgsConstructor
@Document(collection = "professionals")
public class Professional {
    @Id
    private String id;
    private String title;
    @Indexed
    private String seTitle;
    private String description;
    private Double price;
    private String categoryId;
    private List<String> images;
    private List<String> tags;
    private Integer status;
    private Double rating;
    private String userId;
}
