package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductByBarcodeNumber(String barcodeNumber, String businessName){
        return productRepository.findByBarcodeNumberAndBusinessName(barcodeNumber,businessName);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void checkOutProduct(Product product){
        Product productToBeCheckedOut = product;
        if(productToBeCheckedOut.getQuantity()>0){
            productToBeCheckedOut.setQuantity(productToBeCheckedOut.getQuantity()-1);
        }else{
            throw new RuntimeException("Product quantity can not be less than zero!");
        }
    }
    public Product updateProduct(Product product){
            Product productInDb = productRepository.findById(product.getId()).get();
            productInDb.setBarcodeNumber(product.getBarcodeNumber());
            productInDb.setQuantity(product.getQuantity());
            productInDb.setName(product.getName());
            productRepository.save(productInDb);
        return productInDb;
    }
    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }
    public Product getProductByIdAndBusinessName(Long id,String businessName){
        return productRepository.findByIdAndBusinessName(id,businessName);
    }
    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }
    public List<Product> getAllProductsByBusinessName(String businessName){
        return productRepository.findAllByBusinessName(businessName);
    }
}
