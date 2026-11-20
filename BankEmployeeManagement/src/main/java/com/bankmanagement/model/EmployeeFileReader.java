/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankmanagement.model;

/**
 *
 * @author grazimatsuyama
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeFileReader {

    public static ArrayList<Employee> readEmployees(String filename) {

        ArrayList<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename))) {

            String line;
            reader.readLine(); // Skip CSV header

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",", -1);

                if (data.length >= 9) {

                    String name = data[0].trim() + " " + data[1].trim();
                    String department = data[5].trim();
                    String managerType = data[7].trim();

                    if (managerType.isEmpty()) {
                        managerType = "Employee";
                    }

                    employees.add(new Employee(
                            name, managerType, department));
                }
            }

            System.out.println("File read successfully!");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return employees;
    }
}