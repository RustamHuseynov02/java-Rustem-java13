package com.developia.endproject.translateApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developia.endproject.translateApp.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
