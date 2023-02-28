/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arbolbinario;

/**
 *
 * @author ignac
 */
public class ArbolBinario {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
 
        // insertar nodos al árbol
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        // Imprimir el árbol en orden
        System.out.print("Árbol binario en orden: ");
        tree.inorder();
        
        tree.visualiza_arbol();
    }
}
