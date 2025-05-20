
# 🧪 Ejercicio 1: Lista Simple - Insertar al Final

## 🎯 Objetivo

Implementar una estructura de datos de lista simplemente ligada en Java que permita almacenar valores de tipo entero (`int`) y realizar inserciones al final de la lista. El usuario podrá interactuar mediante un menú en consola.

## 📚 Clases involucradas

* **Nodo.java**
  Representa un nodo con un dato entero y una referencia al siguiente nodo.

* **ListaSimple.java**
  Contiene la lógica de inserción al final, verificación de si la lista está vacía e impresión de la lista.

* **MenuListaSimple.java**
  Muestra el menú interactivo en consola y permite al usuario realizar operaciones.

* **Principal.java**
  Punto de entrada del programa. Ejecuta el menú.

## 🛠 Funcionalidades implementadas

* Insertar un número al final de la lista.
* Mostrar los elementos de la lista.
* Verificar si la lista está vacía.
* Menú interactivo persistente hasta que el usuario elija salir.

## 🖥️ Ejemplo de ejecución

\--- MENÚ: LISTA SIMPLE (Insertar al final) ---

1. Insertar un número al final
2. Mostrar la lista
3. Verificar si la lista está vacía
4. Salir
  
Selecciona una opción: 1
Introduce un número: 10
Número insertado.

Selecciona una opción: 1
Introduce un número: 20
Número insertado.

Selecciona una opción: 2
Contenido de la lista:
10 -> 20 -> null

Selecciona una opción: 3
La lista NO está vacía.

Selecciona una opción: 0
Saliendo del programa...

## 📝 Instrucciones

1. Compila todos los archivos `.java` en la carpeta del ejercicio.
2. Ejecuta la clase `Principal` desde la terminal o desde tu IDE.
3. Realiza varias inserciones y verifica que los datos se impriman correctamente.

## 📗 Ejercicios practicos (Agregar a cuaderno de ejercicios)

* Modifica el tipo de dato a `double` o `char` para practicar con otros tipos primitivos.
* Agrega una opción en el menú para limpiar la lista.
* Implementa un método que retorne el valor máximo de la lista.

