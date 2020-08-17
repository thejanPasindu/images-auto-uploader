package com.aplova.productimagesautouploader.dao;

import com.aplova.productimagesautouploader.model.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDaoInterface extends JpaRepository<ProductData, String> {
    @Query("FROM ProductData p WHERE p.business = ?1") //p.images = '{}' AND
    List<ProductData> findAllProductNotHavingImage(String businessId);
}
