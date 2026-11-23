/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.bankmanagement.enums;

/**
 *
 * @author grazimatsuyama
 */
public enum MenuOption {
    
    SORT(1),
    SEARCH(2),
    ADD_RECORDS(3),
    BINARY_TREE(4),
    EXIT(5);
    
    private final int value;

    MenuOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MenuOption fromValue(int value) {
        for (MenuOption option : values()) {
            if (option.getValue() == value) {
                return option;
            }
        }
        return null;
    }
}
