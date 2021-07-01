/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sa.SpringRest_Employee_NhuY.exception;

/**
 *
 * @author PhamNgocNhuY_18055121
 */
public class EmployeeNotFoundExcecption extends RuntimeException{

    public EmployeeNotFoundExcecption(int id) {
        super("Could not found employee id= "+ id);
    }
    
}
