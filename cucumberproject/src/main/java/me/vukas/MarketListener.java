package me.vukas;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class MarketListener {

	private MarketService marketService;

	public MarketListener(MarketService marketService){
		this.marketService = marketService;
	}

	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = "test1", durable = "true"),
			exchange = @Exchange(value = "some.ex"),
			key = "#"))
	public void receive(String msg){

		marketService.saveMarketWithMsg(msg);

		System.out.println("RECEIVED : " + marketService.getFromDb(100));


	}


}
