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
    
}
