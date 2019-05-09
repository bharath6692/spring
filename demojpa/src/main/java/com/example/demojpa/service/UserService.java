package com.example.demojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demojpa.dao.UserDao;
import com.example.demojpa.entity.User;

@Service
 public class UserService {
     @Autowired
     UserDao userDao;
 
     public List<User> getAllUsers() {
         return this.userDao.findAll();
     }
     
     public User getUser(int id) {
    	 System.out.println("id = " + id);
         Optional<User> user =  userDao.findById(id);
        return user.isPresent() ? user.get() : null;
     }
 
     public User addUser(User user) {
         return this.userDao.save(user);
     }
 
     //other methods omitted for brevity
 }