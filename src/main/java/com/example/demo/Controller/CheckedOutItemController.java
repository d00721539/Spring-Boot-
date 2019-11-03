package com.example.demo.Controller;

import com.example.demo.Entity.CheckedOutItem;
import com.example.demo.Service.CheckedOutItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("checkout")
public class CheckedOutItemController {

    @Autowired
    private CheckedOutItemService checkedOutItemService;

    @GetMapping
    public Iterable<CheckedOutItem> findAll(@RequestParam String email){
        return checkedOutItemService.findAllCheckedOutItemsByUserEmail(email);
    }
    @GetMapping("/business")
    public Iterable<CheckedOutItem> findAllByBusiness(@RequestParam String businessName){
        return checkedOutItemService.findAllCheckedOutItemsByBusiness(businessName);
    }
    @PostMapping
    public CheckedOutItem saveCheckedOutItem(@RequestBody CheckedOutItem checkedOutItem){
        return checkedOutItemService.saveCheckedOutItem(checkedOutItem);
    }

}
