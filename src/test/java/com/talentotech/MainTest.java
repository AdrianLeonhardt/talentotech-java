package com.talentotech;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests básicos para el proyecto Talento Tech
 */
public class MainTest {
    
    @Test
    public void testMainExists() {
        // Verificar que la clase Main existe y tiene un método main
        assertDoesNotThrow(() -> {
            Main.main(new String[]{});
        });
    }
}
