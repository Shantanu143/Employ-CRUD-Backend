
package com.employee.employerestapi.service;

import java.util.List;

import com.employee.employerestapi.model.Employe;

public interface EmpService {

    Employe createEmploye(Employe employe);
    List<Employe> getAllEmployes();
    Employe getEmployeById(int id);
    void deleteEmployeById(int id);
    Employe updateEmploye(int id, Employe employe);
    
}
