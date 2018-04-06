package me.vukas;

public class Market {
	private int key;

	public Market(int key){
		this.key = key;
	}

	public void incrementKey(int increment){
		this.key += increment;
	}

	public int getKey(){
		return this.key;
	}
}
