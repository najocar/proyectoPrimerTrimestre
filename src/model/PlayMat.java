package model;

public class PlayMat {
	/*
	 * Atributos
	 */
	private int id;
	private int increasedAttack;
	private int increasedDefense;
	private int increasedMana;
	Card[] deckOfCards;
	Player[] players;
	
	/*
	 * Constructor por default
	 */
	public PlayMat() {
		id = 0;
		increasedAttack = 0;
		increasedDefense = 0;
		increasedMana = 0;
		
		deckOfCards = new Card[10];
		players = new Player[2];
	}

	/*
	 * GETTER AND SETTER
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIncreasedAttack() {
		return increasedAttack;
	}
	public void setIncreasedAttack(int increasedAttack) {
		this.increasedAttack = increasedAttack;
	}
	public int getIncreasedDefense() {
		return increasedDefense;
	}
	public void setIncreasedDefense(int increasedDefense) {
		this.increasedDefense = increasedDefense;
	}
	public int getIncreasedMana() {
		return increasedMana;
	}
	public void setIncreasedMana(int increasedMana) {
		this.increasedMana = increasedMana;
	}
	public Card[] getDeckOfCards() {
		return deckOfCards;
	}
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * Metodo que inserta un objeto(Player) en la array players
	 * @param obj : objeto de tipo Player a insertar
	 * @return boolean : resultado de haber insertado el objero (true en caso positivo)
	 */
	public boolean setPlayer(Object obj) {
		boolean result = false;
		int index = countArray(players);
		if(obj != null && index < 2) {
			Player jugador = (Player)obj;
			players[index] = jugador;
			result = true;
		}		
		return result;
	}
	
	/**
	 * Metodo que inserta un objeto(Card) en la array deckOfCards
	 * @param obj : objeto tipo Card a insertar
	 * @return boolean : resultado de haber insertado el objeto (true en caso positivo)
	 */
	public boolean setCard(Object obj) {
		boolean result = false;
		int index = countArray(deckOfCards);
		if(obj != null && index <= 1024) {
			Card carta = (Card) obj;
			deckOfCards[index] = carta;
			result = true;
		}		
		return result;
	}
	
	/**
	 * Metodo countPlayer: cuenta la cantidad de objetos(player) que contiene la array players
	 * @return result : variable de tipo entero, es la cantidad de objetos que contiene la array
	 */
	public int countArray(Object[] obj) {
		int result = 0;
		for(int i = 0; i<obj.length;i++) {
			if(obj[i] != null) {
				result++;
			}
		}	
		return result;
	}
}
