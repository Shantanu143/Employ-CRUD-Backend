package com.employee.employerestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.employerestapi.model.Employe;
import com.employee.employerestapi.service.EmpService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/")
public class EmpController {
    
    @Autowired
    private EmpService empService;  
    
    @PostMapping("/save")
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
        
        return new ResponseEntity<Employe>(empService.createEmploye(employe), HttpStatus.CREATED);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Employe>> getAllEmploye() {
        return new ResponseEntity<List<Employe>>(empService.getAllEmployes(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable int id) {
        return new ResponseEntity<Employe>(empService.getEmployeById(id), HttpStatus.OK);
    }
    
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmploye(@PathVariable int id) {
        empService.deleteEmployeById(id);
        return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable int id, @RequestBody Employe employe) {
        return new ResponseEntity<>(empService.updateEmploye(id, employe), HttpStatus.OK);
    }
}
