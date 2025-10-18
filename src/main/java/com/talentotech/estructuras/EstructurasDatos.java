package com.talentotech.estructuras;

import java.util.*;

/**
 * Ejemplos de estructuras de datos en Java
 * Módulo 3: Estructuras de Datos
 */
public class EstructurasDatos {
    
    public static void main(String[] args) {
        System.out.println("=== Estructuras de Datos ===\n");
        
        // 1. Arrays
        System.out.println("1. Arrays:");
        int[] numeros = {10, 20, 30, 40, 50};
        String[] frutas = new String[3];
        frutas[0] = "Manzana";
        frutas[1] = "Banana";
        frutas[2] = "Naranja";
        
        System.out.println("   Números: " + Arrays.toString(numeros));
        System.out.println("   Frutas: " + Arrays.toString(frutas));
        System.out.println("   Primer elemento: " + numeros[0]);
        System.out.println("   Longitud del array: " + numeros.length);
        
        // 2. ArrayList (Lista dinámica)
        System.out.println("\n2. ArrayList:");
        ArrayList<String> ciudades = new ArrayList<>();
        ciudades.add("Madrid");
        ciudades.add("Barcelona");
        ciudades.add("Valencia");
        ciudades.add("Sevilla");
        
        System.out.println("   Ciudades: " + ciudades);
        System.out.println("   Primera ciudad: " + ciudades.get(0));
        System.out.println("   Tamaño: " + ciudades.size());
        System.out.println("   ¿Contiene Madrid? " + ciudades.contains("Madrid"));
        
        // Agregar en posición específica
        ciudades.add(1, "Bilbao");
        System.out.println("   Después de agregar Bilbao: " + ciudades);
        
        // Eliminar elemento
        ciudades.remove("Valencia");
        System.out.println("   Después de eliminar Valencia: " + ciudades);
        
        // 3. LinkedList
        System.out.println("\n3. LinkedList:");
        LinkedList<Integer> listaEnlazada = new LinkedList<>();
        listaEnlazada.add(1);
        listaEnlazada.add(2);
        listaEnlazada.add(3);
        listaEnlazada.addFirst(0);  // Agregar al inicio
        listaEnlazada.addLast(4);   // Agregar al final
        
        System.out.println("   Lista enlazada: " + listaEnlazada);
        System.out.println("   Primer elemento: " + listaEnlazada.getFirst());
        System.out.println("   Último elemento: " + listaEnlazada.getLast());
        
        // 4. HashSet (Conjunto sin duplicados)
        System.out.println("\n4. HashSet:");
        HashSet<String> colores = new HashSet<>();
        colores.add("Rojo");
        colores.add("Verde");
        colores.add("Azul");
        colores.add("Rojo");  // Duplicado, no se agregará
        
        System.out.println("   Colores (sin duplicados): " + colores);
        System.out.println("   Tamaño: " + colores.size());
        
        // 5. HashMap (Mapa clave-valor)
        System.out.println("\n5. HashMap:");
        HashMap<String, Integer> edades = new HashMap<>();
        edades.put("Ana", 25);
        edades.put("Carlos", 30);
        edades.put("María", 28);
        edades.put("Juan", 22);
        
        System.out.println("   Edades: " + edades);
        System.out.println("   Edad de Carlos: " + edades.get("Carlos"));
        System.out.println("   ¿Contiene la clave 'Ana'? " + edades.containsKey("Ana"));
        System.out.println("   ¿Contiene el valor 30? " + edades.containsValue(30));
        
        // Iterar sobre el HashMap
        System.out.println("   Iterando sobre el mapa:");
        for (Map.Entry<String, Integer> entry : edades.entrySet()) {
            System.out.println("      " + entry.getKey() + " tiene " + entry.getValue() + " años");
        }
        
        // 6. Stack (Pila - LIFO)
        System.out.println("\n6. Stack (Pila LIFO):");
        Stack<String> pila = new Stack<>();
        pila.push("Primero");
        pila.push("Segundo");
        pila.push("Tercero");
        
        System.out.println("   Pila: " + pila);
        System.out.println("   Elemento superior (peek): " + pila.peek());
        System.out.println("   Desapilar (pop): " + pila.pop());
        System.out.println("   Pila después de pop: " + pila);
        
        // 7. Queue (Cola - FIFO)
        System.out.println("\n7. Queue (Cola FIFO):");
        Queue<String> cola = new LinkedList<>();
        cola.offer("Primero en la fila");
        cola.offer("Segundo en la fila");
        cola.offer("Tercero en la fila");
        
        System.out.println("   Cola: " + cola);
        System.out.println("   Primer elemento (peek): " + cola.peek());
        System.out.println("   Atender (poll): " + cola.poll());
        System.out.println("   Cola después de poll: " + cola);
        
        // 8. Iteración con for-each
        System.out.println("\n8. Iteración con for-each:");
        System.out.print("   Ciudades: ");
        for (String ciudad : ciudades) {
            System.out.print(ciudad + " ");
        }
        System.out.println();
    }
}
