package fun.bdd;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.*;
import java.util.Scanner;

public class HelloWorldSteps {
	HelloWorld hello = null;
	String helloWorld = "";

	@Given("I have a hello world app")
	public void iHaveAHelloWorldApp() {
	    hello = new HelloWorld();
	}

	@When("I run hello world")
	public void iRunHelloWorld() {
		String data = hello.sayHi();
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner scanner = new Scanner(System.in);
			helloWorld = scanner.nextLine();
			System.out.println(helloWorld);
		} finally {
			System.setIn(stdin);
		}
	}

	@Then("hello world is displayed")
	public void helloWorldIsDisplayed() {
	    Assert.assertEquals("Hello World", helloWorld);
	}
}
