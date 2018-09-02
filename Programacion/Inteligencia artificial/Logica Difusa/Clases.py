
class Grafica:
	def __init__(self, nFiguras, Nombre):
		self.nFiguras=nFiguras
		self.Nombre = str(Nombre)
		#Declarar primerafigura
		self.Figura1 = Figura(PedirNPuntos("Figura 1 "), input('introduce nombre de la figura 1: '), 0)
		#Se crea la otra figura if si
		if(nFiguras>=2):
		    #Se crea la  segunda figura
			self.Figura2 = Figura(PedirNPuntos("Figura 2 "),input('introduce nombre de la figura 2: '),1)
			#Se crea la  segunda figura

		#Se crea otra figura si 
		if(nFiguras>=3):
			#Se crea la  segunda figura
			self.Figura3 = Figura(PedirNPuntos("Figura 3 "), input('introduce nombre de la figura 3: '),2)
		pass
	
	def evaluarFiguras(self, x):
		ArregloResultados=[]
		
		#si X esta en la figura 1
		if(x>=self.Figura1.LimiteInf and x<=self.Figura1.LimiteSup):
		#Evaluar en la figura 1
			ArregloResultados.append(self.Figura1.evaluarLineas(x))
		if(self.nFiguras>=2):
			if(x>=self.Figura2.LimiteInf and x<=self.Figura2.LimiteSup):
				#Evaluar la figura 2
				ArregloResultados.append(self.Figura2.evaluarLineas(x))
		if(self.nFiguras>=3):
			if(x>=self.Figura3.LimiteInf and x<=self.Figura3.LimiteSup):
				#Evaluar la figuta 3
				ArregloResultados.append(self.Figura3.evaluarLineas(x))

		return ArregloResultados

	def BuscarFiguraNombre(self, y, Nombre):
		if(self.Figura1.Nombre==Nombre):
			return self.Figura1.evaluarLineasY(y)
		if(self.nFiguras>=2):
			if(self.Figura2.Nombre==Nombre):
				return self.Figura2.evaluarLineasY(y)
		if(self.nFiguras>=3):
			if(self.Figura3.Nombre==Nombre):
				return self.Figura3.evaluarLineasY(y)

		print("ERROR BIEN PASADOTE DE VERGA")



class Figura:
	def __init__(self, nPuntos, Nombre, Id):
		self.Id=Id

		self.nPuntos=nPuntos
		self.Nombre= str(Nombre)
		self.Puntos1 = Puntos (float(PedirPuntos("x1")),float(PedirPuntos("y1")))
		self.Puntos2 = Puntos (float(PedirPuntos("x2")),float(PedirPuntos("y2")))
		self.Puntos3 = Puntos (float(PedirPuntos("x3")),float(PedirPuntos("y3")))
		if(nPuntos>=4):
			self.Puntos4 = Puntos (PedirPuntos("x4"),PedirPuntos("y4"))
		self.LimiteInf = self.Puntos1.x
		if(nPuntos>=4):
			self.LimiteSup = self.Puntos4.x
		else:
			self.LimiteSup = self.Puntos3.x
		##########################TEST############################
		#print("el limite inferior en x es: "+str(self.LimiteInf))
		#print("El limite superior en x es: "+str(self.LimiteSup))
		##########################################################

		#Inicializar las Lineas

		self.Linea1 =  Linea(self.Puntos1,self.Puntos2)
		self.Linea2 = Linea(self.Puntos2,self.Puntos3)
		if(nPuntos>=4):
			self.Linea3 = Linea(self.Puntos3, self.Puntos4) 

	def evaluarLineas(self,x):
		#Evaluar en que recta esta
		#print(x , self.Puntos1.x, self.Puntos2.x, self.Puntos3.x, self.Puntos4.x)
		if(x>=self.Puntos1.x and x<=self.Puntos2.x):
			return [self.Nombre ,self.Linea1.EvaluarRectaX(x),self.Id]
			
		elif(x>=self.Puntos2.x and x<=self.Puntos3.x):
			return [self.Nombre ,self.Linea2.EvaluarRectaX(x),self.Id]
			
		elif(self.nPuntos>=4):
			if(x>=self.Puntos3.x and x<=self.Puntos4.x):
				return [self.Nombre ,self.Linea3.EvaluarRectaX(x),self.Id]


	def evaluarLineasY(self,y):
		#Evaluar en que recta esta
		#print(x , self.Puntos1.x, self.Puntos2.x, self.Puntos3.x, self.Puntos4.x)

		if(self.nPuntos>=4):
			return self.Linea3.EvaluarRectaY(y)

		return self.Linea2.EvaluarRectaY(y)
			
		if(y>=self.Puntos1.y and y<=self.Puntos2.y):
			return self.Linea1.EvaluarRectaY(y)
			
		print('	NO SE ENCONTRO PERTENENCIA')
				

class Linea:

	def __init__(self, Pi , Pf):
		self.m=float(self.Calcularm(Pi.y,Pf.y,Pi.x,Pf.x))
		self.b=float(self.Calcularb(self.m, Pi.y, Pi.x))



	#hacer una funcion para evaluar las ecuaciones de la recta
	#Recibe 2 puntos y el valor de X
	def Calcularm(self, y1, y2, x1, x2):
		return float((y2-y1)/(x2-x1))

	def Calcularb(self,m,y1, x1):

		return float(y1-(m*x1))

	def EvaluarRectaX(self,x):
		y=(self.m*x)+self.b
		##########################TEST############################
		#print(y)
		##########################################################
		return round(float(y),2)
	def EvaluarRectaY(self,y):
		x= float((y-self.b)/self.m)
		##########################TEST############################
		#print(y)
		##########################################################
		return float(x)



class Puntos:
	def __init__(self, x, y):
		self.x = x 
		self.y = y



def PedirPuntos(nombre):
	return float(input('Entra el punto '+ nombre+":"))


def PedirNPuntos(nombre):
	return int(input('Entra el numero de puntos '+ nombre+':'))




def Menu():
	

	print('1 - Crear Objetos')
	

	x=int(input('Elige una opcion:'))
	if(x==1):
		#Se crean 2 graficas representando la variable
		var1=str(input('Agrega el nombre de la variable 1: '))
		nfig1=int(input('Numero de figuras de la variable 1 (min 1 - max 3) :  '))
		Grafica1=Grafica(nfig1, var1)
		var2=str(input('Agrega el nombre de la variable 2: '))
		nfig2=int(input('Numero de figuras de la variable 2 (min 1 - max 3) : '))
		Grafica2=Grafica(nfig2, var2) var2

		#cREAR LA GRAFICA DE RESOLUCION
		varR=str(input('Agrega el nombre de la variable 1: '))
		nfigR=int(input('Numero de figuras de la variable 1 (min 1 - max 3) :  '))
		GraficaR=Grafica(nfigR, varR)

		def evaluarRespuesta(GraficaR,x):
			if(x==1):
				return GraficaR.Figura1.Nombre
			elif(x==2):
				return GraficaR.Figura2.Nombre
			elif(x==3):
				return GraficaR.Figura3.Nombre
		#Crear El Objeto matriz de resolucion
		matriz = [],[],[]

		print("*******A continuacion crea la tabla de resolucion*******")
		print("1.-"+GraficaR.Figura1.Nombre)
		if(GraficaR.nFiguras>=2):
			print("2.-"+GraficaR.Figura2.Nombre)
			if(GraficaR.nFiguras>=3):
				print("3.-"+GraficaR.Figura3.Nombre)
		print("NOTA: NO INTENTE INGRESAR OTROS VALORES POR QUE DEJARA INSERVIBLE LA LOGICA")
		matriz[0].append(str(evaluarRespuesta(GraficaR,int(input(str(Grafica1.Figura1.Nombre)+ " and " +str(Grafica2.Figura1.Nombre +" = :"))))))
		if(Grafica2.nFiguras>=2):
			matriz[0].append(str(evaluarRespuesta(GraficaR,int(input(str(Grafica1.Figura1.Nombre)+ " and " +str(Grafica2.Figura2.Nombre +" = :"))))))
			if(Grafica2.nFiguras>=3):
				matriz[0].append(str(evaluarRespuesta(GraficaR,int(input(str(Grafica1.Figura1.Nombre)+ " and " +str(Grafica2.Figura3.Nombre +" = :"))))))

		if(Grafica1.nFiguras>=2):
			matriz[1].append(str(evaluarRespuesta(GraficaR,int(input(str(Grafica1.Figura2.Nombre)+ " and " +str(Grafica2.Figura1.Nombre +" = :"))))))
			if(Grafica2.nFiguras>=2):
				matriz[1].append(str(evaluarRespuesta(GraficaR,int(input(str(Grafica1.Figura2.Nombre)+ " and " +str(Grafica2.Figura2.Nombre +" = :"))))))
				if(Grafica2.nFiguras>=3):
					matriz[1].append(str(evaluarRespuesta(GraficaR,int(input(str(Grafica1.Figura2.Nombre)+ " and " +str(Grafica2.Figura3.Nombre +" = :"))))))

		if(Grafica1.nFiguras>=3):
			matriz[2].append(str(evaluarRespuesta(GraficaR,int(input(str(Grafica1.Figura3.Nombre)+ " and " +str(Grafica2.Figura1.Nombre +" = :"))))))
			if(Grafica2.nFiguras>=2):
				matriz[2].append(str(evaluarRespuesta(GraficaR,int(input(str(Grafica1.Figura3.Nombre)+ " and " +str(Grafica2.Figura2.Nombre +" = :"))))))
				if(Grafica2.nFiguras>=3):
					matriz[2].append(str(evaluarRespuesta(GraficaR,int(input(str(Grafica1.Figura3.Nombre)+ " and " +str(Grafica2.Figura3.Nombre +" = :"))))))


		print(matriz)




		while(True):
			x1= float(input('ingresa un valor para '+str(Grafica1.Nombre)+': '))

			RVar1=Grafica1.evaluarFiguras(float(x1))
			print(RVar1)
			x2= float(input('ingresa un valor para '+str(Grafica2.Nombre)+': '))
			RVar2=Grafica2.evaluarFiguras(float(x2))
			print(RVar2)

			#SOLO REDONDEA A LA DERECHA

			if(len(RVar1)>1):
				#RVar1= RVar1.pop(0) if (RVar1[0] [1]>RVar1[1] [1]) else RVar1.pop(1)

				if((RVar1[0] [1]>RVar1[1] [1])):
					RR1=RVar1[0]
				else:
					RR1=RVar1[1]
			else:
				RR1=RVar1[0]

			print(RR1)
			if(len(RVar2)>1):
				#RVar2= RVar2.pop(0) if (RVar2[0] [1]>RVar2[1] [1]) else RVar2.pop(1)

				if((RVar2[0] [1]>RVar2[1] [1])):
					RR2=RVar2[0]
				else:
					RR2=RVar2[1]
			else:
				RR2=RVar2[0]

			print(RR2)

			print('*****RESULTADOS REALES*****')
			print(Grafica1.Nombre +" en "+str(x1)+ " es " + str(RR1[0])+' '+str(RR1[1]*100)+'%')
			print(Grafica2.Nombre +" en "+str(x2)+ " es " + str(RR2[0])+' '+str(RR2[1]*100)+'%')
			
			##SE EVALUA LOS RESULTADOS##
			NombrefigR=str(matriz[int(RR1[2])][int(RR2[2])])
			

			##Buscar la figura con el nombre de NombrefigR

			y=RR1[1] if (RR1[1]>RR2[1]) else RR2[1]

			print(y)



			print(GraficaR.Nombre +" es "+ NombrefigR +" Con una pertenencia de "+str(GraficaR.BuscarFiguraNombre(float(y),NombrefigR)))

