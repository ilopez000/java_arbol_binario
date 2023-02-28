package com.mycompany.arbolbinario;

import java.util.Arrays;

public class BinaryTree {
    
    // clase interna para representar un nodo del árbol
    class Node {
        int key;
        Node left;
        Node right;
        
        public Node(int item) {
            key = item;
            left = null;
            right = null;
        }
    }
    
    Node root; // raíz del árbol
    
    // Constructor por defecto
    public BinaryTree() {
        root = null;
    }
    
    // Método para insertar un nuevo nodo en el árbol
    public void insert(int key) {
        root = insertRec(root, key);
    }
    
    /* Una función recursiva para insertar un nuevo nodo en el árbol */
    private Node insertRec(Node root, int key) {
        
        /* Si el árbol está vacío, crea un nuevo nodo y devuelve */
        if (root == null) {
            root = new Node(key);
            return root;
        }
        
        /* De lo contrario, recursivamente atraviesa el árbol */
        if (key < root.key){
            root.left = insertRec(root.left, key);
        }else if (key > root.key){
            root.right = insertRec(root.right, key);
        }
        /* devuelve el puntero del nodo (sin cambios) */
        return root;
    }
    
    // Método para imprimir el árbol en orden
    public void inorder() {
        inorderRec(root);
    }
    
    // Una función recursiva para realizar un recorrido en orden en el árbol
    private void inorderRec(Node n) {
        if (n != null) {
            inorderRec(n.left);
            System.out.print(n.key + " ");
            inorderRec(n.right);
        }
    }
    
    //función para imprimir el árbol tal y como está por niveles
    public void visualiza_arbol(){
        System.out.println("-------");
        System.out.println();
        printTree(root);
        System.out.println("-------");
    }
    
    public void printTree(Node root) {
    int treeHeight = getHeight(root);
    int width = (int) Math.pow(3, treeHeight) - 1;
    String[][] res = new String[treeHeight][width];
    for (String[] arr : res) {
        Arrays.fill(arr, " ");
    }
    fill(res, root, 0, 0, width - 1);
    for (String[] arr : res) {
        System.out.println(String.join("", arr));
    }
}

private static void fill(String[][] res, Node node, int level, int left, int right) {
    if (node == null) {
        return;
    }
    int mid = left + (right - left) / 2;
    res[level][mid] = Integer.toString(node.key);
    fill(res, node.left, level + 1, left, mid - 1);
    fill(res, node.right, level + 1, mid + 1, right);
}

private static int getHeight(Node node) {
    if (node == null) {
        return 0;
    }
    int leftHeight = getHeight(node.left);
    int rightHeight = getHeight(node.right);
    return Math.max(leftHeight, rightHeight) + 1;
}

}

