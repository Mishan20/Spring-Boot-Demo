package com.learnspringboot.demo.repository;

import com.learnspringboot.demo.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepo extends JpaRepository<Phone, Integer>{
}
