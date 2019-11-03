package com.example.demo.Controller;

import com.example.demo.Dto.Error;
import com.example.demo.Dto.ResponseInt;
import com.example.demo.Entity.Product;
import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.Service.ProductService;
import com.example.demo.Util.ErrorObj;
import com.example.demo.Util.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CheckedOutItemController checkedOutItemController;

    @GetMapping
    public Iterable<Product> getAllProducts(){
        Iterable<Product> response = productService.getAllProducts();
        return response;
    }
    @GetMapping("/business")
    public Iterable<Product> getAllProductsByBusiness(@RequestParam String businessName){
        Iterable<Product> response = productService.getAllProductsByBusinessName(businessName);
        return response;
    }
    @GetMapping("/barcode")
    public Product getProductByBarcodeNumber(@RequestParam String barcodeNumber,String businessName) throws ProductNotFoundException {
        return productService.getProductByBarcodeNumber(barcodeNumber,businessName);
    }

    @GetMapping("/global/id")
    public Product getProductById(@RequestParam Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @GetMapping("/id")
    public Product getProductByIdAndBusinessName(@RequestParam long id,@RequestParam String businessName) throws ProductNotFoundException {
        return productService.getProductByIdAndBusinessName(id,businessName);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product){
           try{

           }catch(Exception ex){
               System.out.println("Error product quantity should be integer");
               ErrorObj errorObj = ErrorResponse.errorResponse("Error product quantity should be integer",ex.getMessage(),"400");
               return new ResponseEntity<>(errorObj,HttpStatus.BAD_REQUEST);
           }

        return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.ACCEPTED);
    }

    @PutMapping("/checkout")
    public ResponseEntity<?> checkoutProduct(@RequestParam String id, @RequestParam String businessName){
        Product product = productService.getProductByBarcodeNumber(id,businessName);
        if(product == null){
            throw new RuntimeException("Product with given barcode number could not be found!");
        }
        ResponseInt err;
        try{
            productService.checkOutProduct(product);
        }catch (Exception e){
             err = new Error();
             ((Error) err).setMessage(e.getMessage());
             ((Error) err).setHttpStatus(HttpStatus.BAD_REQUEST);
             return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
        }
        productService.saveProduct(product);

        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){ Product response = productService.updateProduct(product);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam long id){
        try {
            productService.deleteProduct(id);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

}
