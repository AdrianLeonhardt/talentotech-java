package com.talentotech.poo;

/**
 * Clase que extiende de Persona (Herencia)
 * Módulo 2: Programación Orientada a Objetos
 */
public class Estudiante extends Persona {
    // Atributos adicionales
    private String matricula;
    private String carrera;
    private double promedio;
    
    // Constructor
    public Estudiante(String nombre, int edad, String email, String matricula, String carrera) {
        super(nombre, edad, email);  // Llamada al constructor de la clase padre
        this.matricula = matricula;
        this.carrera = carrera;
        this.promedio = 0.0;
    }
    
    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String getCarrera() {
        return carrera;
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    public double getPromedio() {
        return promedio;
    }
    
    public void setPromedio(double promedio) {
        if (promedio >= 0.0 && promedio <= 10.0) {
            this.promedio = promedio;
        }
    }
    
    // Método específico de Estudiante
    public void estudiar() {
        System.out.println(getNombre() + " está estudiando " + carrera);
    }
    
    // Override del método saludar (Polimorfismo)
    @Override
    public void saludar() {
        System.out.println("Hola, soy " + getNombre() + ", estudiante de " + carrera);
    }
    
    // Override del método mostrarInformacion
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();  // Llama al método de la clase padre
        System.out.println("Matrícula: " + matricula);
        System.out.println("Carrera: " + carrera);
        System.out.println("Promedio: " + promedio);
    }
    
    // Override del método toString
    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", matricula='" + matricula + '\'' +
                ", carrera='" + carrera + '\'' +
                ", promedio=" + promedio +
                '}';
    }
}
