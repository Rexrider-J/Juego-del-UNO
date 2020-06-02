
import java.util.Scanner;

public abstract class Funciones {
	
	public static Scanner entrada = new Scanner(System.in);
	
	public static int numRandomEntre(int min, int max){
        int numero = (int) (Math.random() * max) + min;
        return numero;
    }
	
	public static String readString(String text){
	    System.out.print(text);
	    String txt = entrada.nextLine();
	    return txt;
	}
	
	static char readChar(String message){                    
        Scanner entrada = new Scanner(System.in);
        char character;
        System.out.print(message);
        character = entrada.nextLine().charAt(0);
        return character;
    }
}
