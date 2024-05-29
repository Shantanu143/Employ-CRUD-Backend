package com.employee.employerestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employerestapi.model.Employe;
import com.employee.employerestapi.repositories.EmpRepositories;

@Service
public class EmpServiceImp implements EmpService {

    @Autowired
    private EmpRepositories empRepo;

    @Override
    public Employe createEmploye(Employe employe) {
        return empRepo.save(employe);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return empRepo.findAll();
    }

    @Override
    public Employe getEmployeById(int id) {
        return empRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployeById(int id) {
        empRepo.findById(id).ifPresent(empRepo::delete);
    }

    @Override
    public Employe updateEmploye(int id, Employe employe) {
        return empRepo.findById(id).map(oldEmp -> {
            employe.setId(id);
            return empRepo.save(employe);
        }).orElse(null);
    }

}
