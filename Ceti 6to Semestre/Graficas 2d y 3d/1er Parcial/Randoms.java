
import java.util.Random;


public class Randoms{
 
	public static void main(String[] args) {		
		//System.out.println("Hola Mundossss");

        Random rand = new Random();
        int  x = rand.nextInt(50);
        int  y = rand.nextInt(50);
        System.out.println("Los numeros Random son:");
        System.out.println(x);
        System.out.println(y);
        System.out.println("El Mayor es:");
        
        if(x>y){
            System.out.println(x);
        }
        else{
            System.out.println(y);
        }
        
	}
 
}

