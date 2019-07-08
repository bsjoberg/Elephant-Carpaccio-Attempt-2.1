package fun.bdd;

import cucumber.api.java.en.And;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.*;
import java.util.Scanner;

public class DisplayOrderValueSteps {
	private RetailOrder retailOrder = null;

	@Given("I am buying (an )item(s)")
	public void iAmBuyingAnItem() {
		retailOrder = new RetailOrder();
	}

	@When("I have {int} item(s) at ${int}")
	public void iHaveNumberItemAtPrice(int numberOfItems, int price) {
		iHaveNumberItemAtPrice(numberOfItems, Double.valueOf(price));
	}

	@When("I have {int} item(s) at ${double}")
	public void iHaveNumberItemAtPrice(int numberOfItems, double price) {
		String userEnteredNumberOfItems;
		String userEnteredPrice;
		System.out.println("\nEnter Number of Items: ");

		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream(Integer.toString(numberOfItems).getBytes()));
			Scanner scanner = new Scanner(System.in);
			userEnteredNumberOfItems = scanner.nextLine();
			System.out.println(userEnteredNumberOfItems);
		} finally {
			System.setIn(stdin);
		}

		retailOrder.setNumberOfItems(Integer.valueOf(userEnteredNumberOfItems));

		System.out.println("Enter price of item: ");

		try {
			System.setIn(new ByteArrayInputStream(Double.toString(price).getBytes()));
			Scanner scanner = new Scanner(System.in);
			userEnteredPrice = scanner.nextLine();
			System.out.println(userEnteredPrice);
		} finally {
			System.setIn(stdin);
		}
		retailOrder.setPrice(Double.valueOf(userEnteredPrice));
	}

	@Then("my final order value is ${int}")
	public void myFinalOrderValueIs$(Integer orderValue) {
		myFinalOrderValueIs$(Double.valueOf(orderValue));
	}

	@Then("my final order value is ${double}")
	public void myFinalOrderValueIs$(Double orderValue) {
		System.out.println("\nTotal Value: " + retailOrder.getOrderValue());
	    Assert.assertEquals(orderValue, retailOrder.getOrderValue());
	}

	@And("the tax is {int}%")
	public void theTaxIs(int taxRate) {
		retailOrder.setTaxRate(taxRate);
	}

	@And("the state code is {string}")
	public void theStateCodeIs(String stateCode) {
		retailOrder.setTaxRate(TaxRate.getRateFor(stateCode));
	}

	@Then ("I am notified of my {string} discount")
	public void iAmNotifiedOfMyDiscount(String discountAmount) {
		Assert.assertEquals("You received a " + discountAmount + " discount" ,retailOrder.discountMessage());
	}
}