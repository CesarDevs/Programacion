package javaapplication1;



import java.util.Stack;

public class Busquedas {

    private CreacionMatriz grafo;
    private int[][] MatrizAdyacencia;
    private String[] nombresNodos;
    private Stack<String> nodosVisitados;
    private boolean nodoEncontrado;
    
    public Busquedas(CreacionMatriz grafo){
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
