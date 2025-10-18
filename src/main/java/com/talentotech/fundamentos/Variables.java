package com.talentotech.fundamentos;

/**
 * Ejemplos de variables y tipos de datos en Java
 * Módulo 1: Fundamentos de Java
 */
public class Variables {
    
    public static void main(String[] args) {
        System.out.println("=== Variables y Tipos de Datos ===\n");
        
        // Tipos primitivos
        // Números enteros
        byte edad = 25;                    // 8 bits: -128 a 127
        short year = 2025;                 // 16 bits: -32,768 a 32,767
        int poblacion = 1000000;           // 32 bits: -2^31 a 2^31-1
        long distancia = 384400000L;       // 64 bits: -2^63 a 2^63-1
        
        // Números decimales
        float precio = 19.99f;             // 32 bits, precisión simple
        double pi = 3.141592653589793;     // 64 bits, precisión doble
        
        // Caracteres y booleanos
        char inicial = 'A';                // 16 bits, un carácter Unicode
        boolean esEstudiante = true;       // true o false
        
        // Tipos de referencia
        String nombre = "Talento Tech";    // Cadena de texto
        
        // Impresión de variables
        System.out.println("Edad: " + edad + " años");
        System.out.println("Año: " + year);
        System.out.println("Población: " + poblacion);
        System.out.println("Distancia Tierra-Luna: " + distancia + " metros");
        System.out.println("Precio: $" + precio);
        System.out.println("Valor de PI: " + pi);
        System.out.println("Inicial: " + inicial);
        System.out.println("¿Es estudiante?: " + esEstudiante);
        System.out.println("Nombre: " + nombre);
        
        // Constantes (final)
        final double GRAVEDAD = 9.81;
        System.out.println("\nGravedad terrestre: " + GRAVEDAD + " m/s²");
        
        // Conversión de tipos (casting)
        int numeroEntero = 10;
        double numeroDecimal = numeroEntero;  // Conversión implícita (widening)
        System.out.println("\nConversión implícita: " + numeroDecimal);
        
        double otroDecimal = 9.99;
        int otroEntero = (int) otroDecimal;   // Conversión explícita (narrowing)
        System.out.println("Conversión explícita: " + otroEntero);
    }
}
