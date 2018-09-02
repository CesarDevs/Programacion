package javaapplication1;





import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
import javaapplication1.Busquedas;
import javaapplication1.CreacionMatriz;



public class MatrizAdyacencia {
    
    private static String nodoDestino = null;
    private static CreacionMatriz obj = null;
    private static Busquedas busqueda;
    private int[][] matriz;
    private String[] nombresNodos;
    private CreacionMatriz grafo;
    private int[][] MatrizAdyacencia;
    //private String[] nombresNodos;
    private Stack<String> nodosVisitados;
    private boolean nodoEncontrado;

    public static void main(String[] args) {
        String[] nombreNodos = null;
        int totalNodos = 0;
        int menu = 0;
                
        do {
            System.out.println(" --- Busquedas en Grafo ---"
                    + "\n [1] Registro de Nodos"
                    + "\n [2] Búsqueda 'Camino más Corto'"
                    + "\n [3] Búsqueda 'Anchura'"
                    + "\n [4] Búsqueda 'Profundidad'"
                    + "\n [5] Salir");
            System.out.print("Seleccione la opción deseada: ");
            menu = Integer.parseInt(leerTeclado());
            
            switch(menu){
                case 1:
                    System.out.print("Indique el nombre de los nodos: ");
                    nombreNodos = leerTeclado().split(",");
                    totalNodos = nombreNodos.length;
                    obj = new CreacionMatriz(totalNodos, nombreNodos);
                    obj.impMatriz(); //Se imprime la matriz inicializada
                    obj.adyacenciaMatriz(); //Se generan las adyacencias
                    obj.impMatriz(); //Se reimprime la matriz con las adyacencias
                    break;
                case 2:
                    busquedaCorto();
                    break;
                case 3:
                    if(obj == null){
                        System.out.println("Registre primero los nodos");
                    } else {
                    System.out.print("Indique el nodo que desea buscar: ");
                    nodoDestino = leerTeclado().trim();
                    busqueda = new Busquedas(obj);
                    busqueda.amplitud(0, nodoDestino);
                    }
                    break;
                case 4:
                    if(obj == null){
                        System.out.println("Registre primero los nodos");
                    } else {
                        System.out.print("Indique el nodo que desea buscar: ");
                        nodoDestino = leerTeclado().trim();
                        busqueda = new Busquedas(obj);
                        busqueda.profundidad(0, nodoDestino);
                    }
                    break;
                default:
                    System.out.println("Cerrando programa...");
            }
        } while (menu != 5);
    }
    
    public static String leerTeclado() {
        try {
            Scanner scn = new Scanner(System.in);
            return scn.nextLine();
        } catch(InputMismatchException ex){
            System.out.println(ex.getMessage() + "No es número valido.");
        } 
        return null;
    }
    
    public static void busquedaCorto(){
        if(obj == null){
            System.out.println("Registre primero los nodos");
        } else {
            busqueda = new Busquedas(obj);
            System.out.print("Capture el nodo destino: ");
            String nodoDestino = leerTeclado().trim();
            
            int posIniBusqueda = 0;
            busqueda.corto(0, nodoDestino,posIniBusqueda);
            Object[] nodosVisitados = busqueda.getNodosVisitados().toArray();
            
            if(busqueda.getNodoEncontrado()){
                System.out.println("Ruta más corta encontrada");
                System.out.print(obj.getNombresNodos()[0]);
                for(int i = 0; i<nodosVisitados.length; i++){
                    System.out.print("->" + nodosVisitados[i].toString());
                }
                System.out.println();
            } else {
                System.out.println("El nodo no fué encontrado");
            }
            
        }
    }
  
    
    public void CreacionMatriz(int totalNodos, String[] nombresNodos) {
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
            String[] adyacencias = leerTeclado().split(",");
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
    
    
    public void Busquedas(CreacionMatriz grafo){
        this.grafo = grafo;
        this.MatrizAdyacencia = grafo.getMatrizAdyacencia();
        this.nombresNodos = grafo.getNombresNodos();
        this.nodosVisitados = new Stack<>();
        this.nodoEncontrado = false;
    }
    
    public void limpiarPila(){
        this.nodosVisitados.clear();
    }
    
    //Busqueda por profundidad
    public void profundidad(int posNodo, String nodoBuscar){
        int[] nodosHijos = this.MatrizAdyacencia[posNodo];
        
        for (int i = 0; i < nodosHijos.length; i++) {
            if (nodosHijos[i] != 0 && nodosVisitados.indexOf(nombresNodos[i]) < 0) {
                this.nodosVisitados.push(nombresNodos[i]);
                
                if (nombresNodos[i].equals(nodoBuscar)) {
                    System.out.println("Nodo '" + nodoBuscar + "' encontrado en '" + nombresNodos[posNodo] + "'");
                    return;
                } else {
                    profundidad(i, nodoBuscar);
                }
            }
        }
    }
    
    //Busqueda por amplitud
    public void amplitud(int posNodo, String nodoBuscar){
        int[] nodosHijos = this.MatrizAdyacencia[posNodo];
        
        for (int i = 0; i < nodosHijos.length; i++) {
            if (nombresNodos[i].equals(nodoBuscar) && nodosHijos[i] > 0) {
                    System.out.println("Nodo '" + nodoBuscar + "' encontrado en '" + nombresNodos[posNodo] + "'");
                    return;
                }
        }
        
        for (int i = 0; i < nodosHijos.length; i++) {
            if (nodosHijos[i] != 0 && nodosVisitados.indexOf(nombresNodos[i]) < 0) {
                this.nodosVisitados.push(nombresNodos[i]);    
                profundidad(i, nodoBuscar);
            }
        }
    }
    
    //Busqueda más corto
    public void corto(int posNodo, String nodoBuscar, Integer dist){
        nodosVisitados.push(nombresNodos[posNodo]);
        //Obtenemos la matriz de adyacencia
        int[] nodosHijos = this.MatrizAdyacencia[posNodo];
        for(int i = 0; i< nodosHijos.length; i++){
            if(nombresNodos[i].equals(nodoBuscar) && nodosHijos[i] > 0){
                nodosVisitados.push(nombresNodos[posNodo]);
                System.out.println("Nodo '" + nodoBuscar + "' encontrado en el padre '" + nombresNodos[posNodo] + "'");
                nodoEncontrado = true;
                return;
            }
        }
        
        //Hasta aquí todo es lo mismo que anchura/amplitud
        //Se incrementa en uno la distancia actual y se declara la distancia anterior (pivote)
        Integer distanciaActual = dist + 1;
        Integer distanciaAnterior = 0;
        
        //Se recorren los hijos del nodo
        for(int i = 0; i<nodosHijos.length; i++){
            if(nodosHijos[i] > 0 && nodosVisitados.indexOf(nombresNodos[i]) < 0 ){
                System.out.println("Visitando " + nombresNodos[i] + " en el padre " + nombresNodos[posNodo]);
                
                //Esto es lo que cambia, se clona la distancia actual y se vuelve anterior
                distanciaAnterior = Integer.parseInt(String.valueOf(distanciaActual));
                
                //luego con recursividad se pasa la referencia de la distancia actual que será incrementada en la 
                //línea 83
                corto(i,nodoBuscar,distanciaActual);
                
                //Comparamos la distancia anterior con la que se obtuvo recursivamente
                //Si la distancia anterior es mayor a la que se calculó quiere decir que se encontró
                //una ruta más óptima hacia el nodo destino
                if(distanciaAnterior > dist){
                    //Se limpian los nodos que habíamos visitado
                    //debido a que puede darse el caso de que exista otra
                    //ruta más corta sobre un nodo previamente visitado.
                    nodosVisitados.clear();
                    //Se agrega el nombre del nodo actual
                    nodosVisitados.push(nombresNodos[i]);
                    //se agrega el nombre del nodo destino
                    nodosVisitados.push(nodoBuscar);
                } else {
                    dist = distanciaAnterior;
                }
            }
        }
        dist = distanciaActual;
        
    }
    
    public Stack<String> getNodosVisitados() {
        return this.nodosVisitados;
    }
    
    public boolean getNodoEncontrado (){
        return this.nodoEncontrado;
    }
}
