package proyectoEV1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncionesDAVID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMenu();
	}
	
	/**
	 *Metodo que muestra el menu, compuesto de 3 opciones, el numero de la opcion es verificado por otro metodo, y seguira mostrando el menu mientras que el numero introducido 
	 *no sea una opcion correcta.
	 */
	public static void printMenu() {
		Scanner sc = new Scanner (System.in);
		int opc =-1;
		
		
		System.out.println("BIENVENIDO\n");
		do {
			System.out.println(" 1.Partida Clasica \n 2.Partida Personalizada \n 3.Normas de Juego\n");
			opc =leeEntero("ELIGE UNA OPCION");
			if(opc<1 && opc>3) {
				System.out.println("Elige una opcion correcta: ");

			}
		}while(opc !=1 && opc !=2 && opc !=3);
		
		switch(opc) {
		
		case 1:
			//playMatch
			
			break;
		
		case 2:
			//playPersMat
			
			break;
			
		case 3:
			normasJuego();
			printMenu();
			break;
		}
		
	
		 		 
	}
	/**
	 * Metodo que muestra una frase al usuario y verifica que el numero introducido es entero, en caso de no serlo sigue preguntando hasta que lo sea
	 * @param f texto que le vamos a mostrar al usuario
	 * @return devuelve el numero entero verificado
	 */
	public static int leeEntero(String f) {
		Scanner sc = new Scanner (System.in);
		int numero =-1;
		boolean flag =false;
		
		do {
			try {
				System.out.println(f);
				numero = sc.nextInt();
				flag=true;
				
			}catch(InputMismatchException ex) {
				System.out.println("Eso no es un numero entero");
				sc.next();
			}
		}while(!flag);
		return numero;
	}
	
	
	/**
	 * Metodo que corresponde a la opcion 3 del menu, muestra las reglas del juego y acto seguido vuelve a mostrar el menu para elegir el tipo de partida
	 */
	public static void normasJuego() {
		System.out.println("AQUI TIENES LAS NORMAS DEL JUEGO");
		System.out.println("Este juego consiste en una batalla por turnos donde dos jugadores se enfrentaran por dejar la salud del oponente en 0 \n\nPara comenzar,"
				+ "Se te asignara una baraja de 3 cartas de forma aleatoria, podras elegir cambiar una de las cartas asignadas por otra totalmente aleatoria."
				+ "\nCada carta tiene atributos de ataque y defensa que seran comparados al final del turno para comprobar que jugador recibe daño.\nAdemas cada carta tendra un coste de mana"
				+ "y se sumara cierta cantidad de mana al final de cada ronda(Esto depende de si juegas Clasico o Personalizado)\n");
	}
	
	/**
	 * param mano asignada aleatoriamete con otra funcion
	 * Metodo que muestra las cartas que se te han asignado automaticamente
	 */
	public static void showHand(/*array de cartas*/) {
		int[] mano = new int [3];
			for (int i = 0; i < mano.length; i++) {
////				if(/*card!=null*/) {					
//					System.out.print("Tu carta "+(i+1)+" es "/*nombreCarta*/);
////				}
			}
		
	}

}
