# Talento Tech - Curso de Java

Bienvenido al repositorio del curso de Java de Talento Tech. Este repositorio contiene ejemplos, ejercicios y proyectos para aprender programación en Java.

## 📋 Contenido del Curso

### Módulo 1: Fundamentos de Java
- Variables y tipos de datos
- Operadores
- Estructuras de control (if, switch)
- Bucles (for, while, do-while)

### Módulo 2: Programación Orientada a Objetos
- Clases y Objetos
- Encapsulamiento
- Herencia
- Polimorfismo
- Abstracción
- Interfaces

### Módulo 3: Estructuras de Datos
- Arrays
- Listas
- Sets
- Maps
- Pilas y Colas

### Módulo 4: Manejo de Excepciones
- Try-Catch
- Finally
- Throw y Throws
- Excepciones personalizadas

### Módulo 5: Entrada/Salida
- Lectura y escritura de archivos
- Streams
- Serialización

## 🚀 Requisitos Previos

Para seguir este curso necesitas:
- Java JDK 17 o superior instalado
- Un IDE (IntelliJ IDEA, Eclipse, o VS Code)
- Maven 3.6 o superior (incluido en el proyecto)

## ⚙️ Instalación

### Clonar el Repositorio
```bash
git clone https://github.com/AdrianLeonhardt/talentotech-java.git
cd talentotech-java
```

### Compilar el Proyecto
```bash
mvn clean compile
```

### Ejecutar los Tests
```bash
mvn test
```

### Ejecutar un Programa
```bash
mvn exec:java -Dexec.mainClass="com.talentotech.Main"
```

## 📁 Estructura del Proyecto

```
talentotech-java/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── talentotech/
│   │               ├── Main.java
│   │               ├── fundamentos/
│   │               ├── poo/
│   │               ├── estructuras/
│   │               ├── excepciones/
│   │               └── io/
│   └── test/
│       └── java/
│           └── com/
│               └── talentotech/
├── pom.xml
├── README.md
└── .gitignore
```

## 📝 Cómo Usar Este Repositorio

1. **Cada módulo tiene su propio paquete**: Navega a través de los diferentes paquetes en `src/main/java/com/talentotech/`
2. **Ejemplos prácticos**: Cada módulo contiene ejemplos comentados que puedes ejecutar
3. **Ejercicios**: Algunos archivos incluyen ejercicios marcados como TODO
4. **Tests**: Los tests unitarios te ayudarán a validar tu aprendizaje

## 🤝 Contribuir

Este es un proyecto educativo. Si encuentras errores o deseas agregar ejemplos:
1. Haz fork del repositorio
2. Crea una rama para tu característica (`git checkout -b feature/nueva-caracteristica`)
3. Commit tus cambios (`git commit -am 'Agregar nueva característica'`)
4. Push a la rama (`git push origin feature/nueva-caracteristica`)
5. Abre un Pull Request

## 📚 Recursos Adicionales

- [Documentación oficial de Java](https://docs.oracle.com/en/java/)
- [Java Tutorials de Oracle](https://docs.oracle.com/javase/tutorial/)
- [Effective Java](https://www.oracle.com/java/technologies/effective-java.html)

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo LICENSE para más detalles.

## 👥 Autor

Adrian Leonhardt - Talento Tech

## 🎓 Sobre Talento Tech

Talento Tech es una iniciativa de formación en tecnología orientada a desarrollar habilidades en programación y desarrollo de software.

---

¡Feliz aprendizaje! 💻✨