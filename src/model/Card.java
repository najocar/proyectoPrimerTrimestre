package model;

public class Card {
	/*
	 * Atributos
	 */
	private int id;
	private int cost; 
	private int attack;
	private int defense;
	
	/*
	 * Constructor por default
	 */
	public Card(){ 
		id = -1;
		cost = 0;
		attack = 0;
		defense = 0;
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
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
	
	public String toString() {
		return "\nId: " + this.getId() + "\nCost: " + this.getCost() + "\nAttack: " + this.getAttack() + "\nDefense: " + this.getDefense();
	}
	
}
