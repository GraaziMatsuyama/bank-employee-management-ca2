/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.bankmanagement;

/**
 *
 * @author grazimatsuyama
 */
import com.bankmanagement.model.Employee;
import com.bankmanagement.model.EmployeeFileReader;
import com.bankmanagement.algorithms.MergeSort;
import java.util.ArrayList;

public class BankEmployeeManagement {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println(" BANK EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("================================");
        System.out.println("Welcome to the Bank Management System!");
        
        ArrayList<Employee> employees =
                EmployeeFileReader.readEmployees(
                        "data/Applicants_Form.txt");

        System.out.println("Total employees loaded: "
                + employees.size());

        if (employees.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }
        
        // Recursive Merge Sort
        MergeSort.sort(employees);

        System.out.println("\nFIRST 20 EMPLOYEES (A-Z)");
        System.out.println("================================");

        for (int i = 0; i < Math.min(20, employees.size()); i++) {
            System.out.println((i + 1) + ". "
                    + employees.get(i).getName());
        }

    }
}
