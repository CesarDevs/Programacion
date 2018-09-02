#Este sera un programa de grafos

from Class import *

Grafo=Grafo()
# Grafo.agregarVertice(input('Agrege el nombre del vertice: '))
Grafo.mostrarGrafo()

while(True):
    #Menu
    imprimirMenu()
    x = int(input('Seleecione una opccion del menu: '))
    
    #Agregar Vertice
    if(x==1):
        Grafo.agregarVertice(input('Agrege el nombre del vertice: '))
        Grafo.mostrarGrafo()
        pass
    #Agregar Arista
    elif (x==2):
        primaryKey=input('Intruduzca el nombre del Vertice: ')
        arista=input('Introduzca el nombre de la Arista: ')
        Grafo.agregarArista(primaryKey, arista)
        Grafo.mostrarGrafo()
        pass
    #Agregar Diccionario predefinido

    elif (x==3):
        Grafo.agregarDiccinario()
        pass

    #Busqueda anchura
    elif (x==4):
        Desde=input('Donde se inicia la busqueda: ')
        Hasta=input('A donde se desea llegar: ')

        R=Grafo.BusquedaAnchura(Desde,Hasta)

        print('-------------El recorrido del grafo fue:------------- ')
        print(R)

        pass

    #Busqueda profundidad
    elif (x==5):
        Desde=input('Donde se inicia la busqueda: ')
        Hasta=input('A donde se desea llegar: ')
        R=Grafo.BusquedaProfundidad(Desde,Hasta)
        print('-------------El recorrido del grafo fue:------------- ')
        print(R)
        pass

    #Busqueda profundidad iterativa
    elif (x==6):
        Desde=input('Donde se inicia la busqueda: ')
        Hasta=input('A donde se desea llegar: ')
        Nivel=input('Hasta que nivel: ')
        pass

    #Mostrar Diccionario
    elif (x==7):
        Grafo.mostrarGrafo()
        pass

    elif (x==8):
        Grafo.mostrarGrafo()
        Grafo.navegarEnGrafo(input('Escribe el nodo en el que quieres comenzar: '))
    
    




    