package com.example.demo.Repository;

import com.example.demo.Entity.CheckedOutItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckedOutItemRepository extends CrudRepository<CheckedOutItem,Long> {
     List<CheckedOutItem> findCheckedOutItemByUserEmail(String email);
     List<CheckedOutItem> findCheckedOutItemByBusinessName(String businessName);
}
