package me.vukas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

//@SpringBootApplication
//@ComponentScan(useDefaultFilters = false)	//disable component scanning
@EnableAutoConfiguration	//use this to disable component scanning without using @SpringBootApp annotation
@Import({ ProgramConfig.class })
public class Program {
	public static void main(String[] args) {
		SpringApplication.run(Program.class, args);
	}
}
