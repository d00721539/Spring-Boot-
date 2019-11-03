package com.example.demo.Repository;

import com.example.demo.Entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {
        Product findByBarcodeNumberAndBusinessName(String barcodeNumber, String businessName);
        Product findByIdAndBusinessName(Long id,String businessName);
        List<Product> findAllByBusinessName(String businessName);
}
