package com.talentotech.io;

import java.io.*;
import java.util.Scanner;

/**
 * Ejemplos de entrada/salida en Java
 * Módulo 5: Entrada/Salida
 */
public class EntradaSalida {
    
    public static void main(String[] args) {
        System.out.println("=== Entrada y Salida ===\n");
        
        // 1. Lectura desde consola con Scanner
        ejemploScanner();
        
        // 2. Escritura en archivo
        ejemploEscrituraArchivo();
        
        // 3. Lectura de archivo
        ejemploLecturaArchivo();
        
        // 4. Escritura con BufferedWriter
        ejemploBufferedWriter();
        
        // 5. Lectura con BufferedReader
        ejemploBufferedReader();
        
        System.out.println("\n¡Ejemplos completados!");
    }
    
    /**
     * Ejemplo de lectura desde consola
     */
    public static void ejemploScanner() {
        System.out.println("1. Scanner (Lectura desde consola):");
        System.out.println("   Ejemplo comentado - descomenta para probar interactivamente");
        
        /*
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("   Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("   Ingresa tu edad: ");
        int edad = scanner.nextInt();
        
        System.out.println("   Hola " + nombre + ", tienes " + edad + " años");
        
        scanner.close();
        */
    }
    
    /**
     * Ejemplo de escritura en archivo
     */
    public static void ejemploEscrituraArchivo() {
        System.out.println("\n2. Escritura en archivo:");
        String nombreArchivo = "/tmp/ejemplo.txt";
        
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("Hola desde Java!\n");
            writer.write("Esta es la segunda línea.\n");
            writer.write("Talento Tech - Curso de Java\n");
            System.out.println("   ✓ Archivo escrito correctamente: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("   Error al escribir el archivo: " + e.getMessage());
        }
    }
    
    /**
     * Ejemplo de lectura de archivo
     */
    public static void ejemploLecturaArchivo() {
        System.out.println("\n3. Lectura de archivo:");
        String nombreArchivo = "/tmp/ejemplo.txt";
        
        try (FileReader reader = new FileReader(nombreArchivo)) {
            int caracter;
            System.out.println("   Contenido del archivo:");
            while ((caracter = reader.read()) != -1) {
                System.out.print((char) caracter);
            }
        } catch (IOException e) {
            System.out.println("   Error al leer el archivo: " + e.getMessage());
        }
    }
    
    /**
     * Ejemplo de escritura con BufferedWriter (más eficiente)
     */
    public static void ejemploBufferedWriter() {
        System.out.println("\n4. BufferedWriter:");
        String nombreArchivo = "/tmp/datos.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("Nombre,Edad,Ciudad");
            writer.newLine();
            writer.write("Ana,25,Madrid");
            writer.newLine();
            writer.write("Carlos,30,Barcelona");
            writer.newLine();
            writer.write("María,28,Valencia");
            writer.newLine();
            System.out.println("   ✓ Datos escritos con BufferedWriter: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
    }
    
    /**
     * Ejemplo de lectura con BufferedReader (más eficiente)
     */
    public static void ejemploBufferedReader() {
        System.out.println("\n5. BufferedReader:");
        String nombreArchivo = "/tmp/datos.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("   Contenido del archivo:");
            while ((linea = reader.readLine()) != null) {
                System.out.println("   " + linea);
            }
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
    }
}
