package me.vukas;

import me.vukas.domain.Key;
import me.vukas.domain.Market;

import org.springframework.stereotype.Service;

@Service
public class MarketServiceImpl implements MarketService {

	private Market market;
	private MarketRepo repo;
	private MarketJpaRepo jpaRepo;

	public MarketServiceImpl(MarketRepo repo, MarketJpaRepo jpaRepo){
		this.repo = repo;
		this.jpaRepo = jpaRepo;
	}

	@Override
	public void incrementKey(int increment) {
		this.market.incrementKey(increment);
	}

	@Override
	public Market getMarket(int id) {
		return this.market;
	}

	@Override
	public Market createMarket(Key key) {
		this.market = new Market(key);
		return this.market;
	}

	@Override
	public String getFromDb(int id) {
		return this.repo.getDataById(id);
	}

	@Override
	public String getFromDbJpa(int id) {
		return this.jpaRepo.findById(id).orElse(new Article()).getContent();
	}
}
