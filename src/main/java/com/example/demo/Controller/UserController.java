package com.example.demo.Controller;

import com.example.demo.Dto.Error;
import com.example.demo.Dto.ResponseInt;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/business")
    public List<User> getBusinessOwners(){
        return userService.getBusinessOwners();
    }

    @GetMapping("/global")
    public List<User> getUsersForGlobal(){
        return userService.getUsersForGlobal();
    }
    @GetMapping("/id")
    public User getUserById(@RequestParam Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/local")
    public List<User> getLocalUsers(@RequestParam String role, @RequestParam String businessName){
        return userService.getLocalUsers(role,businessName);
    }
    @GetMapping("/admin/local/id")
    public User getLocalForAdmin(@RequestParam long id, @RequestParam String businessName, @RequestParam String role){
        return userService.getLocalForAdmin(id,businessName,role);
    }

    @GetMapping("/local/id")
    public User getLocalUserById(@RequestParam long id, @RequestParam String role){
        return userService.getLocalUserById(id,role);
    }

    @GetMapping("/business/id")
    public User getBusinessUserById(@RequestParam long id){
        return userService.getBusinessUserById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        User userObj ;
        ResponseInt res;
        try{
            userObj = userService.loginUser(user);
        }catch (Exception e){
            throw new RuntimeException("Check your email or password");
        }
        if(userObj.isAccountDisabledStatus() == true){
            throw new RuntimeException("Your account has been disabled!");
        }
        return new ResponseEntity(userObj,HttpStatus.OK);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
       userService.saveUser(user);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);

    }

    @DeleteMapping("/deletelocal")
    public void deleteLocalUser(@RequestParam long id, @RequestParam String role, @RequestParam String businessName){
        userService.deleteLocalUser(id,role,businessName);
    }

    @DeleteMapping("/deletebusiness")
    public void deleteBusinessUser(@RequestParam long id, @RequestParam String role){
        userService.deleteBusinessUser(id,role);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam long id){
        userService.deleteUser(id);
    }
}
