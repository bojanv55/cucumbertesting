package me.vukas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketJpaRepo extends JpaRepository<Article, Integer>, CustomizedMarketJpaRepo {
}
