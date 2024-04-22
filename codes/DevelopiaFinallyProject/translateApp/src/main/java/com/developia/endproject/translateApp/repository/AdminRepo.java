package com.developia.endproject.translateApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developia.endproject.translateApp.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
