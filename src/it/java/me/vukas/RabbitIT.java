package me.vukas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ProgramConfig.class, TestProgramConfig.class })
public class RabbitIT {

	@Autowired
	private ConnectionFactory connectionFactory;
	@Autowired
	private MarketService service;

	@Autowired
	private AmqpAdmin amqpAdmin;

	@Test
	public void testmessage() throws InterruptedException {

		RabbitTemplate rabbitTemplate = new RabbitTemplate(this.connectionFactory);

		rabbitTemplate.send("some.ex", "#", MessageBuilder.withBody("SomeData".getBytes()).build());

		amqpAdmin.declareQueue(QueueBuilder.nonDurable("asd").build());
		//amqpAdmin.declareQueue(QueueBuilder.nonDurable("test1").build());

		Thread t = new Thread(() -> {
			try {
				Thread.sleep(10000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		t.start();
		t.join();



		System.out.println(service.getFromDb(100));


	}

}
