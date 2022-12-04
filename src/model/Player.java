package model;

public class Player {
	/*
	 * Atributos
	 */
	private int id;
	private int healt;
	private int mana;
	private int attack;
	private int defense;
	Card[] hand; // Array que contiene la mano del jugador
	
	/*
	 * Constructor por default
	 */
	public Player() {
		id = -1;
		healt = 0;
		mana = 0;
		attack = 0;
		defense = 0;	
		hand = new Card[3];
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
	public int getHealt() {
		return healt;
	}
	public void setHealt(int healt) {
		this.healt = healt;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public Card[] getHand() {
		return hand;
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
