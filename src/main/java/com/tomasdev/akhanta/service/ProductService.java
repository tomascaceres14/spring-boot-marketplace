package com.tomasdev.akhanta.service;

import com.tomasdev.akhanta.model.Product;
import com.tomasdev.akhanta.model.dto.ProductRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductService {

    Page<Product> findAllProducts(int page);
    Product saveProduct(ProductRequestDTO productDTO, List<MultipartFile> images);
    Product updateProductById(String id, ProductRequestDTO product);
    Product findProductById(String id);
    Page<Product> filterProducts(String name, int page);
    String deleteProductById(String id);
}
