package me.vukas;

import org.springframework.stereotype.Service;

@Service
public class MarketServiceImpl implements MarketService {

	private Market market;

	@Override
	public void incrementKey(int increment) {
		this.market.incrementKey(increment);
	}

	@Override
	public Market getMarket(int id) {
		return this.market;
	}

	@Override
	public Market createMarket(int key) {
		this.market = new Market(key);
		return this.market;
	}
}