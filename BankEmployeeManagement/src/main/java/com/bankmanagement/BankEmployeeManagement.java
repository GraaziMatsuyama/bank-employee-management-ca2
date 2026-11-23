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
import com.bankmanagement.algorithms.BinarySearch;
import com.bankmanagement.enums.MenuOption;
import com.bankmanagement.view.MenuView;

import java.util.ArrayList;
import java.util.Scanner;

public class BankEmployeeManagement {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

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
                    MergeSort.sort(employees);

                    System.out.println("\nFIRST 20 EMPLOYEES (A-Z)");

                    for (int i = 0;
                            i < Math.min(20, employees.size()); i++) {

                        System.out.println((i + 1) + ". "
                                + employees.get(i).getName());
                    }
                    break;

                case SEARCH:
                    System.out.print("Enter employee full name: ");
                    String name = scanner.nextLine().trim();

                    Employee result =
                            BinarySearch.search(employees, name);

                    if (result != null) {
                        System.out.println("Employee found!");
                        System.out.println(result);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case ADD_RECORDS:
                    System.out.println(
                            "Add Employee - Coming soon.");
                    break;

                case BINARY_TREE:
                    System.out.println(
                            "Binary Tree - Coming soon.");
                    break;

                case EXIT:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
            }
        }

        scanner.close();
    }
}
