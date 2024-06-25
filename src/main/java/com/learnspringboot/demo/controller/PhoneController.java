package com.learnspringboot.demo.controller;

import com.learnspringboot.demo.entity.Phone;
import com.learnspringboot.demo.repository.PhoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // This annotation is used to mark the class as a REST controller
@RequestMapping("/phone") // This annotation is used to map the URL to the class
public class PhoneController {

    private final PhoneRepo phoneRepo; // This is a dependency injection

    @Autowired // This annotation is used to inject the dependency
    public PhoneController(PhoneRepo phoneRepo) {
        this.phoneRepo = phoneRepo;
    }

    @PostMapping("/save") // This annotation is used to map the URL to the method
    public ResponseEntity<Phone> savePhone(@RequestBody Phone phone){
        // This method is used to save a phone
        Phone save = phoneRepo.save(phone);

        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("/get") // This annotation is used to map the URL to the method
    public void getAllPhones(){
        // This method is used to get all phones
    }

    @DeleteMapping("/delete") // This annotation is used to map the URL to the method
    public void deletePhone(){
        // This method is used to delete a phone
    }

    @PutMapping("/update") // This annotation is used to map the URL to the method
    public void updatePhone(){
        // This method is used to update a phone
    }
}
