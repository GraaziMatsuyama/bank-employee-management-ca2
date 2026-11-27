/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankmanagement.view;

/**
 *
 * @author grazimatsuyama
 */

import com.bankmanagement.enums.MenuOption;
import com.bankmanagement.model.Employee;
import com.bankmanagement.model.BinaryTree;

import java.util.ArrayList;

public class MenuView {
    
     public static void displayMenu() {

        System.out.println("\n================================");
        System.out.println(" BANK EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("================================");

        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getValue() + ". "
                    + option.name().replace("_", " "));
        }

        System.out.print("\nSelect an option: ");
    }
     
        
     public static void displaySortedEmployees(
        
            ArrayList<Employee> employees) {

        System.out.println("\nFIRST 20 EMPLOYEES (A-Z)");
        System.out.println("================================");

       for (int i = 0; i < Math.min(20, employees.size()); i++) {
        
        System.out.println((i + 1) + ". "
              + employees.get(i).getName());
              }
          }

     public static void displaySearchPrompt() {
         System.out.print("Enter employee full name: ");
          }

     public static void displaySearchResult(Employee employee) {

         if (employee != null) {
        System.out.println("\nEmployee found!");
        System.out.println(employee);
         
         } else {
        System.out.println("\nEmployee not found.");
         }
     }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

     public static void displayPrompt(String message) {
         System.out.print(message);
    }

     public static void displayDepartments(
        ArrayList<String> departments) {

        System.out.println("\nAvailable departments:");

     for (String department : departments) {
        System.out.println("- " + department);
        }
    }

    public static void displayNewEmployee(Employee employee) {

        System.out.println("\nEmployee added successfully!");
        System.out.println(employee);
    }
        
        
    public static void displayTreeStatistics(BinaryTree tree) {

         System.out.println("\nTREE STATISTICS");
        System.out.println("================================");

        System.out.println("Total nodes: " + tree.getNodeCount());
        System.out.println("Tree height: " + tree.getHeight());
        System.out.println("Total levels: " + (tree.getHeight() + 1));
    }


}
