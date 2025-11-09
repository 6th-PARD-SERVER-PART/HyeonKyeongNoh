package com.pard.server.seminar6.repo;

import com.pard.server.seminar6.dto.CategoryAllRes;
import com.pard.server.seminar6.dto.ColorCountRes;
import com.pard.server.seminar6.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findByColor(String color);

    @Query("SELECT new com.pard.server.seminar6.dto.CategoryAllRes(" +
            "p.name, MIN(p.price), SUM(p.count), " +
            "CASE WHEN SUM(p.count) > 0 THEN true ELSE false END) " +
            "FROM Product p GROUP BY p.name")
    List<CategoryAllRes> getGroupedProducts();

    @Query("SELECT new com.pard.server.seminar6.dto.ColorCountRes(p.color, SUM(p.count) AS count) FROM Product p GROUP BY p.color")
    List<ColorCountRes> countByColor();

    @Query("SELECT new com.pard.server.seminar6.dto.ColorCountRes(p.color, p.count) FROM Product p WHERE p.name = :name")
    List<ColorCountRes> collorCountByName(String name);

    Product findByNameAndColor(String name, String color);

    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Product getProductById(int id);
}
