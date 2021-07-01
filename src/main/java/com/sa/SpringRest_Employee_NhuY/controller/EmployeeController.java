/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sa.SpringRest_Employee_NhuY.controller;

import com.sa.SpringRest_Employee_NhuY.entity.Employee;
import com.sa.SpringRest_Employee_NhuY.exception.EmployeeNotFoundExcecption;
import com.sa.SpringRest_Employee_NhuY.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PhamNgocNhuY_18055121
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        List<Employee> list = employeeService.findAll();
        return list;
    }
    
    @GetMapping("/employee/{emId}")
    public Employee getEmployee(@PathVariable int emId){
        Employee e = employeeService.findById(emId);
        return e;
    }
    
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee e){
        employeeService.save(e);
        return e;
    }
    
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee e){
            Employee e1= employeeService.findById(e.getId());
             
                e1.setFirstName(e.getFirstName());
                e1.setLastName(e.getLastName());
                e1.setPosition(e.getPosition());
                employeeService.save(e1);
                return e1;
          
    }
    
    @DeleteMapping("/employee/{emId}")
    public String deteteEmployee(@PathVariable int emId){
        Employee e= employeeService.findById(emId);
        if(e==null){
            throw new EmployeeNotFoundExcecption(emId);
        }else{
            employeeService.deleteById(emId);
            return "Delete sucess employeeId= "+emId;
        }
        
    }
    
}
