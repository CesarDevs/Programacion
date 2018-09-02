package javaapplication1;




import java.util.Scanner;

public class CreacionMatriz {
    private int[][] matriz;
    private String[] nombresNodos;
    
    public CreacionMatriz(int totalNodos, String[] nombresNodos) {
        matriz = new int [totalNodos][totalNodos];
        
        for (int[] matriz1 : this.matriz) {
            for (int j = 0; j < matriz1.length; j++) {
                matriz1[j] = 0;
            }
        }
        
        this.nombresNodos = nombresNodos;
    }
    
    public void impMatriz() {
        System.out.println("La matriz es: ");
        System.out.print("  ");
        
        for (String nombresNodo : nombresNodos) {
            System.out.print(nombresNodo + " ");
        }
        
        System.out.println("");
        
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(nombresNodos[i] + " ");
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public void adyacenciaMatriz(){

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Indique las adyacencias de " + nombresNodos[i] + ": ");
            String[] adyacencias = MatrizAdyacencia.leerTeclado().split(",");
            for (int j = 0; j < adyacencias.length; j++) {
                String nodoAdyacente = adyacencias[j];
                int posicion = -1;
                for (int k = 0; k < nombresNodos.length; k++) {
                    if (nombresNodos[k].equals(nodoAdyacente)) {
                        posicion = k;
                        break;
                    }
                }
                if (posicion == -1) {
                    System.out.println("El nodo " + "\"" + nodoAdyacente + "\"" + " no existe.");
                } else {
                    this.matriz[i][posicion] ++;
                }
            }
        }
    }
    
     public int[][] getMatrizAdyacencia() {
        return this.matriz; 
    }

    public String[] getNombresNodos() {
        return this.nombresNodos;
    }
   
}
