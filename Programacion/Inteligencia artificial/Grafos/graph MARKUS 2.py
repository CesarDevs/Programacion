graph_1 = {'E1':['I','J','H'],
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

something = find_path_depth(graph_1,'E1','P')
print(something)
var = find_shortest_path(graph_1, 'E1', 'P')
print(var)
