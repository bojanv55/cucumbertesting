package me.vukas;

import me.vukas.domain.Key;
import me.vukas.domain.Market;

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
	public Market createMarket(Key key) {
		return null;
	}

	@Override
	public String getFromDb(int id) {
		return null;
	}

	@Override
	public String getFromDbJpa(int id) {
		return null;
	}
}
