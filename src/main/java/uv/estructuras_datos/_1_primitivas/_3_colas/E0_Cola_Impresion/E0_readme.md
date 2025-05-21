## Principales operaciones con colas simples

| Nº | Operación                  | Descripción                                                                 | Lógica paso a paso                                                                                                  | Complejidad |
|----|----------------------------|-----------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|-------------|
| 1  | Agregar (Enqueue)          | Inserta un nuevo elemento al final de la cola                               | - Crear nodo <br> - Si está vacía: frente = fin = nuevo <br> - Si no: fin.siguiente = nuevo; fin = nuevo            | O(1)        |
| 2  | Eliminar (Dequeue)         | Elimina el elemento en el frente de la cola                                 | - Verificar si está vacía <br> - Guardar frente <br> - frente = frente.siguiente <br> - Si frente = null, fin = null | O(1)        |
| 3  | Eliminar todos             | Vacía completamente la cola                                                 | - frente = null <br> - fin = null                                                                                   | O(1)        |
| 4  | Buscar elemento            | Verifica si un valor está presente en la cola                               | - Recorrer con un puntero desde frente <br> - Comparar nodo por nodo <br> - Retornar true si encuentra, si no false | O(n)        |
| 5  | Mostrar cola               | Imprime todos los elementos en orden desde el frente                        | - Verificar si está vacía <br> - Recorrer desde frente e imprimir                                                  | O(n)        |
| 6  | Imprimir y vaciar (Procesar) | Simula la impresión eliminando uno a uno los elementos                     | - Mientras frente != null: imprimir, luego avanzar frente <br> - fin = null                                         | O(n)        |
| 7  | Fusionar con otra cola     | Une los elementos de dos colas en una nueva sin modificar las originales    | - Crear nueva cola <br> - Recorrer c1 y agregar <br> - Recorrer c2 y agregar                                       | O(n + m)    |
| 8  | Verificar si está vacía    | Comprueba si la cola no contiene elementos                                  | - Retornar `frente == null`                                                                                        | O(1)        |


#  Fundamentos de la Notación Big-O

## 🎯 Objetivo

Introducir el concepto de notación Big-O para medir la eficiencia de los algoritmos, abordando los diferentes tipos de complejidad temporal, su interpretación y cuándo se presentan.


## 📘 ¿Qué Big-O?

La notación Big-O (O grande) es una forma matemática de describir el **crecimiento del tiempo de ejecución** de un algoritmo en función del tamaño de su entrada (`n`). No mide el tiempo en segundos, sino la **cantidad de pasos** relativos que realiza el algoritmo.


## 🔍 Propiedades clave

* **Se enfoca en el peor caso**.
* Ignora constantes y términos menos significativos.
* Nos dice **cómo escala** un algoritmo cuando crece el tamaño de los datos.


## 📊 Tipos comunes de complejidad

| Notación   | Nombre             | Descripción                                            | Ejemplo de algoritmo típico             |
| ---------- | ------------------ | ------------------------------------------------------ | --------------------------------------- |
| O(1)       | Constante          | El tiempo no depende del tamaño de la entrada          | Acceso directo a un arreglo             |
| O(log n)   | Logarítmica        | El tiempo crece lentamente al aumentar la entrada      | Búsqueda binaria                        |
| O(n)       | Lineal             | El tiempo crece proporcionalmente al tamaño de entrada | Búsqueda secuencial                     |
| O(n log n) | Lineal logarítmica | Más lento que lineal, pero mejor que cuadrático        | Merge Sort, Quick Sort (promedio)       |
| O(n²)      | Cuadrática         | Tiempo crece al cuadrado del tamaño de entrada         | Burbujas, Selección, Inserción          |
| O(2ⁿ)      | Exponencial        | Tiempo se duplica con cada elemento agregado           | Problemas de recursión sin optimización |
| O(n!)      | Factorial          | Todos los órdenes posibles deben evaluarse             | Algoritmos de permutación, fuerza bruta |


## 🎓 Reglas prácticas

* Solo se considera el **término de mayor crecimiento**.

    * Ejemplo: `O(n² + n)` se simplifica a `O(n²)`
* Las constantes **no se consideran**.

    * Ejemplo: `O(3n)` → `O(n)`


## 🧠 ¿Por qué importa?

Comprender la notación Big-O te permite:

* Predecir cuán **eficiente** será un algoritmo con datos grandes.
* Comparar **dos soluciones** a un mismo problema.
* Identificar **cuellos de botella** en el diseño del software.


## 🔧 Código ilustrativo para cada tipo de complejidad

En esta sección, mostraremos **fragmentos de código en Java** con una breve explicación que ilustre el comportamiento de cada tipo de complejidad.


### 🔸 **O(1) - Complejidad Constante**

**Código asociado:**

```java
int[] arreglo = {10, 20, 30, 40};
System.out.println(arreglo[2]); // acceso directo
```

**Explicación detallada:**

Esta línea de código accede directamente al **tercer elemento** de un arreglo (índice 2, ya que en Java los índices empiezan en 0). No importa si el arreglo tiene 4, 100 o 10,000 elementos; el tiempo que se tarda en recuperar el valor `30` **siempre será el mismo**.

¿Por qué?
Porque los arreglos en Java están organizados en posiciones de memoria contiguas, y el lenguaje puede calcular la dirección del elemento deseado con una simple fórmula:

```
dirección_base + (tamaño_elemento * índice)
```

Esto significa que **no tiene que recorrer el arreglo** para encontrar ese elemento. Por eso se dice que el acceso es **constante**, o sea, de **complejidad O(1)**.

📌 **Analogía:** Imagina que tienes un archivero con cajones numerados. Puedes abrir directamente el cajón número 3 sin necesidad de revisar el 1 ni el 2.


### 🔸 **O(log n) - Complejidad Logarítmica**

**Código asociado:**

```java
public int busquedaBinaria(int[] arr, int clave) {
    int inicio = 0, fin = arr.length - 1;
    while (inicio <= fin) {
        int medio = (inicio + fin) / 2;
        if (arr[medio] == clave) return medio;
        if (clave < arr[medio]) fin = medio - 1;
        else inicio = medio + 1;
    }
    return -1;
}
```

**Explicación detallada:**

La **búsqueda binaria** solo funciona si el arreglo ya está **ordenado**.

1. Empieza examinando el **elemento del medio** del arreglo.
2. Si ese elemento es el que buscas → listo, lo encontraste.
3. Si el número buscado es menor al del medio → descartas la **mitad derecha** del arreglo.
4. Si es mayor → descartas la **mitad izquierda**.
5. Repites este proceso con la mitad restante.

Esto se repite hasta encontrar el número o hasta que se agoten las posibilidades.
En cada paso, el tamaño del problema se reduce a la mitad.

Por eso la complejidad es `O(log n)`.

📌 **Analogía:** Es como buscar una palabra en un diccionario: abres al medio, decides si está antes o después, y sigues partiendo en mitades.


### 🔸 **O(n) - Complejidad Lineal**

**Código asociado:**

```java
for (int i = 0; i < arreglo.length; i++) {
    System.out.println(arreglo[i]);
}
```

**Explicación detallada:**

Este es un **recorrido completo** de un arreglo. La variable `i` empieza en 0 y va aumentando hasta llegar al último índice.

En cada paso se imprime el valor del elemento en la posición `i`.
Si el arreglo tiene 10 elementos, habrá 10 impresiones. Si tiene 1,000, habrá 1,000. Por eso el tiempo crece **en proporción directa al tamaño de la entrada**.

Se le llama complejidad lineal `O(n)` porque el **número de pasos aumenta linealmente** con la cantidad de elementos que hay.

📌 **Analogía:** Es como leer una lista de nombres en voz alta: lees uno por uno, sin saltarte ninguno.


### 🔸 **O(n log n) - Complejidad Lineal Logarítmica**

**Código asociado:**

```java
public void mergeSort(int[] arr, int izquierda, int derecha) {
    if (izquierda < derecha) {
        int medio = (izquierda + derecha) / 2;
        mergeSort(arr, izquierda, medio);
        mergeSort(arr, medio + 1, derecha);
        merge(arr, izquierda, medio, derecha);
    }
}
```

**Explicación detallada:**

Este es un ejemplo de **Merge Sort**, un algoritmo de ordenamiento muy eficiente.

Funciona así:

1. **Divide** el arreglo a la mitad (recursivamente), hasta que cada subarreglo tenga solo un elemento.
2. Luego **combina (merge)** esos subarreglos, **ordenando** en el proceso.

* Cada división reduce el problema a la mitad → `log n` pasos (como en búsqueda binaria).
* Cada nivel de división requiere recorrer todo el arreglo para mezclar los subarreglos → `n` pasos.

Por eso la complejidad total es `O(n log n)`.

📌 **Analogía:** Imagina que separas un mazo de cartas en montones de una carta y luego las unes ordenadamente. Lo haces en varios niveles.


### 🔸 **O(n²) - Complejidad Cuadrática**

**Código asociado:**

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

**Explicación detallada:**

Este fragmento tiene **dos bucles anidados**, lo que significa que por cada valor de `i`, se ejecuta completamente el bucle interno `j`.

Si `n = 5`, el bucle interno se ejecutará 5 veces por cada una de las 5 iteraciones del bucle externo → 25 pasos.

El número total de operaciones será:

```
n * n = n²
```

Por eso su complejidad es `O(n²)`.

📌 **Analogía:** Es como tener que revisar todos los asientos en una sala de cine para encontrar una pareja: revisas cada fila, y dentro de cada fila, cada asiento.


### 🔸 **O(2ⁿ) - Complejidad Exponencial**

**Código asociado:**

```java
public int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

**Explicación detallada:**

Esta es una **implementación recursiva ingenua** de la serie de Fibonacci.

Cada llamada a la función **genera dos nuevas llamadas**, y esas a su vez, dos más…
Esto forma un **árbol de llamadas** que crece exponencialmente.

Por ejemplo, para calcular `fibonacci(5)` se hacen 15 llamadas. Para `fibonacci(10)`, se hacen 177.
El número de operaciones **se duplica** con cada incremento en `n`.

Por eso se dice que su complejidad es `O(2ⁿ)`.

📌 **Analogía:** Es como si cada persona que preguntas te dijera que preguntes a dos más. Pronto tendrías cientos de personas involucradas.


### 🔸 **O(n!) - Complejidad Factorial**

**Código asociado:**

```java
public void permutar(String prefijo, String resto) {
    if (resto.length() == 0) System.out.println(prefijo);
    for (int i = 0; i < resto.length(); i++) {
        permutar(prefijo + resto.charAt(i), resto.substring(0, i) + resto.substring(i + 1));
    }
}
```

**Explicación detallada:**

Este algoritmo genera **todas las permutaciones posibles** de un conjunto de caracteres.

Si tienes:

* 2 letras → 2 permutaciones
* 3 letras → 6 permutaciones
* 4 letras → 24 permutaciones

Esto ocurre porque para `n` elementos hay `n!` formas de ordenarlos.

Cada vez que agregas un nuevo carácter, **la cantidad de combinaciones se multiplica**.
Así, el tiempo de ejecución **crece más rápido que en cualquier otro tipo de complejidad**.

📌 **Analogía:** Es como intentar probar todas las combinaciones posibles de contraseñas. Inviable si hay más de unos pocos elementos.


>Hasta aqui seguramente estaras pensando que las notaciones que involucran el uso de logaritmos no te quedan del todo claras.
> Te invito a que revisemos los logaritmos y su relacion con la notacion Big-O y el codigo.


## 📚 ¿Qué es un logaritmo y por qué aparece en la notación Big-O?

### 🎯 Objetivo didáctico

Que el estudiante **entienda intuitivamente**:

* Qué significa `log n` en algoritmos.
* Por qué aparece en la notación Big-O.
* Cómo se comporta `O(log n)` comparado con `O(n)` o `O(n²)`.
* Qué patrones de código generan esta complejidad.


## 🧠 ¿Qué es un logaritmo?

Un **logaritmo** es el **número de veces que debes dividir entre 2 (o entre otro número base)** hasta llegar a 1.

Por ejemplo:

| Número (n) | log₂(n) |
| ---------- | ------- |
| 1          | 0       |
| 2          | 1       |
| 4          | 2       |
| 8          | 3       |
| 16         | 4       |
| 32         | 5       |
| 64         | 6       |

**¿Qué significa `log₂(64) = 6`?**
→ Que puedes dividir 64 entre 2 exactamente **6 veces** hasta obtener 1.


## 📊 Comparación de crecimientos

| n (tamaño) | O(1) | O(log n) | O(n) | O(n log n) | O(n²)     |
| ---------- | ---- | -------- | ---- | ---------- | --------- |
| 10         | 1    | 3.3      | 10   | 33         | 100       |
| 100        | 1    | 6.6      | 100  | 660        | 10,000    |
| 1,000      | 1    | 9.9      | 1000 | 9,900      | 1,000,000 |

📌 **Conclusión:** El logaritmo crece **lentamente**, incluso con valores muy grandes de `n`.


## 🔍 ¿Cómo se relaciona con el código?

Cuando en un algoritmo **se reduce el tamaño del problema a la mitad en cada paso**, su complejidad suele ser `O(log n)`.

---

## 📦 Ejemplo: Búsqueda Binaria

```java
public int buscar(int[] arreglo, int valor) {
    int inicio = 0, fin = arreglo.length - 1;
    while (inicio <= fin) {
        int medio = (inicio + fin) / 2;
        if (arreglo[medio] == valor) return medio;
        if (valor < arreglo[medio]) fin = medio - 1;
        else inicio = medio + 1;
    }
    return -1;
}
```

### Explicación paso a paso:

1. El arreglo está ordenado.
2. Empiezo por el **centro**.
3. Cada vez que **descarto la mitad del arreglo**.
4. Esto ocurre una y otra vez, hasta que el tamaño del problema es 1.

---

## 🧠 ¿Por qué `O(log n)`?

Porque el número de veces que se puede dividir un arreglo entre 2 antes de que quede 1 elemento es precisamente `log₂(n)`.

---

### 🔁 Visualización del comportamiento

Supongamos que tengo un arreglo de 64 elementos:

1. Divido en 2 → 32
2. Divido en 2 → 16
3. Divido en 2 → 8
4. Divido en 2 → 4
5. Divido en 2 → 2
6. Divido en 2 → 1

→ Hice 6 divisiones ⇒ `log₂(64) = 6` → el algoritmo hizo 6 pasos.


### 📌 Analogía simple

📖 **Buscar una palabra en el diccionario:**

* No revisas una por una desde la A hasta la Z.
* Abres al centro, ves si estás antes o después de la palabra buscada, y te mueves.
* Con cada paso, descartas **la mitad de las páginas**.
* Esa es la esencia de un algoritmo logarítmico.



> “Cuando un algoritmo descarta la mitad del problema en cada paso, su tiempo de ejecución crece **como logaritmo**, no como una línea recta. Eso lo hace **rápido incluso con entradas muy grandes**.”


## 🧪 ¿Qué otros algoritmos son `O(log n)`?

* **Búsqueda binaria** en arreglos ordenados.
* Operaciones en **árboles balanceados** (AVL, Red-Black Tree).
* **Heap**: inserción y extracción en colas de prioridad.


Por supuesto. A continuación te presento una **explicación detallada y completamente desarrollada** de la complejidad **O(n log n)**, siguiendo el mismo estilo pedagógico e ilustrativo que en los casos anteriores. Este tipo de complejidad es especialmente importante en algoritmos de ordenamiento eficientes.

---

# 📐 Sección: Complejidad **O(n log n)**

---

## 🎯 ¿Qué significa `O(n log n)`?

Esta notación indica que el tiempo de ejecución de un algoritmo **crece más rápido que linealmente**, pero **no tanto como cuadráticamente**.

* El **`log n`** proviene de **dividir el problema** en partes (como en `O(log n)`).
* El **`n`** representa que **cada elemento se debe procesar** en cada una de esas divisiones.

---

## 🔄 ¿Qué tipo de algoritmos generan esta complejidad?

Los algoritmos **"divide y vencerás"** (Divide and Conquer) más eficientes suelen tener esta complejidad.

Ejemplos:

* **Merge Sort**
* **Quick Sort** (en el caso promedio)
* **Heap Sort**
* Algunos algoritmos de conteo y agrupamiento (como algunos radix/counting en su forma mejorada)

---

## 📦 Código ilustrativo: `Merge Sort`

Este es el código de referencia que ilustra este tipo de complejidad:

```java
public void mergeSort(int[] arr, int izquierda, int derecha) {
    if (izquierda < derecha) {
        int medio = (izquierda + derecha) / 2;
        mergeSort(arr, izquierda, medio);
        mergeSort(arr, medio + 1, derecha);
        merge(arr, izquierda, medio, derecha);
    }
}
```

## 🧠 Explicación detallada paso a paso

### 🔹 Fase 1: División (log n pasos)

* El arreglo se **divide a la mitad** de forma recursiva.
* Se repite hasta que cada subarreglo tiene un solo elemento.

Ejemplo para un arreglo de 8 elementos:

```
Original:         [A B C D E F G H]
División 1:       [A B C D]   [E F G H]
División 2:   [A B] [C D]     [E F] [G H]
División 3: [A] [B] [C] [D]   [E] [F] [G] [H]
```

📌 **Número de niveles de división**: `log₂(n)`
Para `n = 8`, hay 3 niveles de división → `log₂(8) = 3`

---

### 🔹 Fase 2: Combinación (n operaciones por nivel)

Una vez que tenemos subarreglos de 1 elemento, empezamos a **combinarlos (merge)**:

* Se comparan y ordenan pares de elementos.
* Cada nivel de la combinación **procesa todos los elementos** al menos una vez.

Ejemplo para 8 elementos:

```
[A] + [B] → [A B]
[C] + [D] → [C D]
...
[A B] + [C D] → [A B C D]
...
→ [A B C D E F G H]
```

📌 **En cada nivel**, los `n` elementos se comparan y mueven → `n` operaciones.

---

### 🔁 ¿Por qué `O(n log n)`?

* Hay **log n niveles** de recursión por la división.
* En cada nivel, se hace un trabajo **proporcional a n** para fusionar.

Por lo tanto:

```text
Trabajo total = (n elementos por nivel) × (log n niveles) = O(n log n)
```


## 🔬 Comparación con otras complejidades

| Tamaño (`n`) | O(n)  | O(n log n) | O(n²)     |
| ------------ | ----- | ---------- | --------- |
| 10           | 10    | 33         | 100       |
| 100          | 100   | 664        | 10,000    |
| 1,000        | 1,000 | \~10,000   | 1,000,000 |

📌 **O(n log n)** es ideal para algoritmos de ordenamiento de propósito general.
📌 Mucho más eficiente que `O(n²)` en datos grandes.



