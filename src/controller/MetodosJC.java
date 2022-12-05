package controller;
import model.Card;
import model.Player;
import java.util.Scanner;

public class MetodosJC {	
	
	/**
	 * Elimina una carta del array de cartas del jugador
	 * @param cartas Array de cartas del jugador
	 */
	public static void removeCard(Scanner teclado, Player jugador) {
		System.out.println("¿Qué carta deseas lanzar?");
		muestra(jugador.getHand());
		int n = teclado.nextInt();//cambiar por leeEntero
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
		muestra(jugador.getHand());
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
	private static void checkMana(Player jugador, Card carta) {
		if (jugador.getMana() >= carta.getCost()) {
			jugador.setMana(jugador.getMana() - carta.getCost());
			jugador.setAttack(jugador.getAttack() + carta.getAttack());
			jugador.setDefense(jugador.getDefense() + carta.getDefense());
		}else {
			System.out.println("No tienes maná suficiente");
		}
	}
	
	public static void muestra(Card[] cartas) {
		for (Card carta : cartas) {
			if (carta != null) {
				System.out.println(carta);
			}
		}
	}

}
