package com.talentotech.poo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para la clase Persona
 */
public class PersonaTest {
    
    @Test
    public void testConstructorVacio() {
        Persona persona = new Persona();
        assertNotNull(persona);
        assertEquals("Sin nombre", persona.getNombre());
        assertEquals(0, persona.getEdad());
    }
    
    @Test
    public void testConstructorConParametros() {
        Persona persona = new Persona("Juan", 25, "juan@email.com");
        assertEquals("Juan", persona.getNombre());
        assertEquals(25, persona.getEdad());
        assertEquals("juan@email.com", persona.getEmail());
    }
    
    @Test
    public void testSetters() {
        Persona persona = new Persona();
        persona.setNombre("María");
        persona.setEdad(30);
        persona.setEmail("maria@email.com");
        
        assertEquals("María", persona.getNombre());
        assertEquals(30, persona.getEdad());
        assertEquals("maria@email.com", persona.getEmail());
    }
    
    @Test
    public void testEsMayorDeEdad() {
        Persona menor = new Persona("Ana", 15, "ana@email.com");
        Persona mayor = new Persona("Carlos", 20, "carlos@email.com");
        
        assertFalse(menor.esMayorDeEdad());
        assertTrue(mayor.esMayorDeEdad());
    }
    
    @Test
    public void testEdadInvalida() {
        Persona persona = new Persona();
        persona.setEdad(-5);  // Edad inválida
        assertEquals(0, persona.getEdad());  // No debería cambiar
        
        persona.setEdad(20);  // Edad válida
        assertEquals(20, persona.getEdad());
        
        persona.setEdad(200);  // Edad inválida
        assertEquals(20, persona.getEdad());  // No debería cambiar
    }
}
