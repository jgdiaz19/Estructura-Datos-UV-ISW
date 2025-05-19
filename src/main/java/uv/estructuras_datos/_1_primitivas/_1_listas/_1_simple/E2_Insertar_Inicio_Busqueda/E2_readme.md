# 🧪 Ejercicio 2: Insertar al Inicio y Buscar (Lista Simple)

## 🎯 Objetivo del ejercicio

Ampliar la funcionalidad del ejercicio anterior para que la lista simplemente ligada permita **insertar elementos al inicio** y **buscar un valor entero**. El alumno trabajará **modificando el código existente**, no creándolo desde cero.

---

## 📁 Archivos a modificar

* `ListaSimple.java`
* `MenuListaSimple.java`

> ⚠️ **No es necesario modificar `Nodo.java` ni `Principal.java`.**

---

## 🔧 Cambios solicitados y explicación

### 📝 Archivo: `ListaSimple.java`

#### ✅ Cambios a realizar:

1. **Agregar el método `insertarAlInicio(int dato)`**
2. **Agregar el método `buscar(int valor): boolean`**

#### 📌 ¿Dónde?

Coloca ambos métodos debajo de `insertarAlFinal()`.

#### 📘 Código a agregar:

```java
public void insertarAlInicio(int dato) {
    Nodo nuevo = new Nodo(dato);
    nuevo.siguiente = cabeza;
    cabeza = nuevo;
}

public boolean buscar(int valor) {
    Nodo actual = cabeza;
    while (actual != null) {
        if (actual.dato == valor) {
            return true;
        }
        actual = actual.siguiente;
    }
    return false;
}
```

#### 🧠 Lógica detrás de los cambios:

* `insertarAlInicio()` crea un nodo y lo enlaza como nueva cabeza de la lista. El nodo anterior se convierte en el siguiente del nuevo.
* `buscar()` recorre nodo por nodo comparando el valor. Si encuentra coincidencia, retorna `true`; si llega al final sin encontrarlo, retorna `false`.

---

### 📝 Archivo: `MenuListaSimple.java`

#### ✅ Cambios a realizar:

1. **Agregar nuevas opciones al menú:**

    * Opción 2: Insertar al inicio
    * Opción 3: Buscar un número
2. **Actualizar la numeración de las opciones existentes**

#### 📘 Código a agregar/modificar:

* En el método `mostrarMenu()`:

Agrega estas líneas dentro del `switch`:

```java
case 2 -> {
    System.out.print("Introduce un número: ");
    int numero = entrada.nextInt();
    lista.insertarAlInicio(numero);
    System.out.println("Número insertado al inicio.");
}

case 3 -> {
    System.out.print("Número a buscar: ");
    int valor = entrada.nextInt();
    boolean encontrado = lista.buscar(valor);
    System.out.println(encontrado ? "Número encontrado." : "Número no encontrado.");
}
```

Y actualiza el menú impreso al usuario:

```java
System.out.println("1. Insertar al final");
System.out.println("2. Insertar al inicio");
System.out.println("3. Buscar un número");
System.out.println("4. Mostrar la lista");
System.out.println("5. Verificar si la lista está vacía");
System.out.println("0. Salir");
```

---

## ✅ Resultado esperado

Ejecuta la clase `Principal.java` y prueba el siguiente flujo:

1. Inserta un número al **inicio** (por ejemplo, `30`)
2. Inserta un número al **final** (por ejemplo, `10`)
3. Usa la opción de **buscar** para verificar si `30` está en la lista
4. Muestra la lista y verifica el orden de los elementos

---

## 🧠 Reflexión

* ¿Cuál es la diferencia visual y lógica entre insertar al inicio y al final?
* ¿La búsqueda es eficiente en listas simplemente ligadas? ¿Por qué?

---

## 📎 Actividad complementaria

Agrega una opción al menú que permita **mostrar solo el primer elemento (cabeza)** de la lista.

