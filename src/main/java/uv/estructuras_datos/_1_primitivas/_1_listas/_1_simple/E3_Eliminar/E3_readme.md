

# 🧪 Ejercicio 3: Eliminar un elemento por su valor (Lista Simple)

## 🎯 Objetivo del ejercicio

Ampliar la implementación de la lista simplemente ligada para permitir al usuario **eliminar un nodo por su valor**, contemplando los **tres posibles casos**: cuando el nodo a eliminar está al **inicio**, en el **medio**, o al **final** de la lista. Este ejercicio profundiza en el manejo de punteros y condiciones de frontera.

## 📁 Archivos a modificar

* `ListaSimple.java`
* `MenuListaSimple.java`

> ⚠️ No es necesario modificar `Nodo.java` ni `Principal.java`.

## 🔧 Cambios solicitados 

### 📝 Archivo: `ListaSimple.java`

#### ✅ Cambios a realizar:

1. **Agregar el método `eliminar(int valor)`**

#### 📘 Código a agregar:

```java
public void eliminar(int valor) {
    // Paso 1: Verificar si la lista está vacía
    if (cabeza == null) {
        System.out.println("La lista está vacía.");
        return;
    }

    // Paso 2: Caso especial - el nodo a eliminar está al inicio
    if (cabeza.dato == valor) {
        cabeza = cabeza.siguiente; // Avanza la cabeza al siguiente nodo
        System.out.println("Elemento eliminado desde el inicio.");
        return;
    }

    // Paso 3: Inicializamos punteros para recorrer la lista
    Nodo actual = cabeza;        // El nodo que se va a examinar
    Nodo anterior = null;        // El nodo anterior al actual

    // Paso 4: Recorrer la lista hasta encontrar el valor
    while (actual != null && actual.dato != valor) {
        anterior = actual;
        actual = actual.siguiente;
    }

    // Paso 5: Si llegamos al final y no se encontró el valor
    if (actual == null) {
        System.out.println("El elemento no se encontró.");
        return;
    }

    // Paso 6: Evaluar si el nodo está al final
    if (actual.siguiente == null) {
        // El nodo a eliminar es el último, se desconecta
        anterior.siguiente = null;
        System.out.println("Elemento eliminado desde el final.");
        return;
    }

    // Paso 7: El nodo está en medio de la lista
    anterior.siguiente = actual.siguiente;
    System.out.println("Elemento eliminado desde el medio.");
}
```

#### 🧠 Lógica detrás del cambio:

Este método elimina **la primera ocurrencia** de un nodo que contenga el valor indicado. Para lograrlo, se deben considerar tres posibles ubicaciones del nodo a eliminar:

1. El nodo está al **inicio** de la lista (es la cabeza).
2. El nodo está en **medio** de la lista.
3. El nodo está al **final** de la lista.

Además, debemos verificar si la lista está vacía.

### 🧠 ¿Por qué usamos dos punteros?

* `actual`: es el nodo que queremos examinar.
* `anterior`: es el nodo que apunta al `actual`.

Cuando encontramos el nodo a eliminar, **no podemos modificarlo directamente**, así que necesitamos usar `anterior` para decirle:
"**tu siguiente nodo ya no será `actual`, sino el que sigue después de él**".


### 📌 Resumen visual

Supongamos esta lista:
`[10] -> [20] -> [30] -> [40] -> null`

Queremos eliminar `30`.

* `anterior` está en `20`
* `actual` está en `30`
* El nuevo enlace será: `20.siguiente = 40`
  Resultado:
  `[10] -> [20] -> [40] -> null`


### ⚠️ Consideraciones especiales

* Este método **elimina solo la primera coincidencia** del valor.
* Si el nodo está al inicio, simplemente se avanza la cabeza.
* Si el nodo está en el medio o al final, se necesita ajustar el enlace del nodo anterior.


### 📝 Archivo: `MenuListaSimple.java`

#### ✅ Cambios a realizar:

1. **Agregar opción 4 para eliminar por valor**
2. **Actualizar numeración del menú**

#### 📘 Código a modificar:

```java
case 6 -> {
    System.out.print("Número a eliminar: ");
    int valor = entrada.nextInt();
    lista.eliminar(valor);
}
```

Y actualiza el menú visible al usuario:

```java
 System.out.println("\n--- MENÚ: LISTA SIMPLE (Inicio, Final, Búsqueda) ---");
 System.out.println("1. Insertar al final");
 System.out.println("2. Insertar al inicio"); 
 System.out.println("3. Buscar un número");   
 System.out.println("4. Mostrar la lista");
 System.out.println("5. Verificar si la lista está vacía");
 System.out.println("6. Eliminar un elemento de la lista"); // <-- Agregar
 System.out.println("0. Salir");
 System.out.print("Selecciona una opción: ");
```


## ✅ Resultado esperado

### 🧪 Escenario de prueba:

1. Inserta los números: `10`, `20`, `30`, `40`

2. Muestra la lista:
   `10 -> 20 -> 30 -> 40 -> null`

3. Elimina el número `10` (inicio)
   Resultado esperado: `"Elemento eliminado desde el inicio."`
   Nueva lista: `20 -> 30 -> 40 -> null`

4. Elimina el número `40` (final)
   Resultado esperado: `"Elemento eliminado desde el final."`
   Nueva lista: `20 -> 30 -> null`

5. Elimina el número `30` (medio)
   Resultado esperado: `"Elemento eliminado desde el medio."`
   Nueva lista: `20 -> null`

6. Elimina el número `99` (no existe)
   Resultado esperado: `"El elemento no se encontró."`


## 🧠 Reflexión (Agregar a cuaderno de ejercicios)

* ¿Por qué es importante mantener referencias al nodo anterior al eliminar?
* ¿Qué ocurre si eliminas todos los nodos uno por uno?
* ¿Podrías adaptar el método para eliminar **todas las ocurrencias** de un valor?

## 📎 Actividad complementaria (Agregar a cuaderno de ejercicios)

Agrega una opción al menú que elimine **todos los nodos que tengan un valor dado**, en lugar de solo la primera ocurrencia.













