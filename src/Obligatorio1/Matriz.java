// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package Obligatorio1;

public class Matriz {
    //Atributo Matriz
    private int[][] matrizDeTrabajo;
    
    //Metodos de acceso
    public int[][] getMatriz(){
        return matrizDeTrabajo;
    }
    
    public void setMatriz(int[][] unaMatriz){
        matrizDeTrabajo = unaMatriz;
    }
    
    //Constructor
    public Matriz(){
        int[][] matrizConstructora = new int[4][5];
        
        for(int i=0;i<4;i++){
            for(int j=0;j<5;j++){
                int numeroAleatorio = (int)Math.floor(Math.random()* 11);
                matrizConstructora[i][j] = numeroAleatorio; 
            }
        }
        
        this.setMatriz(matrizConstructora);
    }
    
    //Metodos solicitados
    public void cargarMatrizEsquina(int n, int desde){
        int[][] matrizEsquina = new int[n][n];
        int aux = desde;
        
        for (int i=0;i<n;i++) {
            for (int j=0;j<=i;j++) {
                matrizEsquina[i][j] = aux;
            }
            aux++;
            int auxDesde = aux;
            
            for (int k=i+1;k<n;k++) {
                matrizEsquina[i][k] = auxDesde;
                auxDesde++;
            }
        }
        
        this.setMatriz(matrizEsquina);
    }
    
    public void cargarPuntas(int n){
        int[][] matrizPuntas = new int[n][n];
        boolean mitadCol = true;
        boolean mitadFilas = true;
        int rango = n/2;
        int menosI = 1;
        
        for (int i=0;i<n;i++) {
            if (mitadFilas && i != 0) {
                rango--;
            }
            int num = rango;
            int menosJ = 1;
            mitadCol = true;
            
            for (int j=0;j<n;j++) {
                if (mitadFilas) {
                    if (mitadCol) {
                        matrizPuntas[i][j] = num;
                        
                        if (num != 0) {   
                            num--;
                        }
                    } else {
                        matrizPuntas[i][j] = matrizPuntas[i][j - menosJ];
                        menosJ += 2;
                    }
                } else {
                    matrizPuntas[i][j] = matrizPuntas[i - menosI][j];
                }
                
                if ((n/2) - 1 == j) {
                    mitadCol = false;
                }
            }
            
            if ((n/2) - 1 == i) {
                mitadFilas = false;
            }
            if (i >= n/2) {
                menosI += 2;
            }
        }
        
        this.setMatriz(matrizPuntas);
    }

    public boolean esConectada() {
        int[][] mat = new int[this.getMatriz().length+2][this.getMatriz()[0].length+2];
        boolean ok = true;
        boolean cero = false;
        boolean cambio = true;
        int matI = 1;
        int matJ = 1;
        
        // Agrega reborde de 1 alrededor de la matriz y copia en el centro la matriz de trabajo
        // Cambia los números negativos de la matriz de trabajo por 1 (solo me interesan los 0)
        for (int i=0;i<mat.length;i++) {
            for (int j=0;j<mat[0].length;j++) {
                if (i == 0 || i == mat.length-1 || j == 0 || j == mat[0].length-1 || this.getMatriz()[i-1][j-1] < 0) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = this.getMatriz()[i-1][j-1];
                }
            }
        }

        // Encuentra el primer cero
        while(!cero && ok) {
            if (mat[matI][matJ] == 0) {
                cero = true;
                // Si tiene cero vecino lo cambia por -1
                if (mat[matI - 1][matJ] == 0 || mat[matI + 1][matJ] == 0 || mat[matI][matJ - 1] == 0 || mat[matI][matJ + 1] == 0) {
                    mat[matI][matJ] = -1;
                } else {
                    // Si no tiene cero vecino la matriz ya no es conectada
                    ok = false;
                }
            } else {
                // Si llega al final de la matriz de trabajo (pero no del reborde) y no encontro cero no es conectada
                if (matJ == mat[0].length-2 && matI == mat.length-2) {
                    ok = false;
                }
                if (matJ == mat[0].length-2) {
                    matJ = 1;
                    matI++;
                } else {
                    matJ++;
                }
            }
        }

        // Recorre la copia de la matriz de trabajo cambiando los ceros vecinos de un -1 por -1
        // Lo hace hasta no encontrar más
        while(cambio && cero && ok) {
            cambio = false;

            for (int i = 1; i < mat.length - 1; i++) {
                for (int j = 1; j < mat[0].length - 1; j++) {
                    if (mat[i][j] == 0 && (mat[i - 1][j] == -1 || mat[i + 1][j] == -1 || mat[i][j - 1] == -1 || mat[i][j + 1] == -1)) {
                        mat[i][j] = -1;
                        cambio = true;
                    }
                }
            }
        }

        // Si encuentra algún cero no es conectada
        for (int i=0;i<mat.length && ok;i++) {
            for (int j=0;j<mat[0].length && ok;j++) {
                if (mat[i][j] == 0) {
                    ok = false;
                }
            }
        }
        
        return ok && cero;
    }
    
    public void generarMolino(int n) {
        int[][] mat = new int[n][n];
        
        for (int i=0;i<mat.length;i++) {
            boolean pCuarto = false;
            boolean sCuarto = false;
            boolean tCuarto = true;
            boolean cCuarto = true;
            
            for (int j=0;j<mat[0].length;j++) {
                if (i < n/2) {
                    if (j < n/2) {
                        if (i == j) {
                            pCuarto = true;
                        }

                        if (pCuarto) {
                            mat[i][j] = 1;
                        } else {
                            mat[i][j] = 0;
                        }
                    } else {
                        if (i + j == n-1) {
                            sCuarto = true;
                        }
                        
                        if (sCuarto) {
                            mat[i][j] = 1;
                        } else {
                            mat[i][j] = 0;
                        }
                    }
                } else {
                    if (j < n/2) {
                        if (i + j == n) {
                            tCuarto = false;
                        }

                        if (tCuarto) {
                            mat[i][j] = 1;
                        } else {
                            mat[i][j] = 0;
                        }
                    } else {
                        if (i < j) {
                            cCuarto = false;
                        }
                        
                        if (cCuarto) {
                            mat[i][j] = 1;
                        } else {
                            mat[i][j] = 0;
                        }
                    }
                }
            }
            
            this.setMatriz(mat);
        }
    }
    
    public String menorComunFilas() {
        String menor = "";
        int min = Integer.MAX_VALUE;
        int[] fila0 = this.getMatriz()[0];
        int[] cont = new int[fila0.length];
        boolean tiene = false;
        
        for (int i=1;i<this.getMatriz().length;i++) {
            for (int j=0;j<this.getMatriz()[0].length;j++) {
                for (int k=0;k<this.getMatriz()[0].length;k++) {
                    if (this.getMatriz()[i][j] == fila0[k] && cont[k] < i) {
                        cont[k]++;
                    }
                }
            }
        }
        
        for (int i=0;i<cont.length;i++) {
            if (cont[i] == this.getMatriz().length-1 && fila0[i] < min) {
                min = fila0[i];
                menor = Integer.toString(min);
                
                if (!tiene) {
                    tiene = true;
                }
            }
        }
        
        if (!tiene) {
            menor = "NO TIENE";
        }
        
        return menor;
    }
    
    public boolean reacomodar(int m, int n) {
        boolean posible = true;
        if (this.getMatriz().length * this.getMatriz()[0].length != m * n) {
            posible = false;
        }
        
        int[][] mat = new int[m][n];
        int matI = 0;
        int matJ = 0;
        
        for (int i=0;i<this.getMatriz().length && posible;i++) {
            for (int j=0;j<this.getMatriz()[0].length;j++) {
                mat[matI][matJ] = this.getMatriz()[i][j];
                
                matJ++;
                if (matJ == n) {
                    matI++;
                    matJ = 0;
                }
            }
        }
        
        if (posible) {
            this.setMatriz(mat);
        }
        return posible;
    }
    
    public boolean tieneFilaIgual() {
        int[][] mat = this.getMatriz();
        boolean tiene = false;
        
        for (int i=0;i<mat.length && !tiene;i++) {
            int iguales = 0;
            for (int j=1;j<mat[0].length-1 && !tiene;j++) {
                if (mat[i][j] == mat[i][j-1] && mat[i][j] == mat[i][j+1]) {
                    iguales++;
                }
            }
            if (iguales == mat[0].length-2) {
                tiene = true;
            }
        }
        
        return tiene;
    }
}