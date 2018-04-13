package me.vukas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ProgramConfig.class, TestProgramConfig.class })
public class JdbcIT {

	@Autowired
	private MarketService service;

	@Test
	@Sql("classpath:sql/insert_market.sql")
	public void it(){
		String m = service.getFromDb(1);
		assertThat(m).isEqualTo("fg");
	}

}
