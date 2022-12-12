package controller;

import controller.Functions;
import model.*;

public class Generator {

	/**
	 * Metodo que genera y settea a fuego (tableros, cartas, jugadores)
	 */
	public static void generador() {
		PlayMat tablero = new PlayMat();
		Player jugador1 = new Player();
		Player jugador2 = new Player();
		
		tablero.setPlayer(jugador1);
		tablero.setPlayer(jugador2);
		
		Card carta1 = new Card(0, "Bandido", 1, 1, 1);
		Card carta2 = new Card(1, "Escudero", 3, 1, 3);
		Card carta3 = new Card(2, "Mercenario", 2, 3, 0);
		Card carta4 = new Card(3, "Bola de fuego", 1, 2, 0);
		Card carta5 = new Card(4, "Escudo", 1, 0, 2);
		Card carta6 = new Card(5, "Dragon", 3, 3, 1);
		Card carta7 = new Card(6, "Alquimista",2, 2, 1);
		Card carta8 = new Card(7, "Rey", 4, 4, 1);
		Card carta9 = new Card(8, "Gigante", 4, 1, 4);
		Card carta10 = new Card(9, "Valquiria", 3, 2, 2);
		
		tablero.setCard(carta1);
		tablero.setCard(carta2);
		tablero.setCard(carta3);
		tablero.setCard(carta4);
		tablero.setCard(carta5);
		tablero.setCard(carta6);
		tablero.setCard(carta7);
		tablero.setCard(carta8);
		tablero.setCard(carta9);
		tablero.setCard(carta10);
		
		Functions.menu(jugador1, jugador2, tablero);
	}
	
	
	
}
