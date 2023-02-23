package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree {

    public static void main(String[] args) {
        List<Integer> dataInput = Arrays.asList(100, 80, 50, 90, 30, 60, 90, 85, 95, 120, 110, 108, 115, 140, 150);
        Node root = null;

        for (Integer value : dataInput) {
            root = insertNode(root, value);
        }
        //  printLeaves(root);
        System.out.println();
        System.out.println("=====================================");
        System.out.println("LNR");
        printLNR(root);
        System.out.println("=====================================");
        System.out.println("LRN");
        printLRN(root);
        System.out.println("=====================================");
        System.out.println("NLR");
        printNLR(root);
    }

    public static void printLeaves(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.print(root.value + ",  ");
            return;
        }
        if (root.left != null) {
            printLeaves(root.left);
        }
        if (root.right != null) {
            printLeaves(root.right);
        }

    }

    public static void printLRN(Node root) {
        if (root == null) return;
        if (root.left != null) {
            printLRN(root.left);
        }
        if (root.right != null) {
            printLRN(root.right);
        }
        System.out.print(root.value + ",  ");
    }

    public static void printLNR(Node root) {
        if (root == null) return;
        if (root.left != null) {
            printLRN(root.left);
        }
        System.out.print(root.value + ",  ");
        if (root.right != null) {
            printLRN(root.right);
        }
    }

    public static void printNLR(Node root) {
        if (root == null) return;
        if (root.left != null) {
            printNLR(root.left);
        }
        System.out.print(root.value + ",  ");
        if (root.right != null) {
            printNLR(root.right);
        }
    }

    public static Node insertNode(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertNode(root.left, value);
        }
        if (value > root.value) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
