package com.learnspringboot.demo.controller;

import com.learnspringboot.demo.entity.Phone;
import com.learnspringboot.demo.repository.PhoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<Phone>> getAllPhones(){
        // This method is used to get all phones
        List<Phone> allPhones = phoneRepo.findAll();
        return new ResponseEntity<>(allPhones, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}") // This annotation is used to map the URL to the method
    public ResponseEntity<String> deletePhone(@PathVariable Integer id){
        // This method is used to delete a phone
        if (phoneRepo.existsById(id)){
            phoneRepo.deleteById(id);
            return new ResponseEntity<>("Phone deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Phone not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}") // This annotation is used to map the URL to the method
    public ResponseEntity<String> updatePhone(@PathVariable Phone phone){
        // This method is used to update a phone
        if (phoneRepo.existsById(phone.getId())){
            phoneRepo.save(phone);
            return new ResponseEntity<>("Phone updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Phone not found", HttpStatus.NOT_FOUND);
    }
}
