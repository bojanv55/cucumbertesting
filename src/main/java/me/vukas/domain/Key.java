package me.vukas.domain;

import java.util.Objects;

public class Key {
	int value;

	private Key(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static Key of(int value){
		return new Key(value);
	}

	public void increment(int increment){
		this.value += increment;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Key key = (Key)o;
		return value == key.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
