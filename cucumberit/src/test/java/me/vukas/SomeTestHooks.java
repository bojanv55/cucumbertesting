package me.vukas;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SomeTestHooks {
	@Before
	public void beforeCallingScenario(){
		System.out.println("Before scenario");
	}

	@After(order = 10)	//exec first
	public void afterCallingScenario(){
		System.out.println("After scenario");
	}

	@Before(value = "@mail", order = 10)
	public void beforeCallingScenario1(){
		System.out.println("Before scenario");
	}

	@Before("@mail")
	public void onlyBeforeAdminTagged(){
		System.out.println("Only before admin");
	}

	@After(order = 20)	//exec second
	public void withParam(Scenario scenario){
		System.out.println("Finished with " + scenario.getStatus());
	}
}
