
## **Ejercicio 1: Implementación, inserción al inicio y al final en listas doblemente ligadas**.

### ✅ Objetivo:

Implementar una lista doblemente ligada que permita insertar elementos al inicio y al final, y recorrerla en ambas direcciones.


---

## 1. Introducción

Las listas doblemente ligadas constituyen una estructura de datos lineal que, a diferencia de las listas simplemente ligadas, mantienen un doble enlace entre sus nodos: uno hacia el nodo siguiente y otro hacia el nodo anterior. Esta característica permite un recorrido bidireccional de la lista, lo que incrementa su flexibilidad en operaciones de inserción y eliminación.

En contextos donde se requiere desplazamiento eficiente hacia adelante y hacia atrás, o eliminar nodos intermedios con rapidez, las listas doblemente ligadas representan una alternativa más versátil que las listas simples o los arreglos dinámicos.

---

## 2. Estructura de un nodo doblemente ligado

Cada nodo de una lista doblemente ligada está compuesto por tres campos:

* Un **campo de datos** que almacena el valor del nodo.
* Una **referencia al siguiente nodo** de la lista.
* Una **referencia al nodo anterior**.

Formalmente, puede representarse de la siguiente manera:

```
[nodo_anterior] ← [ DATO ] → [nodo_siguiente]
```

Cuando se trata del primer nodo, su campo `anterior` es `null`; de forma análoga, el último nodo tendrá `null` en el campo `siguiente`.

---

## 3. Propiedades de la lista doblemente ligada

Una lista doblemente ligada puede caracterizarse por las siguientes propiedades:

* Posee una referencia al primer nodo (`cabeza`) y comúnmente también al último (`cola`), lo cual permite accesos eficientes desde ambos extremos.
* Cada nodo conoce tanto a su predecesor como a su sucesor inmediato.
* Permite recorrer la lista en **dos direcciones** sin necesidad de recorrerla completa desde el inicio.
* Facilita operaciones de eliminación e inserción de nodos en tiempo constante si se tiene una referencia directa al nodo en cuestión.

---

## 4. Operaciones básicas

Las principales operaciones que se pueden realizar sobre una lista doblemente ligada incluyen:

### 4.1. Inserción al inicio

Se crea un nuevo nodo y se ajustan las referencias para que este nuevo nodo apunte al anterior primer nodo, y la cabeza de la lista se actualice al nuevo nodo.

### 4.2. Inserción al final

El nuevo nodo se conecta después del último nodo existente y se actualiza la referencia de la cola.

### 4.3. Inserción en una posición específica

Implica recorrer la lista hasta la posición deseada, y luego modificar las referencias de los nodos anterior y siguiente para insertar el nuevo nodo entre ellos.

### 4.4. Eliminación de un nodo

Dado un nodo a eliminar, se ajustan las referencias del nodo anterior y siguiente de forma que excluyan al nodo actual de la cadena. Si el nodo está al inicio o al final, también se actualiza la cabeza o la cola, respectivamente.

### 4.5. Búsqueda

Consiste en recorrer secuencialmente la lista en una de las dos direcciones para localizar un nodo que contenga un valor específico.

### 4.6. Recorrido desde la cabeza o la cola

Gracias a los punteros dobles, la lista puede recorrerse en orden directo o inverso, según se requiera.

---

## 5. Comparación con otras estructuras

| Característica                           | Lista simplemente ligada         | Lista doblemente ligada |
| ---------------------------------------- | -------------------------------- | ----------------------- |
| Enlace hacia el anterior                 | No                               | Sí                      |
| Recorrido inverso                        | No                               | Sí                      |
| Inserción/eliminación rápida en extremos | Sí (inicio), no (final sin cola) | Sí en ambos extremos    |
| Uso de memoria                           | Menor (una referencia)           | Mayor (dos referencias) |

---

## 6. Consideraciones de implementación

Aunque las listas doblemente ligadas ofrecen mayor flexibilidad que las listas simples, también implican un mayor uso de memoria debido a los dos punteros por nodo. Asimismo, la implementación requiere atención especial para mantener la integridad de las referencias al insertar o eliminar nodos, particularmente en los casos de extremos o listas con un solo elemento.

Es buena práctica mantener referencias explícitas tanto al inicio (`cabeza`) como al final (`cola`) para optimizar las operaciones en ambos sentidos.

---

¿Deseas que ahora integremos esta sección como parte del `README.md` del módulo `listas/doble`, o prefieres que también lo convierta en una versión `.md` o `.pdf` para integrarlo directamente en el repositorio?

> A contiunación vamos a desarrollar el codigo para hacer la implementacion de las primeras operacion de una lista doble, copia y pega el codigo y posteriormente realiza los ejercicios propuestos

## 📁 Archivos a utilizar

* `NodoDoble.java`: representa cada nodo con referencias a anterior y siguiente.
* `ListaDoble.java`: contiene la lógica de inserción y recorrido.
* `MenuListaDoble.java`: interfaz de menú para interactuar con la lista.
* `Principal.java`: clase de arranque del programa.

---

## 🔧 Funcionalidades implementadas

* Insertar elementos al inicio.
* Insertar elementos al final.
* Recorrer la lista desde el inicio hacia el final.
* Recorrer la lista desde el final hacia el inicio.

---

## 1. `NodoDoble.java`

```java
public class NodoDoble {
    int dato;
    NodoDoble siguiente;
    NodoDoble anterior;

    public NodoDoble(int dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
```
### 🧠 ¿Qué es `NodoDoble.java`?

Un **nodo doble** es una **unidad básica de una lista doblemente ligada**. A diferencia de los nodos en una lista simple, que solo apuntan al siguiente nodo, en una lista doble **cada nodo tiene dos enlaces**:

* Uno que apunta al siguiente nodo (`siguiente`)
* Uno que apunta al nodo anterior (`anterior`)

Esto permite **recorrer la lista en ambas direcciones**: de principio a fin y de fin a principio.

### 🔎 Desglose por partes:

* `int dato`: almacena el valor del nodo (puede ser otro tipo primitivo o un objeto en futuras versiones).
* `NodoDoble siguiente`: referencia al siguiente nodo de la lista.
* `NodoDoble anterior`: referencia al nodo anterior de la lista.
* El constructor:

    * Recibe el valor (`dato`) y deja los enlaces `null`, porque cuando se crea el nodo aún no está conectado a otros nodos.

### 📌 Ejemplo visual:

```text
null ← [10] → null
```

Luego de insertar otro nodo al final:

```text
null ← [10] ⇄ [20] → null
```

---

## 2. `ListaDoble.java`

```java
public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;

    public ListaDoble() {
        cabeza = null;
        cola = null;
    }

    public void insertarAlInicio(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
    }

    public void insertarAlFinal(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cola == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    public void imprimirDesdeInicio() {
        NodoDoble actual = cabeza;
        System.out.print("Inicio → ");
        while (actual != null) {
            System.out.print(actual.dato + " ⇄ ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public void imprimirDesdeFinal() {
        NodoDoble actual = cola;
        System.out.print("Fin → ");
        while (actual != null) {
            System.out.print(actual.dato + " ⇄ ");
            actual = actual.anterior;
        }
        System.out.println("null");
    }
}
```

## 🧠 ¿Qué es `ListaDoble`?

Es una clase que **administra y controla el funcionamiento** de una lista doblemente ligada. Guarda la referencia al **primer nodo** (`cabeza`) y al **último nodo** (`cola`). Esto permite operaciones eficientes desde ambos extremos.

---

### 🔍 Atributos:

* `cabeza`: es el primer nodo de la lista.
* `cola`: es el último nodo de la lista.

---

### 📌 Método `insertarAlInicio(int dato)`

```java
public void insertarAlInicio(int dato) {
    NodoDoble nuevo = new NodoDoble(dato);
    if (cabeza == null) {
        cabeza = cola = nuevo;
    } else {
        nuevo.siguiente = cabeza;
        cabeza.anterior = nuevo;
        cabeza = nuevo;
    }
}
```

#### 🔍 Lógica:

1. Se crea un nuevo nodo.
2. Si la lista está vacía:

    * Ese nodo será **el primero y el último** al mismo tiempo.
3. Si ya hay elementos:

    * El nuevo nodo se conecta **antes de la cabeza actual**.
    * Se actualiza `cabeza` para que apunte al nuevo nodo.

---

### 📌 Método `insertarAlFinal(int dato)`

```java
public void insertarAlFinal(int dato) {
    NodoDoble nuevo = new NodoDoble(dato);
    if (cola == null) {
        cabeza = cola = nuevo;
    } else {
        cola.siguiente = nuevo;
        nuevo.anterior = cola;
        cola = nuevo;
    }
}
```

#### 🔍 Lógica:

1. Se crea un nodo nuevo.
2. Si la lista está vacía:

    * El nodo es tanto cabeza como cola.
3. Si no:

    * Se conecta después de la cola actual.
    * La cola se actualiza al nuevo nodo.

---

### 📌 Método `imprimirDesdeInicio()`

```java
public void imprimirDesdeInicio() {
    NodoDoble actual = cabeza;
    System.out.print("Inicio → ");
    while (actual != null) {
        System.out.print(actual.dato + " ⇄ ");
        actual = actual.siguiente;
    }
    System.out.println("null");
}
```

#### 🔍 Lógica:

* Se empieza desde la `cabeza` y se avanza nodo por nodo usando `siguiente`.
* Se imprime cada valor hasta llegar al final (`null`).

---

### 📌 Método `imprimirDesdeFinal()`

```java
public void imprimirDesdeFinal() {
    NodoDoble actual = cola;
    System.out.print("Fin → ");
    while (actual != null) {
        System.out.print(actual.dato + " ⇄ ");
        actual = actual.anterior;
    }
    System.out.println("null");
}
```

#### 🔍 Lógica:

* Comienza desde la `cola` y recorre la lista hacia atrás usando `anterior`.
* Permite comprobar que los enlaces `anterior` están bien definidos.

---

## 🧠 Resumen

Estas dos clases (`NodoDoble` y `ListaDoble`) permiten implementar una estructura eficiente para gestionar datos **desde ambos extremos**. Entender cómo conectar y actualizar correctamente los nodos es esencial para evitar errores de referencia y garantizar que la lista esté bien formada.


---

## 3. `MenuListaDoble.java`

```java
import java.util.Scanner;

public class MenuListaDoble {
    private final ListaDoble lista;
    private final Scanner scanner;

    public MenuListaDoble() {
        this.lista = new ListaDoble();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n--- MENÚ: Lista Doble (Inicio y Final) ---");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Imprimir desde el inicio");
            System.out.println("4. Imprimir desde el final");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Introduce un número: ");
                    int numero = scanner.nextInt();
                    lista.insertarAlInicio(numero);
                    System.out.println("Número insertado al inicio.");
                }
                case 2 -> {
                    System.out.print("Introduce un número: ");
                    int numero = scanner.nextInt();
                    lista.insertarAlFinal(numero);
                    System.out.println("Número insertado al final.");
                }
                case 3 -> lista.imprimirDesdeInicio();
                case 4 -> lista.imprimirDesdeFinal();
                case 0 -> System.out.println("Fin del programa.");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
}
```

---

## 4. `Principal.java`

```java
public class Principal {
    public static void main(String[] args) {
        MenuListaDoble menu = new MenuListaDoble();
        menu.mostrarMenu();
    }
}
```

---


## 🧪 Escenario de prueba recomendado

1. Insertar 10 al **inicio**
2. Insertar 20 al **final**
3. Insertar 30 al **inicio**
4. Mostrar la lista desde el inicio → `30 ⇄ 10 ⇄ 20`
5. Mostrar la lista desde el final → `20 ⇄ 10 ⇄ 30`

---

## 🧠 Preguntas de reflexión (agregar al cuaderno de ejercicios) 

* ¿Qué ventaja tiene una lista doble respecto a una simple?
* ¿Cómo afecta al rendimiento recorrer la lista desde el final?
* ¿Es necesario usar dos punteros (`cabeza` y `cola`)? ¿Por qué?

---

## 📎 Ejercicios complementarios

Los siguientes ejercicios están diseñados para extender el uso del código actual de inserción y recorrido de listas doblemente ligadas. Estos retos permiten reforzar el uso de punteros y el análisis de la estructura de la lista.

---

### 🔹 Ejercicio C1: Contar elementos de la lista

**Objetivo**: Implementar un método que recorra la lista desde la cabeza y retorne la cantidad de nodos.

**Resultado esperado**:
Si la lista contiene `10 ⇄ 20 ⇄ 30`, el método debe retornar `3`.

---

### 🔹 Ejercicio C2: Mostrar el primer y último elemento

**Objetivo**: Permitir al usuario consultar el primer y el último elemento sin recorrer la lista.

**Complemento en el menú**:
Agregar opciones como:

* `5. Mostrar primer elemento`
* `6. Mostrar último elemento`

---

### 🔹 Ejercicio C3: Mostrar la lista en formato índice-valor

**Objetivo**: Imprimir los elementos de la lista junto con su posición (empezando desde 0).

**Ejemplo de salida:**

```
[0] 10
[1] 20
[2] 30
```

---

### 🔹 Ejercicio C4: Verificar si la lista está vacía

**Objetivo**: Implementar una validación rápida para saber si la lista contiene elementos.

**Complemento en el menú:**
Agregar opción `7. Verificar si la lista está vacía`, que imprima:

* `"La lista está vacía"`
* o `"La lista contiene elementos"`

---

### 🔹 Ejercicio C5: Vaciar la lista

**Objetivo**: Permitir que el usuario borre todos los elementos de la lista.


> Esto elimina la referencia a los nodos; el recolector de basura se encarga del resto.


