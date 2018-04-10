package me.vukas;

public interface MarketService {
	void incrementKey(int increment);
	Market getMarket(int id);
	Market createMarket(int key);
}
