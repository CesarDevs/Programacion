graph_1 = {'A':['B','D','E','G'],
         'B':['C','H','F'],
         'C':['D','H'],
         'D':['A','E','H'],
         'E':['A','F','G'],
         'F':['B','G',],
         'G':['C','E''H'],
         'H':['D','G']
         }

#use del to delete the variable
#variableName.clear() to clear the data

#print(graph['A'])
#print(len(graph))
#print(str(graph_1))
#print('T' in graph)

def find_path_depth(graph, start, end, path=[]):
    path = path + [start]
    if(start == end):   #si es el mismo
        return path
    if not start in graph:  #si se escribe algo que no esté
        return None
    if not end in graph:     #si el final no está
        return None
    for node in graph[start]:   #'node' toma el valor de la lista en la llave
        if node not in path:    #que no se haya visitado
            newpath = find_path_depth(graph,node,end,path)    #se vuelve a empezar desde el primer nodo encontrado
            if newpath: #evita bucles inecesarios
                return newpath
    return None

def find_shortest_path(graph, start, end, path=[]):
    path = path + [start]
    if (start == end):
        return path
    if not start in graph:
        return None
    if not end in graph:
        return None
    shortest = None
    for node in graph[start]:
        if node not in path:
            newpath = find_shortest_path(graph, node, end, path)
            if newpath:
                if not shortest or len(newpath) < len(shortest):
                    shortest = newpath
    return shortest

something = find_path_depth(graph_1,'A','H')
print(something)
var = find_shortest_path(graph_1, 'A', 'H')
print(var)
