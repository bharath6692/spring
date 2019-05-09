package com.example.demojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.entity.User;
import com.example.demojpa.service.UserService;

 @RestController
 @RequestMapping("/user") //this means you need to call http://localhost:8034/user/all , http://localhost:8034/user/adduser
 public class UserController {
     @Autowired
     UserService userService;
 
     @RequestMapping(value = "/all", method = RequestMethod.GET)
     public List<User> getAllUsers() {
         return userService.getAllUsers();
     }
 
     @RequestMapping(value = "/{id}", method = RequestMethod.GET)
     public User getUser(@PathVariable int id) {
         User user =  userService.getUser(id);
         return user;
     }
     
     @RequestMapping(value = "/adduser", method = RequestMethod.POST,
             consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseBody()
     public User addNewUser(@RequestBody User user) {
         return this.userService.addUser(user);
     }
     
     //other controllers omitted for brevity
 
 }