package com.example.demojpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demojpa.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}