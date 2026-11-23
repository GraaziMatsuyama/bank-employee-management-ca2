/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankmanagement.model;

/**
 *
 * @author grazimatsuyama
 */

import java.util.ArrayList;

public class EmployeeValidator {
    
public static boolean isValidName(String name) {
        return name != null
                && !name.trim().isEmpty()
                && name.trim().matches("[\\p{L} .'-]+");
    }

    public static boolean isValidManagerType(String managerType) {
        return managerType != null
                && !managerType.trim().isEmpty();
    }

    public static boolean departmentExists(
            String department,
            ArrayList<Employee> employees) {

        for (Employee employee : employees) {
            if (employee.getDepartment()
                    .equalsIgnoreCase(department.trim())) {
                return true;
            }
        }

        return false;
    }
}
