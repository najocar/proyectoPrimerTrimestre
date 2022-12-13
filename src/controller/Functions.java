package controller;
import model.*;
import utils.*;
import view.*;

public class Functions {
	
	/**
	 * Este método es la partida
	 * @param jugador1 
	 * @param jugador2
	 * @param tablero
	 */
	public static void match(Player jugador1, Player jugador2, PlayMat tablero) {
		int turno = 0;
		do {
			if (turno == 0) {
				Print.espace(10);
				
				Menu.showTurnPlayer(jugador1);
				rellenaMano(jugador1, tablero);
				removeCard(jugador1, tablero);
				
				Insert.pause("Has terminado el turno", 20);
				
				Menu.showTurnPlayer(jugador2);
				rellenaMano(jugador2, tablero);
				removeCard(jugador2, tablero);
				
				Insert.pause("Has terminado el turno", 20);
			}
			maintenance(jugador1, tablero);
			maintenance(jugador2, tablero);
			
			do {
				Menu.showTurnPlayer1(jugador1);	
        main
			}while(!throwCard(jugador1));
			
			Insert.pause("Has terminado el turno", 20);
			
			do {
				Menu.showTurnPlayer2(jugador2);
        main
			}while(!throwCard(jugador2));
			
			Insert.pause("Has terminado el turno", 20);
			
			combat(jugador1, jugador2);
			
			turno++;
			
		}while(!winOrLose(jugador1, jugador2));
		
	}
	
	/**
	 * Elimina una carta del array de cartas del jugador
	 * @param cartas Array de cartas del jugador
	 */
	public static void removeCard(Player jugador, PlayMat tablero) { //quitar tablero
		showHand(jugador.getHand());
		int n = Insert.readInt("¿Deseas eliminar una carta? \nElije la carta que deseas eliminar (0 para cancelar)", 0, 3);
		switch (n) {
		case 1:
			jugador.setHand(null, 0);
			jugador.giveCard(tablero.getDeckOfCards());
			showHand(jugador.getHand());
			break;
		case 2:
			jugador.setHand(null, 1);
			jugador.giveCard(tablero.getDeckOfCards());
			showHand(jugador.getHand());
			break;
		case 3:
			jugador.setHand(null, 2);
			jugador.giveCard(tablero.getDeckOfCards());
			showHand(jugador.getHand());
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
	public static boolean throwCard(Player jugador) {
		boolean finish = false;
		showHand(jugador.getHand());
		int n = Insert.readInt("¿Qué carta deseas lanzar?, 0 para pasar turno", 0, jugador.getHand().length);//modificar argumentos.
		
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
			finish = true;
		}
		return finish;
	}
	
	/**
	 * Compara daños y defensas de los jugadores y resta la diferencia
	 * @param jugador1
	 * @param jugador2
	 */
	public static void combat(Player jugador1, Player jugador2) {
		Menu.showCombat(jugador1, jugador2);
		if (jugador1.getAttack() > jugador2.getDefense()) {
			jugador2.setHealt(jugador2.getHealt()-(jugador1.getAttack() - jugador2.getDefense()));
		}
		if (jugador2.getAttack() > jugador1.getDefense()) {
			jugador1.setHealt(jugador1.getHealt()-(jugador2.getAttack() - jugador1.getDefense()));
		}
	}
		
	/**
	 * Compara el maná del jugador con el coste de la carta y añade su ataque y defensa al jugador
	 * @param jugador Jugador que se quiere comparar
	 * @param carta Carta que se quire comparar
	 */
	public static void checkMana(Player jugador, Card carta) {
		if (jugador.getMana() < carta.getCost() || jugador.getMana() != carta.getCost()) {
			Menu.showWithoutMana();
		}else if (carta.getUsed()) {
			Menu.showUsedCard();
		}else {
			jugador.setMana(jugador.getMana() - carta.getCost());
			jugador.setAttack(jugador.getAttack() + carta.getAttack());
			jugador.setDefense(jugador.getDefense() + carta.getDefense());
			carta.setUsed(true);
		}
	}
	
	/**
	 * Metodo que comprueba si la vida de algun jugador a llegado a 0.
	 * @param jugador1
	 * @param jugador2
	 * @return finish : boolean (true en caso de finalizar la partida)
	 */
	public static boolean winOrLose(Player jugador1, Player jugador2) {
		boolean finish = true;
		if (jugador1.getHealt() <= 0 && jugador2.getHealt() <= 0) {
			Menu.showWinOrLose(0);
		}else if(jugador1.getHealt() <= 0) {
			Menu.showWinOrLose(1);
		}else if(jugador2.getHealt() <= 0) {
			Menu.showWinOrLose(2);
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
	 * Muestra las cartas de la mano del jugador
	 * @param cartas jugador.getHand()
	 */
	public static void showHand(Card[] cartas) {
		for (int i = 0; i < cartas.length; i++) {
			if (cartas[i] != null || !cartas[i].getUsed()) {
				System.out.println(i+1 + ". " + cartas[i].toString());
				Print.espace(1);
			}
		}
	}
	
	/**
	 * Metodo que rellena la mano del jugador en el primer turno.
	 * @param jugador : Objeto(Player) destino de las cartas.
	 * @param tablero : Objeto(PlayMat) baraja utilizada.
	 */
	public static void rellenaMano(Player jugador, PlayMat tablero) {
		for(int i = 0; i < 3; i++){
			jugador.giveCard(tablero.getDeckOfCards());
		}
	}
	
	/**
	 *Metodo que muestra el menu, compuesto de 3 opciones, el numero de la opcion es verificado por otro metodo, y seguira mostrando el menu mientras que el numero introducido 
	 *no sea una opcion correcta.
	 */
	public static void menu(Player jugador1, Player jugador2, PlayMat tablero) {
		int opc =-1;
		
			Menu.showWelcome();
			Menu.showMainMenu();
			opc = Insert.readInt("ELIGE UNA OPCION: ", 0, 2);
			
		switch(opc) {
		case 1:
			match(jugador1, jugador2, tablero);
			break;
		
		case 2:
			Menu.showGameRules();
			menu(jugador1, jugador2, tablero);
			break;
			
		case 3:
			Menu.showExit();
			break;
		}
	}
}
