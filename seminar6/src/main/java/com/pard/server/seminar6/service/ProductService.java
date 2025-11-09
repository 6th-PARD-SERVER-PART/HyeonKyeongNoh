package com.pard.server.seminar6.service;

import com.pard.server.seminar6.dto.CategoryAllRes;
import com.pard.server.seminar6.dto.ColorCountRes;
import com.pard.server.seminar6.dto.ProductReq;
import com.pard.server.seminar6.entity.Product;
import com.pard.server.seminar6.repo.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Integer save(ProductReq.ProductInfo req){
        Product product= productRepo.findByNameAndColor(req.getName(),req.getColor());
        if(product==null){
        Boolean check = true;
        if(req.getCount()<=0) check = false;
            product= Product.builder()
                .name(req.getName())
                .color(req.getColor())
                .price(req.getPrice())
                .count(req.getCount())
                .sellable(check)
                .build();
        productRepo.save(product);
        return 0;
        }
        return 1;
    }

    public void newColorNum(ProductReq.ColorNum req) {
        List<Product> products =  productRepo.findByColor(req.getColor());
        for(Product product: products){
            product.setCount(req.getCount());
        }

        productRepo.saveAll(products);
    }

    public List<CategoryAllRes> readCategory() {
        return  productRepo.getGroupedProducts();
    }

    public List<Product> readColor(String color) {
        return productRepo.findByColor(color);
    }

    public Product readProduct(String name, String color) {
        return productRepo.findByNameAndColor(name,color);
    }

    @Transactional
    public Integer fixProduct(Product req) {
        Product product= productRepo.findByNameAndColor(req.getName(),req.getColor());
        if(product==null) {
            product= productRepo.getProductById(req.getId());
            product.updateProduct(req);
            productRepo.save(product);
            return 0;
        }
        else{
            product.setCount(product.getCount()+req.getCount());
            deleteProduct(req);
            return 1;
        }
    }

    public List<ColorCountRes> readColorAll() {
        return productRepo.countByColor();
    }

    public List<ColorCountRes> readProductColor(String name){
        return productRepo.collorCountByName(name);
    }

    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }
}
