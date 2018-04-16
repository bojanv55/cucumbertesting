package me.vukas;

import me.vukas.domain.Key;

public class Configuration {

	private int matchId = 0;
	private Key key = Key.of(0);

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public void changeKeyForMatch(int matchId, Key key){

	}
}
