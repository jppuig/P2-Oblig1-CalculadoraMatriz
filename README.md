# MATRIZ - Obligatorio 1  - (Programación 2)

## PARTE 1)

Se desea implementar en Java la clase Matriz que tiene como atributo una matriz de trabajo de enteros y ofrezca diferentes métodos sobre dicha matriz numérica:

```
public void cargarMatrizEsquina(int n, int desde) Crea una matriz cuadrada de n*n, cargada en forma de “esquina” con el valor "desde" en la posición 0, 0 y la almacena como matriz de trabajo.
Ver ejemplo.
Ejemplo de matriz esquina con n=5 y desde=
10 11 12 13 14
11 11 12 13 14
12 12 12 13 14
13 13 13 13 14
14 14 14 14 14
```
```
public void cargarPuntas(int n) Crea una matriz cuadrada de n*n (n par), cargada según el patrón y la almacena como matriz de trabajo. Ver ejemplo.
Ejemplo: n = 8
4 3 2 1 1 2 3 4
3 2 1 0 0 1 2 3
2 1 0 0 0 0 1 2
1 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1
2 1 0 0 0 0 1 2
3 2 1 0 0 1 2 3
4 3 2 1 1 2 3 4
```
```
public boolean esConectada() Debe retornar true si todos los números 0 de la matriz de trabajo son adyacentes en forma vertical u horizontal. Si no hay 0 o no cumple, no
es conectada.
Ejemplo de matriz conectada:
1 0 1 4 56 0
0 0 0 33 4 0
0 3 4 -2 0 0
0 0 0 5 0 6
7 0 0 0 0 0
```
```
public void generarMolino(int n) Crea una matriz cuadrada de n*n (n par), cargada según “aspas” de un molino y la asigna como matriz de trabajo. Ver ejemplo.
Ejemplo n= 6:
1 1 1 0 0 1
0 1 1 0 1 1
0 0 1 1 1 1
1 1 1 1 0 0
1 1 0 1 1 0
1 0 0 1 1 1
```
```
public int[][] getMatriz() Retorna la matriz de trabajo.
```
```
public Matriz() El constructor por defecto crea una matriz de 4 * 5 , iniciada en números randómicos entre 0 y 10 (ambos inclusive).
```
```
public String menorComunFilas() Retorna un string que contiene el menor elemento común a todas las filas de la matriz de trabajo. Si no hay, retorna el string "NO TIENE".
Ejemplo:
1 5 8 4 2
5 2 0 7 9
- 3 8 5 -2 2
Retorna "2"
```
```
public boolean reacomodar(int m, int n) Crea una nueva matriz, que es el resultado de reacomodar recorriendo por filas los elementos en la cantidad m de filas y n de columnas y la asigna como matriz de trabajo. Si no se puede reacomodar, no se modifica la matriz de trabajo. Retorna true si se pudo modificar.
Ejemplo: m= 1 n = 4, siendo la matriz de trabajo:
1 2
3 4
Se obtiene como matriz de trabajo: [1 2 3 4]. Retorna true.
```
```
public void setMatriz(int[][] mat) Recibe una matriz y la almacena como matriz de trabajo.
```
```
public boolean tieneFilaIgual() Retorna verdadero si hay alguna fila de la matriz de trabajo que tenga todos sus números iguales.
Ejemplo:
4 2 5 1 2
2 2 2 2 2
5 2 -1 6 7
Retorna true.
```
Nota: de ser necesario, se pueden crear otros métodos privados. No se puede modificar la firma de los métodos pedidos.

## PARTE 2)

Implementar en Java en la clase Prueba el main para ejemplificar el uso de la clase Matriz ofreciendo un menú de consola que permita usar las veces deseadas las opciones que se detallan más abajo.
IMPORTANTE: el menú DEBE utilizar las letras indicadas para cada opción, y aceptar minúsculas o mayúsculas.

El menú a presentar es similar al siguiente:

El programa crea un objeto de la clase Matriz (usando el método 6) y sobre ese objeto se trabajará desde el menú. Inicialmente la entrada y salida es por consola.

#### Detalle de las opciones:

a) cambiar la forma de entrada. Al ingresar a esta opción, se modificará la forma de entrada: de ingresar por consola a ingresar desde el archivo “entrada.txt” (ubicado en la carpeta test del proyecto), o viceversa. (Ver nota al final).

b) cambiar la forma de salida. Al ingresar a esta opción, se modificará la forma de salida: de consola al archivo “salida.txt” (ubicado en la carpeta test del proyecto), o viceversa. (Ver nota al final).

c) cargar matriz numérica para trabajo. Se ingresa la cantidad de filas, cantidad de columnas y todos los elementos de la matriz por filas. Esta matriz se utilizará en las consultas. Usa el método 9 - setMatriz.

d) mostrar matriz de trabajo con reborde. Utiliza el método 5 - getMatriz para obtener la matriz y la muestra. Ejemplo: (observar alineación y formato del reborde)

e) mostrar matriz de trabajo con tabulación. Utiliza el método 5 - getMatriz para obtener los datos y la muestra. Ejemplo:
(observar alineación a la derecha).

f) cargar Matriz Esquina. Se ingresa el valor de n y desde qué valor iniciar y se aplica en la matriz de trabajo el método cargarMatrizEsquina.

g) cargar Puntas. Se ingresa el valor n (debe ser par) y se aplica en la matriz de trabajo el método 2 - cargarPuntas.

h) es Conectada. Se muestra si la matriz de trabajo es conectada o no, usando el método 3- esConectada.

i) generar Molino. Se ingresa el valor de n (debe ser par) y se aplica en la matriz de trabajo el método 4 - generarMolino.

j) menor Comun Filas. Muestra el menor elemento común de la matriz de trabajo, utiliza el método 7 - menorComunFilas

k) reacomodar. Se ingresa la cantidad de filas y columnas. Si es posible, se reacomoda la matriz de trabajo e informa si se pudo realizar, utiliza el método 8 - reacomodar.

l) tiene Fila Igual. Muestra si la matriz de trabajo tiene o no fila igual, usando el método 10 - tieneFilaIgual.

x) termina el programa.