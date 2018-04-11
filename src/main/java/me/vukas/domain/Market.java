package me.vukas.domain;

public class Market {
	private Key key;

	public Market(Key key){
		this.key = key;
	}

	public void incrementKey(int increment){
		this.key.increment(increment);
	}

	public Key getKey(){
		return this.key;
	}
}
