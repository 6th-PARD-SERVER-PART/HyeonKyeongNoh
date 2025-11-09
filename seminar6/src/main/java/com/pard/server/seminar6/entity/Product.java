package com.pard.server.seminar6.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String color;

    private Integer price;
    private Integer count;
    private boolean sellable;

    public void setCount(Integer newCount){
        this.count= newCount;
        this.sellable = newCount>0;
    }

    public void updateProduct(Product req) {
        this.name = req.getName();
        this.color = req.getColor();
        this.price = req.getPrice();
        this.count = req.getCount();
        this.sellable = count>0;
    }
}
