package view;

import model.Card;
import model.Player;
import utils.*;

public class Menu {

	/**
	 * Metodo que imprime por pantalla que se ha producido un error.
	 */
	public static void showError() {
		Print.p("Se ha producido un error...");
	}
	
	/**
	 * Metodo que imprime por pantalla el Exit del programa.
	 */
	public static void showExit() {
		Print.p("Hasta la proxima...");
	}
	
	/**
	 * Metodo que imprime por pantalla las reglas del juego.
	 */
	public static void showGameRules() {
		Print.p("AQUI TIENES LAS NORMAS DEL JUEGO");
		Print.p("Este juego consiste en una batalla por turnos donde dos jugadores se enfrentaran por dejar la salud del oponente en 0 \n\nPara comenzar: ");
		Print.p("Se te asignara una baraja de 3 cartas de forma aleatoria.");
		Print.p("Podras elegir cambiar una de las cartas asignadas por otra totalmente aleatoria.");
		Print.p("Cada carta tiene atributos de ataque y defensa que se sumarán al ataque y defensa del jugador");
		Print.p("Estos serán comparados al final del turno para comprobar que jugador recibe daño.");
		Print.p("Ademas cada carta tendra requerirá cierta cantidad de maná para ser lanzada");
		Print.p("y se sumara cierta cantidad de mana al final de cada ronda(Esto depende de si juegas Clasico o Personalizado)\n\n");
	}
	
	/**
	 * Metodo que imprime por pantalla la informacion del combate
	 */
	public static void showCombatStats(Player jugador1, Player jugador2) {
		Print.p("--COMBATE--");
		Print.p("------------------------------------------------------------------|");
		Print.p(" " + jugador1.getNombre() + "  |  Salud: " + jugador1.getHealt() + "  |  Ataque: " + jugador1.getAttack() + "  |  Defensa: " + jugador1.getDefense());
		Print.p("------------------------------------------------------------------|");
		Print.p(" " + jugador2.getNombre() + "  |  Salud: " + jugador2.getHealt() + "  |  Ataque: " + jugador2.getAttack() + "  |  Defensa: " + jugador2.getDefense());
		Print.p("------------------------------------------------------------------|");
	}
	
	/**
	 * Metodo showCombat : metodo que imprime por pantalla el resultado del combate (daño y vida)
	 * @param jugador : 
	 */
	public static void showCombat(Player jugador, int attack) {
		Print.p("|-----------------------------------------------------------------|");
		Print.p(" " + jugador.getNombre() + " ha perdido " + attack + " de vida");
		Print.p("|-----------------------------------------------------------------|");
	}
	
	/**
	 * Metodo que imprime por pantalla el menu principal.
	 */
	public static void showMainMenu() {
		Print.p("-----------------------------------");
		Print.p("| JUGAR | NORMAS DE JUEGO | SALIR |");
		Print.p("----1------------2------------0----");
	}

	/**
	 * Metodo que imprime por pantalla la bienvenida del juego
	 */
	public static void showWelcome() {
		Print.p("--BIENVENIDO--\n");
	}

	/**
	 * Metodo que imprime por pantalla el perdedor de la partida 
	 * @param n : int numero (0 = empate; 1 = jugador1; 2 = jugador2)
	 */
	public static void showWinOrLose(int n) {
		if(n == 0) {
			Print.p("Empate");
		}else if(n == 1) {
			Print.p("Jugador 1 pierde...");
		}else if(n == 2) {
			Print.p("Jugador 2 pierde...");
		}
	}

	/**
	 * Metodo que imprime por pantalla que el mana es insuficiente.
	 */
	public static void showWithoutMana() {
		Print.p("No tienes maná suficiente");
	}
	
	/**
	 * Metodo showUserCard : metodo que imprime por pantalla que la carta ya ha sido utilizada en este turno
	 */
	public static void showUsedCard() {
		Print.p("Esa carta ya la has utilizado durante este turno");
	}
	
	/**
	 * Metodo que imprime por pantalla la inicializacion del turno del jugador
	 * @param jugador : Objeto de tipo player para definir el jugador utilizado en el metodo
	 */
	public static void showTurnPlayer(Player jugador) {
		Print.p("Turno del " + jugador.getNombre());
		Print.p("|-----------------------------------------------------------------|");
		Print.p(" Salud: " + jugador.getHealt() + "  |  Mana: " + jugador.getMana() + "  |  Ataque: " + jugador.getAttack() + "  |  Defensa: " + jugador.getDefense());
		Print.p("|-----------------------------------------------------------------|");
		Print.ph();
		Print.p("Cartas: ");
	}

	/**
	 * Metodo que imprime la informacion de una carta de la mano
	 * @param carta : objeto de tipo Card del que se imprime la informacion
	 * @param i : indice (posicion de la carta en la array)
	 */
	public static void showCard(Card carta, int i) {
		Print.p("|-----------------------------------------------------------------|");
		Print.p(" " + carta.toString());
		Print.p("|------------------------------[ " + (i+1) + " ]------------------------------|");
	}
}
