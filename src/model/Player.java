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
		id = 0;
		healt = 10;
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
	public void setHand(Card carta, int indice) {
		this.hand[indice] = carta;
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
	
	public int giveCard(Object[] obj) {
		int result = 0;
		boolean flag = false;
		if(obj!=null) {
			
			int i = (int)(Math.random()*10);
			Card[] carta = (Card[]) obj;
			int indexNull = searchNullHand();
				
			for(int x = carta.length; x >= 0 && !flag; x--) {
				if(cardValidator(i)) {
					if (searchNullHand() != -1) {
						try {
							this.hand[indexNull] = carta[i];
							flag = true;
						} catch (Exception e) {
							System.out.println("Error: \n" + e);
						}
					}
				}else {
					if(i == 9){
						i = 0;
					}
					i++;
				}
			}
		}
		
		return result;
	}
	
	public int searchNullHand() {
		boolean flag = false;
		int result = -1;
		for(int i = 0;i<this.hand.length && !flag; i++) {
			if(hand[i] == null) {
				result = i;
				flag=true;
			}
		}
		return result;
	}
	
	public boolean cardValidator(int n) {
		boolean result = true;
		for(int i = 0; i<this.hand.length; i++) {
			if(this.hand[i] != null) {
				if(n == this.hand[i].getId()) {
					result = false;
				}
			}
		}
		return result;
	}

	
	
}
