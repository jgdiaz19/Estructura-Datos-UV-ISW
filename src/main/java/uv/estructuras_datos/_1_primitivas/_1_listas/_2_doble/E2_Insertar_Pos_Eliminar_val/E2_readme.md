
## 🧪 Ejercicio 2: Inserción en posición específica y eliminación por valor (Lista Doble)

### 🎯 Objetivo del ejercicio

Permitir que el usuario:

1. Inserte un nodo en una posición específica de la lista (por índice, empezando desde 0).
2. Elimine un nodo cuyo valor coincida con un entero dado.

Este ejercicio refuerza el manejo de punteros dobles y el control de casos especiales como inserciones al inicio, medio o final; así como eliminación de nodos en cualquiera de esas posiciones.


## 📁 Archivos involucrados

* `NodoDoble.java` ✅ (sin cambios)
* `ListaDoble.java` ✅ (modificado: nuevos métodos)
* `MenuListaDoble.java` ✅ (modificado: nuevas opciones)
* `Principal.java` ✅ (sin cambios)

> Deberas copiar los archivos desarrollados en el ejercicio anterior y realizar los cambios indicados a continuacion

## 🔧 Cambios en `ListaDoble.java`

### ➕ Método: `insertarEnPosicion(int posicion, int dato)`

```java
public void insertarEnPosicion(int posicion, int dato) {
    if (posicion <= 0 || cabeza == null) {
        insertarAlInicio(dato);
        return;
    }

    NodoDoble actual = cabeza;
    int indice = 0;

    while (actual != null && indice < posicion - 1) {
        actual = actual.siguiente;
        indice++;
    }

    if (actual == null || actual.siguiente == null) {
        insertarAlFinal(dato);
    } else {
        NodoDoble nuevo = new NodoDoble(dato);
        NodoDoble siguiente = actual.siguiente;

        actual.siguiente = nuevo;
        nuevo.anterior = actual;

        nuevo.siguiente = siguiente;
        siguiente.anterior = nuevo;
    }
}
```

### 🧠 Lógica:

* Si la posición es 0 o menor, se inserta al inicio.
* Si la posición es mayor que el número de elementos, se inserta al final.
* En cualquier otro caso, se inserta entre dos nodos, ajustando correctamente ambos punteros `anterior` y `siguiente`.


### ➕ Método: `eliminar(int valor)`

```java
public void eliminar(int valor) {
    if (cabeza == null) {
        System.out.println("La lista está vacía.");
        return;
    }

    // Caso: el nodo a eliminar es la cabeza
    if (cabeza.dato == valor) {
        cabeza = cabeza.siguiente;
        if (cabeza != null) cabeza.anterior = null;
        else cola = null; // la lista quedó vacía
        System.out.println("Elemento eliminado desde el inicio.");
        return;
    }

    NodoDoble actual = cabeza;

    while (actual != null && actual.dato != valor) {
        actual = actual.siguiente;
    }

    if (actual == null) {
        System.out.println("El valor no se encontró en la lista.");
        return;
    }

    if (actual == cola) {
        cola = cola.anterior;
        cola.siguiente = null;
        System.out.println("Elemento eliminado desde el final.");
    } else {
        actual.anterior.siguiente = actual.siguiente;
        actual.siguiente.anterior = actual.anterior;
        System.out.println("Elemento eliminado desde el medio.");
    }
}
```


## 🧭 Cambios en `MenuListaDoble.java`

### 🔢 Actualiza el menú:

Agrega:

```java
System.out.println("5. Insertar en una posición específica");
System.out.println("6. Eliminar un nodo por valor");
```

### ➕ Agrega casos al `switch(opcion)`:

```java
case 5 -> {
    System.out.print("Valor a insertar: ");
    int valor = scanner.nextInt();
    System.out.print("Posición (comenzando desde 0): ");
    int posicion = scanner.nextInt();
    lista.insertarEnPosicion(posicion, valor);
    System.out.println("Elemento insertado en la posición " + posicion + ".");
}

case 6 -> {
    System.out.print("Valor a eliminar: ");
    int valor = scanner.nextInt();
    lista.eliminar(valor);
}
```


## ✅ Ejemplo de prueba sugerido

### Inserción por posición:

1. Lista inicial vacía
2. Insertar `10` al final
3. Insertar `30` al final
4. Insertar `20` en posición `1`
   Resultado esperado: `10 ⇄ 20 ⇄ 30`

### Eliminación:

* Eliminar `10`: `"Elemento eliminado desde el inicio."`
* Eliminar `30`: `"Elemento eliminado desde el final."`
* Eliminar `20`: `"Elemento eliminado desde el medio."`


## 📘 Preguntas de reflexión (Incluir en el cuaderno de ejercicios)

* ¿Qué ocurre si se intenta insertar en una posición mayor que el tamaño de la lista?
* ¿Qué pasaría si no se actualiza correctamente el puntero `anterior` al eliminar?
* ¿Qué ventajas ofrece una lista doble frente a una simple para este tipo de operaciones?


## 📎 Ejercicios complementarios

Estos ejercicios adicionales te permitiran profundizar en el manejo de inserciones y eliminaciones dentro de listas doblemente ligadas. Están diseñados para trabajarse **con el código ya implementado hasta el Ejercicio 2**


### 🔹 Ejercicio C1: Insertar después de un nodo con valor específico

**Objetivo**: Implementar un método que permita insertar un nuevo valor inmediatamente después de un nodo que contenga un valor dado.

**Firma sugerida**:

```java
public void insertarDespuesDe(int valorExistente, int nuevoValor)
```

**Lógica**:

* Recorrer la lista hasta encontrar el nodo cuyo `dato` sea igual a `valorExistente`.
* Crear un nuevo nodo con `nuevoValor`.
* Insertarlo justo después del nodo encontrado, actualizando `siguiente` y `anterior`.

**Consideraciones**:

* Si el valor no se encuentra, notificar al usuario.
* Si el nodo encontrado es la cola, el nuevo nodo se convierte en el nuevo final.


### 🔹 Ejercicio C2: Eliminar todos los nodos con un valor específico

**Objetivo**: Adaptar el método de eliminación para que remueva **todas las ocurrencias** de un valor, no solo la primera.

**Firma sugerida**:

```java
public void eliminarTodas(int valor)
```

**Lógica**:

* Recorrer la lista desde la cabeza.
* Cada vez que se encuentre un nodo con el valor objetivo, ajustar los punteros del nodo anterior y siguiente para "saltar" ese nodo.
* Continuar hasta el final de la lista.

**Consideraciones**:

* Si la lista queda vacía, actualizar `cabeza` y `cola` a `null`.
* Mostrar cuántos elementos fueron eliminados.


### 🔹 Ejercicio C3: Insertar antes de un nodo con valor específico

**Objetivo**: Implementar un método que permita insertar un nuevo nodo **antes** de un nodo con un valor determinado.

**Firma sugerida**:

```java
public void insertarAntesDe(int valorExistente, int nuevoValor)
```

**Lógica**:

* Recorrer la lista hasta encontrar el nodo con el valor indicado.
* Insertar el nuevo nodo justo **antes** del nodo encontrado.
* Si el nodo encontrado es la cabeza, el nuevo nodo se convierte en la nueva cabeza.

**Consideraciones**:

* Validar que el valor exista.
* Manejar correctamente los casos extremos (inicio y fin de la lista).

Perfecto. A continuación te presento una sección titulada **Casos de prueba de los ejercicios complementarios**, correspondiente al **Ejercicio 2 de listas doblemente ligadas**. En ella se detallan casos de prueba para cada uno de los tres ejercicios complementarios previamente definidos, con los siguientes elementos:

* **Datos de entrada**
* **Proceso esperado**
* **Resultado esperado**

---

## 🧪 Casos de prueba de los ejercicios complementarios


### 🔹 Ejercicio C1: Insertar después de un nodo con valor específico

#### 📌 Caso de prueba 1

**Entrada**:

* Lista inicial: `10 ⇄ 20 ⇄ 30`
* Operación: insertar después del nodo con valor `20` el valor `25`

**Proceso esperado**:

* Se recorre la lista hasta encontrar el nodo con `dato = 20`
* Se inserta el nodo `25` después de `20`
* Se actualizan los punteros de `20`, `25` y `30`

**Resultado esperado**:
`10 ⇄ 20 ⇄ 25 ⇄ 30`


#### 📌 Caso de prueba 2

**Entrada**:

* Lista inicial: `5 ⇄ 15 ⇄ 25`
* Operación: insertar después del nodo con valor `25` el valor `35`

**Proceso esperado**:

* `25` es el último nodo
* Se inserta `35` como nuevo nodo al final
* Se actualiza la cola de la lista

**Resultado esperado**:
`5 ⇄ 15 ⇄ 25 ⇄ 35`


#### 📌 Caso de prueba 3 (valor no existente)

**Entrada**:

* Lista inicial: `10 ⇄ 20 ⇄ 30`
* Operación: insertar después de `99` el valor `40`

**Proceso esperado**:

* Se recorre toda la lista sin encontrar el valor `99`
* No se realiza ninguna inserción

**Resultado esperado**:
Mensaje: `"Valor no encontrado"`
Lista permanece igual: `10 ⇄ 20 ⇄ 30`


### 🔹 Ejercicio C2: Eliminar todos los nodos con un valor específico

#### 📌 Caso de prueba 1

**Entrada**:

* Lista inicial: `10 ⇄ 20 ⇄ 20 ⇄ 30 ⇄ 20 ⇄ 40`
* Operación: eliminar todas las ocurrencias de `20`

**Proceso esperado**:

* Se eliminan tres nodos con valor `20`, ajustando enlaces en cada caso

**Resultado esperado**:
`10 ⇄ 30 ⇄ 40`
Mensaje: `"Se eliminaron 3 nodos con valor 20"`


#### 📌 Caso de prueba 2 (valor en cabeza y cola)

**Entrada**:

* Lista inicial: `50 ⇄ 60 ⇄ 70 ⇄ 50`
* Operación: eliminar todas las ocurrencias de `50`

**Proceso esperado**:

* Se elimina el primer nodo (cabeza)
* Se recorre la lista y se elimina también el último nodo (cola)

**Resultado esperado**:
`60 ⇄ 70`
Mensaje: `"Se eliminaron 2 nodos con valor 50"`


#### 📌 Caso de prueba 3 (valor no presente)

**Entrada**:

* Lista inicial: `10 ⇄ 20 ⇄ 30`
* Operación: eliminar todas las ocurrencias de `99`

**Proceso esperado**:

* Se recorre la lista y no se encuentra el valor
* No se eliminan nodos

**Resultado esperado**:
`10 ⇄ 20 ⇄ 30`
Mensaje: `"No se encontró el valor 99"`


### 🔹 Ejercicio C3: Insertar antes de un nodo con valor específico

#### 📌 Caso de prueba 1

**Entrada**:

* Lista inicial: `10 ⇄ 20 ⇄ 30`
* Operación: insertar `15` antes del nodo con valor `20`

**Proceso esperado**:

* Se encuentra el nodo `20`
* Se inserta `15` entre `10` y `20`
* Se ajustan los punteros correctamente

**Resultado esperado**:
`10 ⇄ 15 ⇄ 20 ⇄ 30`


#### 📌 Caso de prueba 2 (insertar antes de la cabeza)

**Entrada**:

* Lista inicial: `100 ⇄ 200 ⇄ 300`
* Operación: insertar `50` antes del nodo con valor `100`

**Proceso esperado**:

* `100` es la cabeza
* `50` se convierte en la nueva cabeza

**Resultado esperado**:
`50 ⇄ 100 ⇄ 200 ⇄ 300`


#### 📌 Caso de prueba 3 (valor no existente)

**Entrada**:

* Lista inicial: `5 ⇄ 10 ⇄ 15`
* Operación: insertar `8` antes de `99`

**Proceso esperado**:

* No se encuentra el nodo con valor `99`
* No se realiza ninguna inserción

**Resultado esperado**:
`5 ⇄ 10 ⇄ 15`
Mensaje: `"Valor no encontrado"`



