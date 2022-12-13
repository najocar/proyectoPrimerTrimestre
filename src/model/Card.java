package model;

public class Card {
	/**
	 * Atributos
	 */
	private int id;
	private String name;
	private int cost; 
	private int attack;
	private int defense;
	private boolean used;
	
	/**
	 * Constructor por default
	 */
	public Card(){ 
		id = -1;
		name = "undefined";
		cost = 0;
		attack = 0;
		defense = 0;
		used = false;
	}
	
	public Card(int id, String name, int cost, int attack, int defense) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.attack = attack;
		this.defense = defense;
		this.used = false;
	}


	/*
	 * GETTER AND SETTER
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public boolean getUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	
	public String toString() {
		return "Nombre: " + this.getName() + "  |  Coste: " + this.getCost() + "  |  Ataque: " + this.getAttack() + "  |  Defensa: " + this.getDefense();
	}
	
}
