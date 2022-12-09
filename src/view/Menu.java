package view;

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
	 * Metodo que imprime por pantalla el menu principal.
	 */
	public static void showMainMenu() {
		Print.p(" 1.Jugar \n 2.Normas de Juego \n 0.Salir");
	}

	/**
	 * Metodo que imprime por pantalla la bienvenida del juego
	 */
	public static void showWelcome() {
		Print.p("BIENVENIDO\n");
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
	
	/*
	 * Metodo que imprime por pantalla la inicializacion del turno del jugador 1
	 */
	public static void showTurnPlayer1() {
		Print.p("Turno del jugador 1");
		Print.p("Cartas: ");
	}
	
	/*
	 * Metodo que imprime por pantalla la inicializacion del turno del jugador 2
	 */
	public static void showTurnPlayer2() {
		Print.p("Turno del jugador 2");
		Print.p("Cartas: ");
	}
}
