package matrizadyacente;
import java.util.Scanner;
public class MatrizAdyacente{
public static void main(String[] args) {
    int nodos;
    System.out.println("Cuantos nodos son ?");
    Scanner nodoscaneado = new Scanner(System.in);
    nodos=nodoscaneado.nextInt();
    String[ ] nombre = new String[nodos];
    int[][]matriz=new int[nodos][nodos];
    for(int j=0;j<nodos;j++)
    {
        for(int i=0;i<nodos;i++){
                matriz[j][i]=0;
                }
    }
    /*
    dar valores a las matrices 
    matriz[0][0]=1;matriz[0][1]=2;matriz[0][2]=5;
    matriz[1][0]=4;matriz[1][1]=5;matriz[1][2]=6;
    matriz[2][0]=7;matriz[2][1]=8;matriz[2][2]=9;
    */
    /*    System.out.println(matriz[0][0]); System.out.println(matriz[1][0]); System.out.println(matriz[2][0]);
    System.out.println(matriz[0][1]); System.out.println(matriz[1][1]); System.out.println(matriz[2][1]);
    System.out.println(matriz[0][2]); System.out.println(matriz[1][2]); System.out.println(matriz[2][2]);
    */
    int [] nu=new int[nodos];
    int num;
    for(int i=0;i<nodos;i++)
    {
        System.out.println("como se llama el nodo ?"+i);
        Scanner temporal=new Scanner(System.in);
        nombre[i] = temporal.nextLine();
    }        
    System.out.print("**");
    for(int i=0;i<nodos;i++){ System.out.print(nombre[i] +" ");}
    for(int i=0;i<nodos;i++)
    {
        System.out.print(nombre[i]+" ");

        System.out.println(" ");

        System.out.print(nombre[i]+" ");
        for(int j=0;j<nodos;j++)
        {
            System.out.print(+matriz[i][j]+" ");
        }


    }   
    int salir;
    int fila;
    int columna;
    do{
        System.out.println("elige la opcion que gustes realizar"); 
        System.out.println("1.-cambiar valor de matriz"); 
        System.out.println("2.-ver matriz"); 
        System.out.println("3.-Salir"); 
        Scanner temporal=new Scanner(System.in);
                salir=temporal.nextInt();
        if(salir==1)
        {
            System.out.println("intoduzca la fila ---->"); 
            Scanner temporal1=new Scanner(System.in);
            fila=temporal1.nextInt();
                    
            System.out.println("introduzca la columna ↓"); 
            Scanner temporal2=new Scanner(System.in);
            columna=temporal2.nextInt();
            if(matriz[fila][columna]==0){matriz[fila][columna]=1;}
            else{matriz[fila][columna]=0;}        
        }
        if(salir==2)
        {
            System.out.print("**");
            for(int i=0;i<nodos;i++){ System.out.print(nombre[i] +" ");}

            for(int i=0;i<nodos;i++)
            {
                System.out.print(nombre[i]+" ");

                System.out.println(" ");

                System.out.print(nombre[i]+" ");
                for(int j=0;j<nodos;j++)
                {
                    System.out.print(+matriz[i][j]+" ");
                }
            }   
        }

    }
    while(salir!=3);
   
    }
}

