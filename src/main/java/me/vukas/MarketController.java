package me.vukas;

import me.vukas.domain.Key;
import me.vukas.domain.Market;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("market")
public class MarketController {

	private MarketService marketService;

	public MarketController(MarketService marketService){
		this.marketService = marketService;
	}

	@PostMapping("incrementKey/{increment}")
	public void incrementKey(@PathVariable Integer increment){
		this.marketService.incrementKey(increment);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("createMarket/{key}")
	public Market createMarket(@PathVariable Key key){
		return this.marketService.createMarket(key);
	}

	@GetMapping("{id}")
	public Market getMarket(@PathVariable Integer id){
		return this.marketService.getMarket(id);
	}
}
