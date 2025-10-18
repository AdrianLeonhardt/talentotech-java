package com.talentotech.excepciones;

/**
 * Ejemplos de manejo de excepciones en Java
 * Módulo 4: Manejo de Excepciones
 */
public class ManejoExcepciones {
    
    public static void main(String[] args) {
        System.out.println("=== Manejo de Excepciones ===\n");
        
        // 1. Try-Catch básico
        System.out.println("1. Try-Catch básico:");
        try {
            int resultado = 10 / 0;  // Esto lanzará ArithmeticException
            System.out.println("   Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("   Error: No se puede dividir entre cero");
            System.out.println("   Mensaje de la excepción: " + e.getMessage());
        }
        
        // 2. Try-Catch con múltiples excepciones
        System.out.println("\n2. Múltiples excepciones:");
        try {
            String texto = null;
            int[] array = {1, 2, 3};
            
            // Esto podría lanzar NullPointerException
            System.out.println("   Longitud del texto: " + texto.length());
            
            // Esto podría lanzar ArrayIndexOutOfBoundsException
            System.out.println("   Elemento 10: " + array[10]);
            
        } catch (NullPointerException e) {
            System.out.println("   Error: Referencia nula detectada");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Error: Índice fuera de rango");
        } catch (Exception e) {
            System.out.println("   Error general: " + e.getMessage());
        }
        
        // 3. Try-Catch-Finally
        System.out.println("\n3. Try-Catch-Finally:");
        try {
            System.out.println("   Ejecutando código en try...");
            int[] numeros = {1, 2, 3};
            System.out.println("   Elemento: " + numeros[1]);
        } catch (Exception e) {
            System.out.println("   Excepción capturada: " + e.getMessage());
        } finally {
            System.out.println("   El bloque finally SIEMPRE se ejecuta");
        }
        
        // 4. Método con throws
        System.out.println("\n4. Método con throws:");
        try {
            int resultado = dividir(10, 2);
            System.out.println("   10 / 2 = " + resultado);
            
            resultado = dividir(10, 0);
            System.out.println("   10 / 0 = " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("   Excepción capturada: " + e.getMessage());
        }
        
        // 5. Excepción personalizada
        System.out.println("\n5. Excepción personalizada:");
        try {
            validarEdad(15);
        } catch (EdadInvalidaException e) {
            System.out.println("   Error personalizado: " + e.getMessage());
        }
        
        try {
            validarEdad(25);
            System.out.println("   Edad válida: 25 años");
        } catch (EdadInvalidaException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        // 6. Try-with-resources (Java 7+)
        System.out.println("\n6. Try-with-resources:");
        try {
            RecursoEjemplo recurso = new RecursoEjemplo();
            recurso.usar();
        } catch (Exception e) {
            System.out.println("   Error al usar el recurso: " + e.getMessage());
        }
        
        System.out.println("\n   El programa continúa ejecutándose después de las excepciones.");
    }
    
    /**
     * Método que puede lanzar una excepción
     */
    public static int dividir(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("División entre cero no permitida");
        }
        return a / b;
    }
    
    /**
     * Método que valida la edad y lanza una excepción personalizada
     */
    public static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 18) {
            throw new EdadInvalidaException("Edad insuficiente. Debe ser mayor de 18 años.");
        }
    }
}

/**
 * Excepción personalizada
 */
class EdadInvalidaException extends Exception {
    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }
}

/**
 * Clase de ejemplo para try-with-resources
 */
class RecursoEjemplo implements AutoCloseable {
    
    public RecursoEjemplo() {
        System.out.println("   Recurso abierto");
    }
    
    public void usar() {
        System.out.println("   Usando el recurso...");
    }
    
    @Override
    public void close() {
        System.out.println("   Recurso cerrado automáticamente");
    }
}
