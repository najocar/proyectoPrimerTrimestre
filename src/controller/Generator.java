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
		
		Card carta1 = new Card(0, "Zombie", 2, 2, 2);
		Card carta2 = new Card(1, "Caballero", 2, 2, 2);
		Card carta3 = new Card(2, "Mago", 2, 2, 2);
		Card carta4 = new Card(3, "Bola", 2, 2, 2);
		Card carta5 = new Card(4, "Escudo", 2, 2, 2);
		Card carta6 = new Card(5, "Flechas", 2, 2, 2);
		Card carta7 = new Card(6, "Albaricoque", 2, 2, 2);
		Card carta8 = new Card(7, "Rey", 2, 2, 2);
		Card carta9 = new Card(8, "Barbaro", 2, 2, 2);
		Card carta10 = new Card(9, "Reina", 2, 2, 2);
		
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
