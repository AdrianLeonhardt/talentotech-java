package com.talentotech.fundamentos;

/**
 * Ejemplos de estructuras de control en Java
 * Módulo 1: Fundamentos de Java
 */
public class EstructurasControl {
    
    public static void main(String[] args) {
        System.out.println("=== Estructuras de Control ===\n");
        
        // IF - ELSE IF - ELSE
        System.out.println("1. Estructura IF-ELSE:");
        int nota = 85;
        
        if (nota >= 90) {
            System.out.println("   Calificación: A - Excelente");
        } else if (nota >= 80) {
            System.out.println("   Calificación: B - Muy Bueno");
        } else if (nota >= 70) {
            System.out.println("   Calificación: C - Bueno");
        } else if (nota >= 60) {
            System.out.println("   Calificación: D - Suficiente");
        } else {
            System.out.println("   Calificación: F - Insuficiente");
        }
        
        // SWITCH
        System.out.println("\n2. Estructura SWITCH:");
        int diaSemana = 3;
        String nombreDia;
        
        switch (diaSemana) {
            case 1:
                nombreDia = "Lunes";
                break;
            case 2:
                nombreDia = "Martes";
                break;
            case 3:
                nombreDia = "Miércoles";
                break;
            case 4:
                nombreDia = "Jueves";
                break;
            case 5:
                nombreDia = "Viernes";
                break;
            case 6:
                nombreDia = "Sábado";
                break;
            case 7:
                nombreDia = "Domingo";
                break;
            default:
                nombreDia = "Día inválido";
        }
        System.out.println("   Día " + diaSemana + " es: " + nombreDia);
        
        // OPERADOR TERNARIO
        System.out.println("\n3. Operador Ternario:");
        int edad = 20;
        String mensaje = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
        System.out.println("   Edad: " + edad + " - " + mensaje);
        
        // BUCLES
        System.out.println("\n4. Bucle FOR:");
        System.out.print("   Números del 1 al 5: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        System.out.println("\n5. Bucle WHILE:");
        System.out.print("   Números pares del 2 al 10: ");
        int contador = 2;
        while (contador <= 10) {
            System.out.print(contador + " ");
            contador += 2;
        }
        System.out.println();
        
        System.out.println("\n6. Bucle DO-WHILE:");
        System.out.print("   Cuenta regresiva: ");
        int numero = 5;
        do {
            System.out.print(numero + " ");
            numero--;
        } while (numero > 0);
        System.out.println("¡Despegue! 🚀");
        
        // BREAK y CONTINUE
        System.out.println("\n7. BREAK y CONTINUE:");
        System.out.print("   Números del 1 al 10 (saltando el 5): ");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue; // Salta a la siguiente iteración
            }
            if (i == 9) {
                break; // Sale del bucle
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
