package fun.bdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RetailOrderUnitTest {
    RetailOrder retailOrder;

    @Before
    public void setUp() {
        retailOrder = new RetailOrder();
    }

    @Test
    public void should_include_tax_rate_in_total_order() {
        retailOrder.setNumberOfItems(1);
        retailOrder.setPrice(40.0);
        retailOrder.setTaxRate(5);
        Assert.assertEquals(Double.valueOf(42.0), retailOrder.getOrderValue());
    }

    @Test
    public void should_only_return_two_decimal_places() {
        retailOrder.setNumberOfItems(1);
        retailOrder.setPrice(50.00);
        retailOrder.setTaxRate(7.25);
        Assert.assertEquals(Double.valueOf(53.63), retailOrder.getOrderValue());
    }

    @Test
    public void should_apply_3_percent_discount_on_order_total_over_1000() {
        retailOrder.setNumberOfItems(2);
        retailOrder.setPrice(500.0);
        Assert.assertEquals(Double.valueOf(970.00), retailOrder.getOrderValue());
    }

    @Test
    public void should_receive_message_about_order_discount() {
        retailOrder.setNumberOfItems(4);
        retailOrder.setPrice(250.0);
        retailOrder.getOrderValue();
        Assert.assertEquals("You received a 3% discount", retailOrder.discountMessage());
    }

    @Test
    public void should_not_receive_message_about_order_discount_under_1000() {
        retailOrder.setNumberOfItems(2);
        retailOrder.setPrice(250.0);
        Assert.assertEquals("No discount", retailOrder.discountMessage());
    }

    @Test
    public void should_provide_total_as_dollars_and_cents() {

    }

    @Test
    public void should_not_allow_negative_tax_rate() {

    }

    @Test
    public void should_not_allow_tax_rate_greater_than_15_percent() {

    }
}
