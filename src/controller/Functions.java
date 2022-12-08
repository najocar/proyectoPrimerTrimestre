package controller;
import model.Card;
import model.Player;
import model.PlayMat;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Functions {
	
	public static void match(Player jugador1, Player jugador2) {
		do {
			int turno = 0;
			if (turno == 0) {
				System.out.println("Cartas jugador 1");
				//giveCard(jugador1);
				removeCard(jugador1);
				
				espace(15);
				
				System.out.println("Cartas jugador 2");
				//giveCard(jugador2);
				removeCard(jugador2);
				
			}
			maintenance(jugador1, null);
			maintenance(jugador2, null);
		}while(winOrLose(null, null));
		
	}
	
	/**
	 * Elimina una carta del array de cartas del jugador
	 * @param cartas Array de cartas del jugador
	 */
	public static void removeCard(Player jugador) {
		System.out.println("¿Deseas eliminar una carta?");
		showHand(jugador.getHand());
		int n = readInt("Elije la carta que deseas eliminar (0. si no quiers eliminar ninguna)", 0, 3);//cambiar por leeEntero
		switch (n) {
		case 1:
			jugador.getHand()[0] = null;
			break;
		case 2:
			jugador.getHand()[1] = null;
			break;
		case 3:
			jugador.getHand()[2] = null;
			break;
		default:
			break;
		}
	}
	
	/**
	 * 
	 * Se elige la carta que se quiere lanzar, luego llama a check mana para comprobar si puede ser lanzada
	 * @param jugador Jugador que desea hacer la acción
	 * @param cartas Array de cartas del jugador
	 */
	public static void throwCard(Scanner teclado, Player jugador) {
		System.out.println("¿Qué carta deseas lanzar?");
		showHand(jugador.getHand());
		int n = teclado.nextInt();//cambiar por leeEntero
		switch (n) {
		case 1:
			checkMana(jugador, jugador.getHand()[0]);
			break;
		case 2:
			checkMana(jugador, jugador.getHand()[1]);
			break;
		case 3:
			checkMana(jugador, jugador.getHand()[2]);
			break;
		default:
			break;
		}
	}
	
	/**
	 * Compara daños y defensas de los jugadores y resta la diferencia
	 * @param jugador1
	 * @param jugador2
	 */
	public void combat(Player jugador1, Player jugador2) {
		if (jugador1.getAttack() > jugador2.getDefense()) {
			jugador2.setHealt(jugador2.getHealt()-(jugador1.getAttack() - jugador2.getDefense()));
		}
		if (jugador2.getAttack() > jugador1.getDefense()) {
			jugador1.setHealt(jugador1.getHealt()-(jugador2.getAttack() - jugador1.getDefense()));
		}
	}
	
	
	/**
	 * compara el maná del jugador con el coste de la carta y añade su ataque y defensa al jugador
	 * @param jugador Jugador que se quiere comparar
	 * @param carta Carta que se quire comparar
	 */
	public static void checkMana(Player jugador, Card carta) {
		if (jugador.getMana() >= carta.getCost()) {
			jugador.setMana(jugador.getMana() - carta.getCost());
			jugador.setAttack(jugador.getAttack() + carta.getAttack());
			jugador.setDefense(jugador.getDefense() + carta.getDefense());
		}else {
			System.out.println("No tienes maná suficiente");
		}
	}
	
	/**
	 * 
	 * @param jugador1
	 * @param jugador2
	 */
	public static boolean winOrLose(Player jugador1, Player jugador2) {
		boolean finish = true;
		if (jugador1.getHealt() <= 0 && jugador2.getHealt() <= 0) {
			System.out.println("Empate");
		}else if(jugador1.getHealt() <= 0) {
			System.out.println("jugador 1 pierde");
		}else if(jugador2.getHealt() <= 0) {
			System.out.println("jugador 2 pierde");
		}else {
			finish = false;
		}
		return finish;
	}
	
	/**
	 * Reseteo de valores e incremento de maná
	 * @param jugador jugador al que se aplica mantenimiento
	 * @param tablero parametros del tablero
	 */
	public static void maintenance(Player jugador, PlayMat tablero) {
		jugador.setAttack(0);
		jugador.setDefense(0);
		jugador.setMana(jugador.getMana() + tablero.getIncreasedMana());
	}
	
	/**
	 * 
	 * @param texto texto que muestra
	 * @param min número mínimo que se puede seleccionar (Normalmente 0)
	 * @param max número máximo que se puede seleccionar
	 * @return Devuelve el número escrito
	 */
	public static int readInt(String texto, int min, int max) {
        int result = 0;
        boolean isInt = false;
        Scanner teclado = new Scanner(System.in);
        do {
            try {

                System.out.println(texto);
                result = teclado.nextInt();
                if(result >= min && result <= max) {
                	isInt = true;
                	
                }else {
                	System.out.println("Debes introducir un número entre " + min + " y " + max);
                }

            } catch (InputMismatchException e) {

                System.out.println("ERROR debes introducir un número.");
                teclado.nextLine();
            }
        } while (!isInt);

        return result;
    }
	
	/**
	 * Muestra las cartas de la mano del jugador
	 * @param cartas jugador.getHand()
	 */
	public static void showHand(Card[] cartas) {
		for (int i = 0; i < cartas.length; i++) {
			if (cartas[i] != null) {
				System.out.println(i + ". " + cartas[i]);
			}
		}
	}
	
	/**
	 * Introduce espacios en consola
	 * @param n número de espacios
	 */
	public static void espace(int n) {
		for (int i = 0; i <= n; i++) {
			System.out.println();
		}
	}
	
	/**
	 * Instrucciones del juego
	 */
	public static void gameRules() {
		System.out.println("AQUI TIENES LAS NORMAS DEL JUEGO");
		System.out.println("Este juego consiste en una batalla por turnos donde dos jugadores se enfrentaran por dejar la salud del oponente en 0 \n\nPara comenzar: ");
		System.out.println("Se te asignara una baraja de 3 cartas de forma aleatoria.");
		System.out.println("Podras elegir cambiar una de las cartas asignadas por otra totalmente aleatoria.");
		System.out.println("Cada carta tiene atributos de ataque y defensa que se sumarán al ataque y defensa del jugador");
		System.out.println("Estos serán comparados al final del turno para comprobar que jugador recibe daño.");
		System.out.println("Ademas cada carta tendra requerirá cierta cantidad de maná para ser lanzada");
		System.out.println("y se sumara cierta cantidad de mana al final de cada ronda(Esto depende de si juegas Clasico o Personalizado)\n\n");
	}
	
	/**
	 *Metodo que muestra el menu, compuesto de 3 opciones, el numero de la opcion es verificado por otro metodo, y seguira mostrando el menu mientras que el numero introducido 
	 *no sea una opcion correcta.
	 */
	public static void menu(Player jugador1, Player jugador2) {
		int opc =-1;
		
		System.out.println("BIENVENIDO\n");
			System.out.println(" 1.Jugar \n 2.Normas de Juego \n 0.Salir");
			opc = readInt("ELIGE UNA OPCIÓN", 0, 2);
			
		switch(opc) {
		
		case 1:
			match(jugador1, jugador2);
			
			break;
		
		case 2:
			gameRules();
			menu(jugador1, jugador2);
			
			break;
			
		case 3:
			System.out.println("Hasta la próxima");
			break;
		}
	}
}
