package me.vukas;

import me.vukas.domain.Key;
import me.vukas.domain.Market;

public interface MarketService {
	void incrementKey(int increment);
	Market getMarket(int id);
	Market createMarket(Key key);
}
