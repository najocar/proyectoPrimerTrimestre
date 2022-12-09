package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Insert {
    
	/**
	 * Metodo para introducir un numero int
	 * @param texto texto que muestra
	 * @param min número mínimo que se puede seleccionar (Normalmente 0)
	 * @param max número máximo que se puede seleccionar
	 * @return Devuelve el número escrito
	 */
	public static int readInt(String texto, int min, int max) {
        int result = 0;
        Scanner teclado = new Scanner(System.in);
        boolean isInt = false;
        do {
            try {
            	Print.p(texto);
                result = teclado.nextInt();
                if(result >= min && result <= max) {
                	isInt = true;
                	
                }else {
                	Print.p("Debes introducir un número entre " + min + " y " + max);
                }
            } catch (InputMismatchException e) {

                Print.p("ERROR debes introducir un número.");
                teclado.nextLine();
            }
        } while (!isInt);
        return result;
    }
	
	/**
	 * Metodo que pausa la ejecucion del juego
	 * @param msg : String a imprimir en pantalla
	 * @param n : int saltos de linea
	 */
	public static void pause(String msg, int n) {
		int i = 0;
		Print.p(msg);
		do {
			i = readInt("Presiona 0 para continuar...", 0, 0);
		}while(i!=0);
		Print.espace(n);
	}
}
