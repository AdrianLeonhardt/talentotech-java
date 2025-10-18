# Guía de Contribución

¡Gracias por tu interés en contribuir al repositorio del curso Talento Tech - Java!

## 📝 Cómo Contribuir

### Reportar Errores

Si encuentras un error en el código o la documentación:

1. Verifica que el error no haya sido reportado previamente en los [Issues](https://github.com/AdrianLeonhardt/talentotech-java/issues)
2. Abre un nuevo issue describiendo:
   - El problema encontrado
   - Pasos para reproducir el error
   - Comportamiento esperado vs. comportamiento actual
   - Capturas de pantalla si aplica

### Sugerir Mejoras

Para proponer nuevos ejemplos o mejoras:

1. Abre un issue con la etiqueta "enhancement"
2. Describe claramente la mejora propuesta
3. Explica cómo beneficiaría al curso

### Enviar Pull Requests

Para contribuir con código:

1. **Fork** el repositorio
2. **Clona** tu fork localmente:
   ```bash
   git clone https://github.com/tu-usuario/talentotech-java.git
   cd talentotech-java
   ```

3. **Crea una rama** para tu contribución:
   ```bash
   git checkout -b feature/descripcion-de-tu-contribucion
   ```

4. **Realiza tus cambios** siguiendo las convenciones del proyecto:
   - Código bien comentado
   - Ejemplos claros y didácticos
   - Tests para nuevas funcionalidades
   - Documentación actualizada

5. **Compila y prueba** tus cambios:
   ```bash
   mvn clean compile
   mvn test
   ```

6. **Commit** tus cambios con mensajes descriptivos:
   ```bash
   git commit -m "Agregar ejemplo de [tema]"
   ```

7. **Push** a tu fork:
   ```bash
   git push origin feature/descripcion-de-tu-contribucion
   ```

8. Abre un **Pull Request** desde tu fork hacia el repositorio principal

## 📐 Convenciones de Código

### Java

- Usa nombres descriptivos para variables, métodos y clases
- Sigue las convenciones de nomenclatura de Java:
  - CamelCase para clases: `MiClase`
  - camelCase para métodos y variables: `miVariable`
  - MAYUSCULAS para constantes: `MI_CONSTANTE`
- Agrega comentarios explicativos para conceptos complejos
- Cada clase debe tener un comentario JavaDoc
- Máximo 100 caracteres por línea

### Estructura de Archivos

- Un archivo por clase
- Organiza las clases en paquetes apropiados:
  - `fundamentos` - Conceptos básicos de Java
  - `poo` - Programación Orientada a Objetos
  - `estructuras` - Estructuras de datos
  - `excepciones` - Manejo de excepciones
  - `io` - Entrada/Salida

### Documentación

- README en español
- Comentarios en español para facilitar el aprendizaje
- Ejemplos prácticos y funcionales
- Incluye salida esperada del programa en los comentarios si es relevante

## 🧪 Testing

Todos los ejemplos nuevos deben:
- Compilar sin errores
- Ejecutar correctamente
- Incluir tests unitarios cuando sea apropiado

Ejecuta los tests antes de hacer commit:
```bash
mvn test
```

## 💡 Ejemplos de Buenas Contribuciones

- Ejemplos adicionales para módulos existentes
- Ejercicios prácticos con soluciones
- Mejoras en la documentación
- Corrección de errores tipográficos
- Tests adicionales
- Optimizaciones de código existente

## ❓ ¿Necesitas Ayuda?

Si tienes dudas sobre cómo contribuir:
- Abre un issue con la etiqueta "question"
- Consulta la documentación existente
- Revisa otros Pull Requests para ejemplos

## 🎯 Código de Conducta

- Sé respetuoso con otros colaboradores
- Proporciona retroalimentación constructiva
- Enfócate en hacer el aprendizaje accesible y claro
- Mantén un ambiente positivo y educativo

## 📄 Licencia

Al contribuir, aceptas que tus contribuciones se licenciarán bajo la [Licencia MIT](LICENSE).

---

¡Gracias por ayudar a mejorar el curso Talento Tech - Java! 🚀
