import networkx as nx
import matplotlib.pyplot as plt
import math

G  = nx.Graph()
# M=["A", "B","C"]
# G.add_nodes_from(M)
# G.add_node(1, time='5pm', x=0, y=1)
# G.add_nodes_from([3], time='2pm')
# G.nodes[1]
# G.add_edge("A", "B")
# G.add_edge("A", "C")
# G.add_edge(1, "C")
# G.add_edge("B", 3)
# G.add_edge(3, "A")


G.add_node("E2", x=6, y=3)
G.add_node("E1", x=2, y=2)
G.add_node("J", x=5, y=7)
G.add_node("F", x=8, y=10)
G.add_node("CANCHA", x=11, y=4)
G.add_node("I", x=2, y=17)
G.add_node("H", x=4, y=12)
G.add_node("G", x=6, y=12)
G.add_node("E", x=6, y=17)
G.add_node("B", x=14, y=10)
G.add_node("D", x=13, y=16)
G.add_node("R", x=13, y=4)
G.add_node("K", x=8, y=19)
G.add_node("EST", x=17, y=12)
G.add_node("A", x=17, y=8)
G.add_node("C", x=11, y=8)
G.add_node("L", x=11, y=20)
G.add_node("O", x=14, y=19)
G.add_node("P", x=6, y=17)
G.add_node("E3", x=8, y=3)



G.add_edge("E2", "E1")
G.add_edge("E2", "J")
G.add_edge("E2", "F")
G.add_edge("E2", "CANCHA")
G.add_edge("E1", "J")
G.add_edge("E1", "I")
G.add_edge("J", "F")
G.add_edge("J", "H")
G.add_edge("J", "G")


G.add_edge("F", "G")
G.add_edge("F", "E")
G.add_edge("F", "B")
G.add_edge("F", "D")

G.add_edge("CANCHA", "R")
G.add_edge("I", "H")
G.add_edge("I", "E")
G.add_edge("G", "E")

G.add_edge("E", "K")

G.add_edge("B", "D")
G.add_edge("B", "R")
G.add_edge("B", "EST")
G.add_edge("B", "A")
G.add_edge("B", "C")

G.add_edge("D", "EST")
G.add_edge("D", "L")
G.add_edge("D", "O")
G.add_edge("D", "P")
G.add_edge("R", "E3")

G.add_edge("K", "L")
G.add_edge("EST", "A")
G.add_edge("EST", "P")
G.add_edge("A", "E3")

G.add_edge("L", "O")
G.add_edge("O", "P")









nodos=G.nodes
print("Los nodos son:")
print(nodos)
x=nx.get_node_attributes(G,"x")
print("Los atributos en x son:")
print(x)
y=nx.get_node_attributes(G,"y")
print("Los atributos en y son:")
print(y)
plt.subplot(122)
nx.draw(G, with_labels=True, font_weight='bold')
plt.show()



################Funcioneas

def BusquedaPrimeroMejor(NodoStart, NodoEnd):
    print("NODOS VISITADOS")
    print(visitados)
    nodoActual=NodoStart

    if(len(cola)>0):
        cola.pop(0)
    #Se agrega el nodo actual a la lista de visitados
    visitados.append(NodoStart)
    print("Nodo actual :" )
    print(NodoStart)
    #Se reviza si es el nodo
    if(NodoStart==NodoEnd):
        print("Se encontro el nodo buscado, el camino fue el sigueinte:")
        print(visitados)
        print("Los atributos son:")
        MostrarCaminos(NodoEnd)
        return True
    #Obtener nodos adyacentes al nodo actual
    vecinos = list(nx.all_neighbors(G,str(NodoStart)))
    print(vecinos)
    
    #Se obtiene el nodo mas cercano que no se haya visitado
    NodoCercano = NodoMasCercano(nodoActual, NodoEnd, vecinos)

    if(NodoCercano==False):
        print("NO SE ENCONTRO EL NODO")
        print(visitados)
        print("Los atributos son:")
        MostrarCaminos(NodoEnd)
        return False
    BusquedaPrimeroMejor(NodoCercano, NodoEnd)
    

def MostrarCaminos(NodoEnd):
    nodos=list(nx.nodes(G))
    # print(nodos)
    for i in enumerate(nodos):
        print("Distancia entre "+ str(nodos[i[0]])+" y " +str(NodoEnd)+": ")
        print(Distancia2Puntos(nodos[i[0]],NodoEnd))



def NodoMasCercano(Nodo, NodoEnd, vecinos):
    nodosOrdenados=vecinos
    for numPasada in range(len(nodosOrdenados)-1,0,-1):
        for i in range(numPasada):
            if (Distancia2Puntos( nodosOrdenados[i], NodoEnd)>Distancia2Puntos(nodosOrdenados[i+1],NodoEnd)):
                temp = nodosOrdenados[i]
                nodosOrdenados[i] = nodosOrdenados[i+1]
                nodosOrdenados[i+1] = temp
    while(nodosOrdenados):
        if(nodosOrdenados[0] in visitados):
            nodosOrdenados.pop(0)
        else:
            return nodosOrdenados[0]
    return False


    pass


def ordenamientoBurbuja(Nodo, NodoEnd, vecinos):
    nodosOrdenados=[]
    nodosOrdenados=vecinos
    for numPasada in range(len(nodosOrdenados)-1,0,-1):
        for i in range(numPasada):
            if (Distancia2Puntos( nodosOrdenados[i], NodoEnd)>Distancia2Puntos(nodosOrdenados[i+1],NodoEnd)):
                temp = nodosOrdenados[i]
                nodosOrdenados[i] = nodosOrdenados[i+1]
                nodosOrdenados[i+1] = temp
    return nodosOrdenados


def Distancia2Puntos(nodoA, nodoB):
    return float(math.sqrt( ((int(x[nodoB])-int(x[nodoA]))**2) + ((int(y[nodoB])-int(y[nodoA]))**2) ))
        



#################MAIN

Salir=1
while(Salir==1):
    visitados=[]
    cola=[]
    BusquedaPrimeroMejor(str(input("Nodo a Comenzar: ")), str(input("Nodo a buscar: ")))
    pass


# print(time[3])



