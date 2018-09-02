public class OrdenarNumeros{
 
	public static void main(String[] args) {		
		//System.out.println("Hola Mundossss");

        int[] numbers = new int[args.length];
        for(int i = 0;i < args.length;i++)
        {
        
        numbers[i] = Integer.parseInt(args[i]);
        }

        for (int x = 0; x<numbers.length; x++ ){
            for(int y=0; y<numbers.length; y++){
                if(numbers[x]>numbers[y]){
                    int temp = numbers[x];
                    numbers[x]= numbers[y];
                    numbers[y]= temp;
                }

            }

        }

        for (int f : numbers){
            System.out.println(f);
        }

	}
 
}