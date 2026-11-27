/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bankmanagement.model;

/**
 *
 * @author grazimatsuyama
 */

import java.util.Queue;
import java.util.LinkedList;

import java.util.ArrayList;


public class BinaryTree {
    
     private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(Employee employee) {

        TreeNode newNode = new TreeNode(employee);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            } else {
                queue.add(current.getLeft());
            }

            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            } else {
                queue.add(current.getRight());
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }
            
            
     public ArrayList<ArrayList<Employee>> levelOrderTraversal() {
         
             ArrayList<ArrayList<Employee>> levels = new ArrayList<>();

        if (root == null) {
          return levels;
            
    }   

           Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);


              while (!queue.isEmpty()) {

              int levelSize = queue.size();

        ArrayList<Employee> currentLevel = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {

                    TreeNode current = queue.poll();

                    currentLevel.add(current.getEmployee());

                    if (current.getLeft() != null) {
                        queue.add(current.getLeft());
                    }

                    if (current.getRight() != null) {
                        queue.add(current.getRight());
                    }
                }

                levels.add(currentLevel);
            }

            return levels;
        }
    
     
                
        public int getHeight() {
            return calculateHeight(root);
            
            }

            private int calculateHeight(TreeNode node) {

                if (node == null) {
               return -1;
    }

            int leftHeight = calculateHeight(node.getLeft());
            int rightHeight = calculateHeight(node.getRight());

                return 1 + Math.max(leftHeight, rightHeight);
        }

            
        public int getNodeCount() {
            return countNodes(root);
        }

        private int countNodes(TreeNode node) {

            if (node == null) {
                return 0;
    }

            return 1
             + countNodes(node.getLeft())
             + countNodes(node.getRight());
        }

}
