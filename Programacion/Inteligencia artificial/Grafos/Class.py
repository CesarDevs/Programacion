import sys
sys.setrecursionlimit(1000000000)
newpath=[]
class Grafo:
    def __init__(self):
        self.diccionario={}
        ######El grafo ira dentro de un arreglo de arreglos  de la siguiente manera [["Nombre del vertice"], {arista 1, arista 2}],[]]
        # SEGUN LA PAGINA DE PYTHON ES MEJOR HACERLO CON DICCIONARIOS COMO {A:[B,C,D], B:[C,D]}
        # Por ende usare diccionarios
        print("Se Agregro un grafo vacio")
        
        
    def agregarVertice(self, nombreNodo):
        try:
            self.diccionario[str(nombreNodo)] = []
            print("Se agrego el vertice correctamente")
            return(True)
        except:
            print("Error al agregar vertice")
            return(False)
    

        
        # self.diccionario[nombreNodo] = []
        # print("Se agrego el vertice correctamente")
            
        

    def mostrarGrafo(self):
        return(print(self.diccionario))

    def agregarArista(self, primaryKey, arista):
        #Contiene el arreglo de aristas y si no existe regresa un arreglo vacio
        arregloAristas = self.diccionario.get(primaryKey, False)
        
        # Si existe el Vertice  
        print(arregloAristas)
        if(arregloAristas is not  False):
            #Si la Arista es un Vertice existente
            if(str(arista) in self.diccionario.keys() and not(str(primaryKey) in self.diccionario[arista]) and not(str(arista) in self.diccionario[primaryKey])):
                #Agrega  el vertice  al arreglo
                arregloAristas.append(arista)
                arregloVertice = self.diccionario.get(arista,False)
                arregloVertice.append(primaryKey)
            else:
                #Si no
                print('Las aristas solo pueden tener el nombre de Vertices existentes')
                return False

            #Actializa el diccionario
            self.diccionario[str(primaryKey)]=arregloAristas
            print('Arista Agregada Correctamente')
            return True
        else:
            print('No se encontro Vertice')
            return False

    def agregarDiccinario(self):
        #En esta funcion se agregara el diccionario que este en la variable Diccionario
        Diccionario={'E1':['I','J','H'],
                    'E2':['J','F'], 
                    'E3':['A','R'],
                    'J':['E1','E2','G','H','I','F'], 
                    'F':['R','C','B','D','G','J','E2'], 
                    'G':['E','F','J'],'H':['E','I','E1','J'], 
                    'I':['E','H','J','E1'], 'R':['B', 'C','F','E3'], 
                    'C':['B','R','F'], 'B':['D','A','F','C','R'], 
                    'E':['K','G','H','I'], 'K':['L','D','E'], 
                    'L':['O','D','K'], 
                    'O':['P','D','L'], 'P':['O','D','A'], 
                    'A':['D','P','B','E3'],
                    'D':['O','P','A','B','F','K','L'] }
        self.diccionario={}
        print('Se elimino el diccionario anterior')
        self.diccionario=Diccionario
        print('Se agrego con exito!!')    
        print(self.diccionario)

    
    def BusquedaAnchura(self,Desde,Hasta):
        #Revizar que los nodos existan
        if(str(Desde) in self.diccionario.keys() and str(Hasta) in self.diccionario.keys() ):
            #Se agregaran una lista llamada cola, que seran los proximos nodos a visitar
            cola = []
            #Se agregara otra lista llamada visitados, guardara los nodos que se vayan visitando
            visitados = []
            visitados.append(Desde)
            nodoActual=Desde
            f=True
            while f:
                
                if nodoActual==Hasta:
                    f=False
                    visitados.append(cola[0])
                    return visitados             
                # print(visitados)

                if cola:
                    if  cola[0] not in visitados:
                        visitados.append(cola[0])
                    cola.pop(0)
                    #print('si entro al if')   
                #se agregan losaristas del nodo actual a la cola
                #print(nodoActual)

                #cola=cola+self.diccionario[nodoActual]
                # cont=0
                # for x in self.diccionario[nodoActual]:
                #     if self.diccionario[nodoActual][cont] is not visitados and self.diccionario[nodoActual][cont] is not visitados:
                #         cola.append(self.diccionario[nodoActual][cont])
                #     cont=cont+1
                #     pass
                cont=0
                aristasNodoactual=self.diccionario[nodoActual]
                for i in range(0,len(aristasNodoactual)):
                    if(aristasNodoactual[cont] not in visitados and aristasNodoactual[cont] not in cola):
                        cola.append(aristasNodoactual[cont])
                    cont=cont+1
                    pass
                nodoActual=cola[0]
                print('Visitados')
                print(visitados)  
                print('Cola')
                print(cola)   
            pass

        else:
            return print('Uno o ambos de los nodos elegidos no existe') 
        
    def BusquedaProfundidad(self, Desde,Hasta):
        #Revizar que los nodos existan
        if(str(Desde) in self.diccionario.keys() and str(Hasta) in self.diccionario.keys() ):
            #Se agregaran una lista llamada cola, que seran los proximos nodos a visitar
            cola = []
            #Se agregara otra lista llamada visitados, guardara los nodos que se vayan visitando
            visitados = []
            visitados.append(Desde)
            nodoActual=Desde
            f=True
            while f:
                if nodoActual==Hasta:
                    f=False
                    visitados.append(cola[0])
                    return visitados
              

                if cola:
                    if cola[0] not in visitados:
                        visitados.append(cola[0])
                    cola.pop(0)
                aristasNodoactual=self.diccionario[nodoActual]

                cont = 0

                for i in range(0, len(aristasNodoactual)):
                    if(aristasNodoactual[cont] not in visitados and aristasNodoactual[cont] not in cola):
                        temp=[]
                        temp.append(aristasNodoactual[cont])
                        cola= temp+cola
                    cont=cont+1
                    
                nodoActual=cola[0]
                print('Visitados')
                print(visitados)  
                print('Cola')
                print(cola)


                
            pass

        else:
            return print('Uno o ambos de los nodos elegidos no existe')

    def navegarEnGrafo(self, nodo):
        visitados=[]
        salir=True
        if(nodo not in self.diccionario.keys()):
            print('Este vertice no existe en este nodo: ')
            return False
        else:
            visitados.append(nodo)
        while(salir):
            print('nodo actual: ')
            print(nodo)
            print('Vertices del nodo actual: ')
            print(self.diccionario[nodo])
            x=input('Elige la Vertice que queires entrar: ')
            if(x in self.diccionario.get(nodo,False) and salir):
                nodo=x
                visitados.append(nodo)
                # print(visitados)

            elif(x=='Regresar'):
                visitados.pop(int(len(visitados))-1)
                nodo=visitados[int(len(visitados))-1]
                
                

                
            elif(x=='Salir' or x=='Exit'):
                salir=False

            else:
                print('El vertice no existe')




    


         



       


def imprimirMenu():
    print('1) Agregar vertice')
    print('2) Agregar arista')
    print('3) Agregar diccionario')
    print('4) Busqueda de anchura')
    print('5) Busqueda de profundidad')
    print('6) Busqueda de profundidad iterativa')
    print('7) Mostrar Grafo Actual')
    print('8) Navegar en Grafo')


        

        

            


        
 

