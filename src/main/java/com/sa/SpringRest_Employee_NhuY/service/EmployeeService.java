/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sa.SpringRest_Employee_NhuY.service;

import com.sa.SpringRest_Employee_NhuY.entity.Employee;
import java.util.List;

/**
 *
 * @author PhamNgocNhuY_18055121
 */
public interface EmployeeService {
    public void save(Employee e);
    public void deleteById(int id);
    public List<Employee> findAll();
    public Employee findById(int id);
}
