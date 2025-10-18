package com.talentotech.poo;

/**
 * Programa principal para demostrar conceptos de POO
 * Módulo 2: Programación Orientada a Objetos
 */
public class EjemploPOO {
    
    public static void main(String[] args) {
        System.out.println("=== Programación Orientada a Objetos ===\n");
        
        // Crear objetos usando diferentes constructores
        System.out.println("1. Creación de Objetos:");
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Carlos", 30);
        Persona persona3 = new Persona("María", 25, "maria@email.com");
        
        System.out.println("   " + persona1);
        System.out.println("   " + persona2);
        System.out.println("   " + persona3);
        
        // Encapsulamiento - Uso de getters y setters
        System.out.println("\n2. Encapsulamiento:");
        persona1.setNombre("Ana");
        persona1.setEdad(28);
        persona1.setEmail("ana@email.com");
        System.out.println("   Persona actualizada: " + persona1);
        
        // Métodos
        System.out.println("\n3. Métodos:");
        persona3.saludar();
        System.out.println("   ¿Es mayor de edad? " + persona3.esMayorDeEdad());
        
        // Herencia
        System.out.println("\n4. Herencia:");
        Estudiante estudiante1 = new Estudiante(
            "Juan Pérez", 
            20, 
            "juan@email.com",
            "EST-2025-001",
            "Ingeniería en Sistemas"
        );
        estudiante1.setPromedio(8.5);
        
        System.out.println("   Información del estudiante:");
        estudiante1.mostrarInformacion();
        
        // Polimorfismo
        System.out.println("\n5. Polimorfismo:");
        Persona persona4 = new Estudiante(
            "Laura González",
            22,
            "laura@email.com",
            "EST-2025-002",
            "Ciencias de la Computación"
        );
        
        // Mismo método, diferente comportamiento
        System.out.println("   Persona regular:");
        persona3.saludar();
        System.out.println("   Estudiante:");
        persona4.saludar();
        
        // Métodos específicos
        System.out.println("\n6. Métodos Específicos:");
        estudiante1.estudiar();
        
        // Array de Personas (Polimorfismo)
        System.out.println("\n7. Array Polimórfico:");
        Persona[] personas = {persona2, persona3, estudiante1, persona4};
        for (Persona p : personas) {
            p.saludar();
        }
    }
}
