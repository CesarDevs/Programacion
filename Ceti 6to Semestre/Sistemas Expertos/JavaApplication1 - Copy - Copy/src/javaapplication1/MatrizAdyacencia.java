package javaapplication1;





import java.util.InputMismatchException;
import java.util.Scanner;
import javaapplication1.Busquedas;
import javaapplication1.CreacionMatriz;


public class MatrizAdyacencia {
    
    private static String nodoDestino = null;
    private static CreacionMatriz obj = null;
    private static Busquedas busqueda;

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
}
