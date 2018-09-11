import java.lang.*;
public class conv_hex_ip{

public static void main(String[] args) {
	String[] datos= new String[2];
        datos[0] = args[0].toUpperCase();;
	datos[1] = args[1].toUpperCase();
String ip = "";
if(datos[0].equals("IP")){

for(int i=0;i<7; i=i + 2) {
    String Value =datos[1].substring(i,i+2);
    char Value_1[]=Value.toCharArray();
    if(Value_1[0]>=0x30&&Value_1[0]<=0x46&&Value_1[1]>=0x30&&Value_1[1]<=0x46){
    	ip = ip + Integer.valueOf(Value, 16) + ".";}
    else{
	System.out.println("Error: numero Hexadecimal Incorrecto " );
	ip = ip +"-"+".";}
 } // termino del  for
if(!ip.isEmpty()){
System.out.println("Ip = " + ip);
}

} //termino if  hex

else{
if(datos[0].equals("HEX")){
String[] datos_ip= datos[1].split("\\.");
    for(String datos_ips : datos_ip) {
    int Value_1=Integer.parseInt(datos_ips);
    if(Value_1<256){
    ip = ip + Integer.toHexString(Value_1) + ",";}
    else{System.out.println("Error: numero Decimal Incorrecto " );
	ip = ip +"-"+",";}
}// termino del for
if(!ip.isEmpty()){
System.out.println("Ip = " + ip);
}
}
else{
System.out.println("Error en el tipo de conv");
}

}

}
}
