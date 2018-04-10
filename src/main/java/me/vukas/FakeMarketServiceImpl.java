package me.vukas;

import org.springframework.stereotype.Service;

@Service
public class FakeMarketServiceImpl implements MarketService {
	@Override
	public void incrementKey(int increment) {

	}

	@Override
	public Market getMarket(int id) {
		return null;
	}

	@Override
	public Market createMarket(int key) {
		return null;
	}
}
