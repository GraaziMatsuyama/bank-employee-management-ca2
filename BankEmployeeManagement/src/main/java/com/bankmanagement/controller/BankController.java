/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankmanagement.controller;

/**
 *
 * @author grazimatsuyama
 */

import com.bankmanagement.model.Employee;
import com.bankmanagement.model.EmployeeFileReader;
import com.bankmanagement.model.EmployeeValidator;
import com.bankmanagement.model.BinaryTree;
import com.bankmanagement.algorithms.MergeSort;
import com.bankmanagement.algorithms.BinarySearch;
import com.bankmanagement.enums.MenuOption;
import com.bankmanagement.view.MenuView;

import java.util.ArrayList;
import java.util.Scanner;


    public class BankController {
    
        private final ArrayList<Employee> employees;
        private final Scanner scanner;

        public BankController() {

         scanner = new Scanner(System.in);

        employees = EmployeeFileReader.readEmployees(
                "data/Applicants_Form.txt");

    MergeSort.sort(employees);
        
        }
        
        public void start() {

    if (employees.isEmpty()) {
        System.out.println("No employees available.");
        scanner.close();
        return;
    }

    boolean running = true;

    while (running) {

        MenuView.displayMenu();

        String input = scanner.nextLine().trim();
        int choice;

        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid option. Try again.");
            continue;
        }

        MenuOption option = MenuOption.fromValue(choice);

               if (option == null) {
            System.out.println("Invalid option. Try again.");
            continue;
        }

        switch (option) {

            case SORT:
                sortEmployees();
                break;

            case SEARCH:
                searchEmployee();
                break;

            case ADD_RECORDS:
                addEmployee();
                break;

            case BINARY_TREE:
                displayBinaryTree();
                break;

            case EXIT:
                System.out.println("Goodbye!");
                running = false;
                break;
        }
    }

    scanner.close();
    
        }
        
       private void sortEmployees() {

            MergeSort.sort(employees);
            MenuView.displaySortedEmployees(employees);
        }

       private void searchEmployee() {

           MenuView.displaySearchPrompt();

           String name = scanner.nextLine().trim();

           Employee result = BinarySearch.search(employees, name);

           MenuView.displaySearchResult(result);
    }

       private void addEmployee() {

            MenuView.displayMessage("\nADD NEW EMPLOYEE");

            MenuView.displayPrompt("Enter employee full name: ");
                String newName = scanner.nextLine().trim();

         if (!EmployeeValidator.isValidName(newName)) {
            MenuView.displayMessage("Invalid employee name.");
                
            return;
     }

            MenuView.displayPrompt("Enter manager type: ");
                String managerType = scanner.nextLine().trim();

         if (!EmployeeValidator.isValidManagerType(managerType)) {
                 MenuView.displayMessage("Invalid manager type.");
        
                 return;
    }

    ArrayList<String> departments = new ArrayList<>();

        for (Employee employee : employees) {

            String dept = employee.getDepartment();
            boolean exists = false;

        for (String existing : departments) {
           
            if (existing.equalsIgnoreCase(dept)) {
                exists = true;
                break;
            }
        }

        if (!exists && !dept.isEmpty()) {
            departments.add(dept);
        }
    }

        MenuView.displayDepartments(departments);

        MenuView.displayPrompt("\nEnter department: ");
        String newDepartment = scanner.nextLine().trim();

        if (!EmployeeValidator.departmentExists(
            newDepartment, employees)) {

        MenuView.displayMessage(
                "Invalid department. Choose an existing one.");
        return;
    }

        Employee newEmployee =
            new Employee(newName, managerType, newDepartment);

        employees.add(newEmployee);

     MergeSort.sort(employees);

     MenuView.displayNewEmployee(newEmployee);
    }
       
       
    private void displayBinaryTree() {

        MenuView.displayMessage("\nEMPLOYEE BINARY TREE");
        MenuView.displayMessage("================================");

     BinaryTree tree = new BinaryTree();

        for (Employee employee : employees) {
            tree.insert(employee);
         }

    MenuView.displayMessage("Binary tree created successfully!");

    MenuView.displayMessage("\nEMPLOYEE HIERARCHY");
    MenuView.displayMessage("================================");

         tree.levelOrderTraversal();

    MenuView.displayTreeStatistics(tree);
}

}
