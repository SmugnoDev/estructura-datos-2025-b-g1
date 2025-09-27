# GeometricCalc
Proyecto en Java para gestionar diferentes figuras geométricas utilizando polimorfismo y ArrayList.

## Descripción
El programa permite:
- Crear figuras geométricas (círculos, rectángulos y triángulos).
- Almacenar las figuras en un `ArrayList`.
- Mostar la figuras almacenadas en un `ArrayList`.
- Eliminar figuras en un `ArrayList`.

Las capturas de pantalla evidenciando lo solicitado: [Documento Evidencias](/Capturas.docx)

## Ejecución
Compilar y ejecutar:

```bash
javac Main.java
java Main
```

## ¿Por qué utilizar una clase abstracta?

Se utiliza una clase abstracta (`Shape`) para definir una interfaz común para todas las figuras geométricas. Esto permite que las clases concretas (Círculo, Rectángulo y Triángulo) implementen sus propios métodos de cálculo de área y perímetro, asegurando polimorfismo y reutilización de código. Así, el programa puede manejar diferentes tipos de figuras de manera uniforme y extensible.

## Estructura del proyecto

```
GeometricCalc/
├── src/
│   ├── Main.java
│   └── shapes/
│       ├── Shape.java
│       ├── Circle.java
│       ├── Rectangle.java
│       └── Triangle.java
├── README.md
```

- `Main.java`: Clase principal con la lógica de interacción y gestión de figuras.
- `shapes/`: Paquete que contiene las clases de las figuras geométricas.

## Autores

- Sergio Losada

