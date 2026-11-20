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

public class MergeSort {

    public static void sort(ArrayList<Employee> employees) {
        if (employees.size() > 1) {
            mergeSort(employees, 0, employees.size() - 1);
        }
    }

    private static void mergeSort(ArrayList<Employee> employees,
                                  int left, int right) {

        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(employees, left, middle);
            mergeSort(employees, middle + 1, right);

            merge(employees, left, middle, right);
        }
    }

    private static void merge(ArrayList<Employee> employees,
                              int left, int middle, int right) {

        ArrayList<Employee> temp = new ArrayList<>();

        int i = left;
        int j = middle + 1;

        while (i <= middle && j <= right) {
            String name1 = employees.get(i).getName();
            String name2 = employees.get(j).getName();

            if (name1.compareToIgnoreCase(name2) <= 0) {
                temp.add(employees.get(i++));
            } else {
                temp.add(employees.get(j++));
            }
        }

        while (i <= middle) {
            temp.add(employees.get(i++));
        }

        while (j <= right) {
            temp.add(employees.get(j++));
        }

        for (int k = 0; k < temp.size(); k++) {
            employees.set(left + k, temp.get(k));
        }
    }
}