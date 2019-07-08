package fun.bdd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RetailOrder {
	private Double price;
	private Integer numberOfItems;
	private Double taxRate = 0.0;
	private String discountMessage = "No discount";

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getOrderValue() {
		Double totalPriceBeforeTax = numberOfItems * price;

		totalPriceBeforeTax = applyDiscount();
		Double taxOnTotal = totalPriceBeforeTax * taxRate/100;
		Double totalWithTax = totalPriceBeforeTax + taxOnTotal;
		Double totalTimes100 = totalWithTax * 100;
		Double roundedTotalTimes100 = Double.valueOf(Math.round(totalTimes100));
		return roundedTotalTimes100/100;
	}

	public double getPrice() {
		return price;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public static void main (String args[]) {
		RetailOrder retailOrder = new RetailOrder();

		System.out.println("Welcome to our fabulous retail ordering calculator");
		System.out.println("Enter the number of items: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			retailOrder.setNumberOfItems(Integer.valueOf(br.readLine()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Enter the price of the item: ");
		try {
			retailOrder.setPrice(Double.valueOf(br.readLine()));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		System.out.println("Enter the state code: ");
		try {
			retailOrder.setTaxRate(TaxRate.getRateFor(br.readLine()));
			System.out.println("Your Total is: $" + retailOrder.getOrderValue());
			System.out.println(retailOrder.discountMessage());
			System.out.println("Thank you. Have a great day!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	private Double getOrderValueBeforeTax() {
		return numberOfItems * price;
	}

    public String discountMessage() {
		return discountMessage;
	}

	private Double applyDiscount() {
		Double totalPriceBeforeTax = getOrderValueBeforeTax();

		if (totalPriceBeforeTax >= 1000.0 && totalPriceBeforeTax < 5000) {
			totalPriceBeforeTax -= totalPriceBeforeTax * 3/100;
			discountMessage = "You received a 3% discount";
		} else if (totalPriceBeforeTax >= 5000) {
			totalPriceBeforeTax -= totalPriceBeforeTax * 5/100;
			discountMessage = "You received a 5% discount";
		}

		return totalPriceBeforeTax;
	}
}
