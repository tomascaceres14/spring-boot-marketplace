package com.tomasdev.akhanta.home;

import com.tomasdev.akhanta.home.dto.HomeShopDTO;
import com.tomasdev.akhanta.product.Product;
import com.tomasdev.akhanta.product.ProductService;
import com.tomasdev.akhanta.product.categories.Category;
import com.tomasdev.akhanta.product.categories.CategoryService;
import com.tomasdev.akhanta.shop.ShopService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Home")
@RequestMapping("/api/v1/home")
@AllArgsConstructor
public class HomeController {

    private ProductService productService;
    private final ShopService shopService;
    private CategoryService categoryService;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> findAllProducts(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                         @RequestParam(required = false, defaultValue = "1") Integer size) {
        return ResponseEntity.ok().body(productService.findAllProducts(page, size));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable String id) {
        return ResponseEntity.ok().body(productService.findProductById(id));
    }

    @GetMapping("/products/search")
    public ResponseEntity<Page<Product>> findAllProductsFiltered(
            @RequestParam(required = false, defaultValue = "") String categoryId,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        return ResponseEntity.ok().body(productService.filterProducts(name, categoryId, page, size));
    }

    @GetMapping("/shops")
    public ResponseEntity<Page<HomeShopDTO>> findAllShops(@RequestParam(required = false, defaultValue = "0") int page,
                                                          @RequestParam(required = false, defaultValue = "1") int size) {
        return ResponseEntity.ok(shopService.findAllShops(page, size));
    }

    @GetMapping("/shops/{seName}")
    public ResponseEntity<HomeShopDTO> findShopBySeName(@PathVariable String seName) {
        return ResponseEntity.ok(shopService.findBySeName(seName));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> findAllCategories(@RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity.ok().body(categoryService.findAllCategories());
    }


}
