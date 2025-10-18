package com.talentotech.poo;

/**
 * Clase de ejemplo para conceptos de POO
 * Módulo 2: Programación Orientada a Objetos
 */
public class Persona {
    // Atributos privados (Encapsulamiento)
    private String nombre;
    private int edad;
    private String email;
    
    // Constructor sin parámetros
    public Persona() {
        this.nombre = "Sin nombre";
        this.edad = 0;
        this.email = "sin@email.com";
    }
    
    // Constructor con parámetros
    public Persona(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }
    
    // Constructor con algunos parámetros
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = "sin@email.com";
    }
    
    // Getters y Setters (Encapsulamiento)
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        if (edad >= 0 && edad <= 150) {
            this.edad = edad;
        } else {
            System.out.println("Edad inválida");
        }
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Métodos
    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre);
    }
    
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Email: " + email);
    }
    
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }
    
    // Override del método toString
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                '}';
    }
}
