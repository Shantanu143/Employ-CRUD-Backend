package com.employee.employerestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.employerestapi.model.Employe;

public interface EmpRepositories extends JpaRepository<Employe, Integer> {


    
}
