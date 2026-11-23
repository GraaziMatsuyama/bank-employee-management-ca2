/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankmanagement.algorithms;

/**
 *
 * @author grazimatsuyama
 */

import com.bankmanagement.model.Employee;
import java.util.ArrayList;

public class BinarySearch {
    public static Employee search(ArrayList<Employee> employees,
                                  String name) {

        return binarySearch(employees, name, 0,
                            employees.size() - 1);
    }

    private static Employee binarySearch(
            ArrayList<Employee> employees,
            String name, int left, int right) {

        if (left > right) {
            return null;
        }

        int middle = left + (right - left) / 2;

        Employee employee = employees.get(middle);

        int comparison = employee.getName()
                .compareToIgnoreCase(name);

        if (comparison == 0) {
            return employee;
        }

        if (comparison > 0) {
            return binarySearch(employees, name,
                                left, middle - 1);
        }

        return binarySearch(employees, name,
                            middle + 1, right);
    }
    
}
