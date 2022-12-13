package model;

public class Player {
	/*
	 * Atributos
	 */
	private int id;
	private String nombre;
	private int healt;
	private int mana;
	private int attack;
	private int defense;
	Card[] hand; // Array que contiene la mano del jugador
	
	/*
	 * Constructor por default
	 */
	public Player(String nombre) {
		id = 0;
		this.nombre = nombre;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * Metodo toString : Metodo que sobreescribe el metodo toString
	 */
	public String toString() {
		return "Nombre: " + this.getNombre() + "  |  Salud: " + this.getHealt() + "  |  Maná: " + this.getMana() + "  |  Attack: " + this.getAttack() + "  |  Defense: " + this.getDefense();
	}

	/**
	 * Metodo countPlayer: cuenta la cantidad de objetos(player) que contiene la array players
	 * @param obj : 
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
	
	/**
	 * Metodo giveCard : introduce una carta dentro de la en un huevo null de la mano del jugador
	 * @param obj : array de objetos de la cual elige un objeto y lo inserta dentro de la mano del jugador  
	 */
	public void giveCard(Object[] obj) {
		boolean flag = false;
		if(obj!=null) {
			
			int i = (int)(Math.random()*9);
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
					if(i == carta.length){
						i = 0;
					}
					i++;
				}
			}
		}		
	}
	
	/**
	 * Metodo searchNullHand : recorre una array buscando el primer espacio con null y lo devuelve
	 * @return result : entero resultante de la busqueda de null (-1 en caso de estar llena)
	 */
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
	
	/**
	 * Metodo cardValidator : valida que el valor pasado como argumento no se repita en la array hand.
	 * @param n : int numero pasado como argumento para comprobar si se repite
	 * @return result : boolean (true en caso de que haya un valor repitido)
	 */
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
