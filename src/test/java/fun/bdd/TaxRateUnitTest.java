package fun.bdd;

import org.junit.Assert;
import org.junit.Test;

public class TaxRateUnitTest {
    @Test
    public void tax_rate_for_Utah() {
        Assert.assertEquals(Double.valueOf(6.85), TaxRate.getRateFor("UT"));
    }

    @Test
    public void tax_rate_for_Texas() {
        Assert.assertEquals(Double.valueOf(6.25), TaxRate.getRateFor("TX"));
    }

    @Test
    public void should_handle_lower_case_state_code() {
        Assert.assertEquals(Double.valueOf(6.85), TaxRate.getRateFor("ut"));
    }

    @Test
    public void should_give_Illegal_Argument_for_Incorrect_State_Code() {
        try {
            TaxRate.getRateFor("AA");
        } catch (IllegalArgumentException iae) {
            Assert.assertEquals("AA was not a valid state code", iae.getMessage());
        }
    }
}
