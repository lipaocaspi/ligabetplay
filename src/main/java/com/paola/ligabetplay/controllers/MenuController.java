package com.paola.ligabetplay.controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {

    public int verifyValue(String message) {
        while (true) {
            try {
                System.out.println("---");
                System.out.println(message);
                System.out.println("---");
                Scanner sc = new Scanner(System.in);
                int valor = sc.nextInt();
                if (valor >= 0) {
                    return valor;
                } else {
                    System.out.println("---");
                    System.out.println("Ingrese un valor válido");
                    System.out.println("---");
                }
            } catch (InputMismatchException e) {
                System.out.println("---");
                System.out.println("Tipo de dato incorrecto");
                System.out.println("---");
            }
        }
    }
}
