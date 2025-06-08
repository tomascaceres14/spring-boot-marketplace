package com.tomasdev.akhanta.users;

import com.tomasdev.akhanta.auth.dto.PasswordChangeDTO;
import com.tomasdev.akhanta.cart.Cart;
import com.tomasdev.akhanta.cart.CartItemDTO;
import com.tomasdev.akhanta.cart.CartService;
import com.tomasdev.akhanta.orders.ShopOrder;
import com.tomasdev.akhanta.orders.ShopOrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "User Auth")
public class UserController {

    private final UserService service;

    private final CartService cartService;
    private final ShopOrderService orderService;

    @PostMapping("/password")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeDTO passwordDTO,
                                            @RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        service.changePassword(passwordDTO, jwt);
        return ResponseEntity.status(HttpStatus.SC_RESET_CONTENT).build();
    }

    @GetMapping("/orders")
    public ResponseEntity<Page<ShopOrder>> findAllOrders(@RequestParam(required = false, defaultValue = "") String shopId,
                                                         @RequestParam(required = false, defaultValue = "0") Integer page,
                                                         @RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        return ResponseEntity.ok(orderService.findAllOrdersByCustomer(jwt, shopId, page));
    }

    @PostMapping("/orders")
    public ResponseEntity<List<ShopOrder>> createOrder(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body(orderService.createOrder(jwt));
    }

    @GetMapping("/cart")
    public ResponseEntity<Cart> findCartById(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        return ResponseEntity.ok(cartService.findCartById(jwt));
    }

    @PostMapping("/cart")
    public ResponseEntity<?> addItemToCart(@RequestBody CartItemDTO cartItem,
                                           @RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        cartService.addItemToCart(cartItem, jwt);
        return ResponseEntity.status(HttpStatus.SC_OK).build();
    }

    @DeleteMapping("/cart")
    public ResponseEntity<?> clearCart(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        cartService.clearCart(jwt);
        return ResponseEntity.status(HttpStatus.SC_OK).build();
    }

    @DeleteMapping("/cart/{productId}")
    public ResponseEntity<?> removeItemFromCart(@PathVariable String productId,
                                                @RequestParam(defaultValue = "false") boolean unit,
                                                @RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        cartService.removeItemFromCart(productId, unit, jwt);
        return ResponseEntity.status(HttpStatus.SC_OK).build();
    }
}
