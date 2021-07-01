/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sa.SpringRest_Employee_NhuY.service;

import com.sa.SpringRest_Employee_NhuY.entity.Employee;
import com.sa.SpringRest_Employee_NhuY.exception.EmployeeNotFoundExcecption;
import com.sa.SpringRest_Employee_NhuY.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PhamNgocNhuY_18055121
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void save(Employee e) {
        employeeRepository.save(e);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
        
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> r= employeeRepository.findById(id);
        Employee e= null;
        if(r.isPresent()){
            e=r.get();
        }else{
            throw new EmployeeNotFoundExcecption(id);
        }
        return e;
    }
    
}
