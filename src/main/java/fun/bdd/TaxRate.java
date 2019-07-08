package fun.bdd;

import java.util.Collection;
import java.util.HashMap;

public class TaxRate {
    private static final HashMap<String, Double> stateCodeToTaxMap = new HashMap<String, Double>() {
        {
            put("UT", 6.85);
            put("NV", 8.00);
            put("TX", 6.25);
            put("AL", 4.00);
            put("CA", 8.25);
        }
    };

    public static Double getRateFor(String stateCode) throws IllegalArgumentException {
        String stateCodeConvertedToUpper = stateCode.toUpperCase();

        if (stateCodeToTaxMap.containsKey(stateCodeConvertedToUpper))
            return stateCodeToTaxMap.get(stateCodeConvertedToUpper);
        else
            throw new IllegalArgumentException(stateCodeConvertedToUpper + " was not a valid state code");
    }
}
