package com.aplova.productimagesautouploader.dao;

import com.aplova.productimagesautouploader.model.BusinessData;
import com.aplova.productimagesautouploader.model.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessDaoInterface  extends JpaRepository<BusinessData, String> {
}
