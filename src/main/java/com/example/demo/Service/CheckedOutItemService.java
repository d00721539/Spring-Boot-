package com.example.demo.Service;

import com.example.demo.Entity.CheckedOutItem;
import com.example.demo.Repository.CheckedOutItemRepository;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckedOutItemService {

    @Autowired
    private CheckedOutItemRepository checkedOutItemRepository;

    public Iterable<CheckedOutItem> findAllCheckedOutItemsByUserEmail(String email){
        return checkedOutItemRepository.findCheckedOutItemByUserEmail(email);
    }

    public CheckedOutItem saveCheckedOutItem(CheckedOutItem checkedOutItem){
        return checkedOutItemRepository.save(checkedOutItem);
    }

    public List<CheckedOutItem> findAllCheckedOutItemsByBusiness(String businessName){
        return checkedOutItemRepository.findCheckedOutItemByBusinessName(businessName);
    }
}
