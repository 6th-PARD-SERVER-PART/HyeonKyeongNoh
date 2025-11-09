package com.pard.server.seminar6.controller;

import com.pard.server.seminar6.dto.CategoryAllRes;
import com.pard.server.seminar6.dto.ColorCountRes;
import com.pard.server.seminar6.dto.ProductReq;
import com.pard.server.seminar6.dto.ProductRes;
import com.pard.server.seminar6.entity.Product;
import com.pard.server.seminar6.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ProductReq.ProductInfo req){
        try {
            Integer check = productService.save(req);
            if (check == 1)return  ResponseEntity.ok(409);
            else return ResponseEntity.ok(200);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PatchMapping("/allColor")
    public ResponseEntity<?> updateColorNum(@RequestBody ProductReq.ColorNum req){
        try {
            productService.newColorNum(req);
            // 성공 시: ResponseEntity에 200 OK 상태로 반환
            return ResponseEntity.ok(200);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product req){
        try {
            Integer check = productService.fixProduct(req);
            if (check == 1)return  ResponseEntity.ok(409);
            else return ResponseEntity.ok(200);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        try {
            List<CategoryAllRes> products = productService.readCategory();
            // 성공 시: ResponseEntity에 List를 담아 200 OK 상태로 반환
            return ResponseEntity.ok(products);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/getColor/{color}")
    public ResponseEntity<?> getColor(@PathVariable String color){
           try {
            List<Product> products = productService.readColor(color);
            // 성공 시: ResponseEntity에 List를 담아 200 OK 상태로 반환
            return ResponseEntity.ok(products);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("getPrdColor/{name}")
    public ResponseEntity<?> getAllColor(@PathVariable String name){
        try {
            List<ColorCountRes> colors = productService.readProductColor(name);
            // 성공 시: ResponseEntity에 List를 담아 200 OK 상태로 반환
            return ResponseEntity.ok(colors);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/getPrd/{name}/{color}")
    public ResponseEntity<?> getProduct(@PathVariable String name, @PathVariable String color){
        try {
            Product product = productService.readProduct(name,color);
            // 성공 시: ResponseEntity에 Product를 담아 200 OK 상태로 반환
            return ResponseEntity.ok(product);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/getAllColor")
    public ResponseEntity<?> getAllColor(){
        try {
            List<ColorCountRes> colors = productService.readColorAll();
            // 성공 시: ResponseEntity에 List를 담아 200 OK 상태로 반환
            return ResponseEntity.ok(colors);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
