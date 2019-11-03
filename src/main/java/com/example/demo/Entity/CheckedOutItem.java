package com.example.demo.Entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CheckedOutItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userEmail;
    private long productid;
    private String productBarcodeNumber;
    private String productName;
    private boolean productIsCheckedOut;
    private int productQuantity;
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkedOutDate;
    private String businessName;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public String getProductBarcodeNumber() {
        return productBarcodeNumber;
    }

    public void setProductBarcodeNumber(String productBarcodeNumber) {
        this.productBarcodeNumber = productBarcodeNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isProductIsCheckedOut() {
        return productIsCheckedOut;
    }

    public void setProductIsCheckedOut(boolean productIsCheckedOut) {
        this.productIsCheckedOut = productIsCheckedOut;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Date getCheckedOutDate() {
        return checkedOutDate;
    }

    public void setCheckedOutDate(Date checkedOutDate) {
        this.checkedOutDate = checkedOutDate;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}
