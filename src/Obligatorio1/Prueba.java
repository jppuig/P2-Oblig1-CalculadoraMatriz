// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package Obligatorio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Prueba {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String opcion = "M";
        try {
            PrintStream consola = System.out;
            PrintStream archivo = new PrintStream(new FileOutputStream(".\\Test\\salida.txt"));
            Matriz mat = new Matriz();
            boolean entradaCon = true;
            boolean salidaCon = true;

            String menu = "Ingrese la opción \n"
                    + "A: cambiar entrada\t"
                    + "B: cambiar salida\t"
                    + "C: cargar datos\t\t"
                    + "D: mostrar reborde\t"
                    + "E: mostrar tabulación\t"
                    + "F: esquina\n"
                    + "G: puntas\t\t"
                    + "H: ver conectada\t"
                    + "I: molino\t\t"
                    + "J: ver menor común\t"
                    + "K: reacomodar\t\t"
                    + "L: ver iguales\n"
                    + "X: terminar";

            while (opcion.compareTo("X") != 0) {
                int m;
                int n;

                System.out.println(menu);
                opcion = input.nextLine();
                opcion = opcion.toUpperCase();

                switch (opcion) {
                    case "A":
                        // Cambiar entrada
                        if (entradaCon) {
                            input = new Scanner(new File(".\\Test\\datos.txt"));
                        } else {
                            input = new Scanner(System.in);
                        }
                        entradaCon = !entradaCon;
                        break;

                    case "B":
                        // Cambiar salida
                        if (salidaCon) {
                            System.setOut(archivo);
                        } else {
                            System.setOut(consola);
                        }
                        salidaCon = !salidaCon;
                        break;

                    case "C":
                        // Cargar datos
                        System.out.println("Ingrese el largo de la nueva matriz:");
                        m = leerNum(input, true, false);
                        System.out.println("Ingrese el ancho de la nueva matriz:");
                        n = leerNum(input, true, false);
                        int[][] matTrabajo = new int[m][n];
                        
                        for (int i=0;i<m;i++) {
                            System.out.println("Ingrese todos los números de la fila "
                                + (i+1) + " de la nueva matriz:");
                            for (int j=0;j<n;j++) {
                                matTrabajo[i][j] = input.nextInt();
                            }
                        }
                        input.nextLine();
                        
                        mat.setMatriz(matTrabajo);
                        break;

                    case "D":
                        // Mostrar rebordes
                        for (int i=0;i<mat.getMatriz().length;i++) {
                            for (int k=0;k<mat.getMatriz()[0].length;k++) {
                                if (k != mat.getMatriz()[0].length-1) {
                                    System.out.print("+----------");
                                } else {
                                    System.out.print("+----------+");
                                }
                            }
                            System.out.println();

                            for (int j=0;j<mat.getMatriz()[0].length;j++) {
                                if (j == 0) {
                                    System.out.print("|");
                                }

                                System.out.printf("%10d", mat.getMatriz()[i][j]);
                                System.out.print("|");
                            }
                            System.out.println();

                            if (i == mat.getMatriz().length-1) {
                                for (int q=0;q<mat.getMatriz()[0].length;q++) {
                                    if (q != mat.getMatriz()[0].length-1) {
                                        System.out.print("+----------");
                                    } else {
                                        System.out.print("+----------+");
                                    }
                                }
                            }
                        }

                        break;

                    case "E":
                        // Mostrar tabulación
                        for (int i=0;i<mat.getMatriz().length;i++) {
                            for (int j=0;j<mat.getMatriz()[0].length;j++) {
                                System.out.printf("%10d", mat.getMatriz()[i][j]);
                            }
                            System.out.println();
                        }

                        break;

                    case "F":
                        // Esquina
                        System.out.println("Ingrese la dimensión de la matriz cuadrada:");
                        n = leerNum(input, true, false);
                        System.out.println("Ingrese el número en el cual empieza la matriz:");
                        int desde = leerNum(input, false, false);
                        input.nextLine();

                        mat.cargarMatrizEsquina(n, desde);
                        break;

                    case "G":
                        // Puntas
                        System.out.println("Ingrese la dimensión de la matriz cuadrada:");
                        n = leerNum(input, true, true);
                        input.nextLine();
                        
                        mat.cargarPuntas(n);
                        break;

                    case "H":
                        // Ver conectada
                        if (mat.esConectada()) {
                            System.out.println("La matriz es conectada.");
                        } else {
                            System.out.println("La matriz no es conectada.");
                        }
                        break;

                    case "I":
                        // Molino
                        System.out.println("Ingrese la dimensión de la matriz cuadrada:");
                        n = leerNum(input, true, true);
                        input.nextLine();
                        
                        mat.generarMolino(n);
                        break;

                    case "J":
                        // Ver menor común
                        System.out.print("El menor número común entre las filas es: ");
                        System.out.println(mat.menorComunFilas());
                        break;

                    case "K":
                        // Reacomodar
                        System.out.println("Ingrese el largo de la nueva matriz:");
                        m = leerNum(input, true, false);
                        System.out.println("Ingrese el ancho de la nueva matriz:");
                        n = leerNum(input, true, false);
                        input.nextLine();
                        
                        if (mat.reacomodar(m, n)) {
                            System.out.println("Se pudo reacomodar la matriz con éxito.");
                        } else {
                            System.out.println("No se pudo reacomodar la matriz.");
                        }
                        
                        break;

                    case "L":
                        // Ver iguales
                        if (mat.tieneFilaIgual()) {
                            System.out.println("La matriz de trabajo tiene al menos una fila en la que todos"
                                    + " sus números son iguales.");
                        } else {
                            System.out.println("La matriz de trabajo no tiene ninguna fila en la que todos"
                                    + " sus números sean iguales.");
                        }
                        break;

                    case "X":
                        // Terminar
                        break;
                        
                    default:
                        // Opción ingresada errónea
                        if (opcion.compareTo("") == 0) {
                            System.out.println("No ingresó ninguna opción.");
                        } else {
                            System.out.println("La opción ingresada no es correcta.");
                        }
                        break;
                }

                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error con el archivo.");
            input.nextLine();
        }   
    }
    
    public static int leerNum(Scanner input, boolean mayorCero, boolean par) {
        boolean ok = false;
        int dato = 0;
        String txtError = "Este campo solo acepta números.";
        String txtErrorMayorCero = "Este campo solo acepta números mayores a 0.";
        String txtErrorPar = "Este campo solo acepta números pares mayores a 0.";
        
        while (!ok) {
            try {
                dato = input.nextInt();
                if (!mayorCero && !par) {
                    ok = true;
                } else {
                    if (par) {
                        if (dato >= 0 && dato % 2 == 0) {
                            ok = true;
                        } else {
                            System.out.println(txtErrorPar);
                        }
                    } else {
                        if (mayorCero) {
                            if (dato >= 0) {
                                ok = true;
                            } else {
                                System.out.println(txtErrorMayorCero);
                            }
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println(txtError);
                input.nextLine();
            }
        }
        
        return dato;
    }
}
