public class Cadenas{
 
	public static void main(String[] args) {		
		//System.out.println("Hola Mundossss");
        String str= new String(args[0]);

        StringBuilder bulid = new StringBuilder(str);
        System.out.println(bulid.toString());
        for(int x=0; x< str.length()-1 ; x++ ){
            bulid.deleteCharAt(0);
            System.out.println(bulid.toString());

        }

        StringBuilder bulid2 = new StringBuilder(str);
        for(int x=bulid2.length()-1 ; x>0 ; x-- ){
            bulid2.deleteCharAt(x);
            System.out.println(bulid2.toString());

        }

        //bulid.deleteCharAt(1);  // Shift the positions front.
        //System.out.println("Builder : "+bulid);
        //System.out.println(x[0]);
	}
 
}