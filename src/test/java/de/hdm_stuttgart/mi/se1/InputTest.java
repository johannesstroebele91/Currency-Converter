package de.hdm_stuttgart.mi.se1;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

/**
 * Unit Test of {@link Input}.
 */
public class InputTest {

    @Test
    public void testFileArrayProvider() throws IOException {
        String[] lines = Input.readLines("src/main/java/com/acme/FileArrayProvider.java");
        for (String line : lines) {
            System.out.println(line);
        }
    }

    @Test
    public void TestGetInput(){

    }

    @Test
    public void TestSearchAllCurrencies(){

    }

    @Test
    public void TestCalculateNewCurrency() {
        Assert.assertEquals(5.59d, Input.CalculateNewCurrency(1, 4, 5d, App.allCurrencies, App.allExchangeRates), 0.001);
        Assert.assertEquals(0, Input.CalculateNewCurrency(0, 0, 0, App.allCurrencies, App.allExchangeRates), 0.001);
        Assert.assertEquals(0, Input.CalculateNewCurrency(0, 0, 0, App.allCurrencies, App.allExchangeRates), 0.001);
        Assert.assertEquals(0, Input.CalculateNewCurrency(0, 0, 0, App.allCurrencies, App.allExchangeRates), 0.001);
        Assert.assertEquals(0, Input.CalculateNewCurrency(0, 0, 0, App.allCurrencies, App.allExchangeRates), 0.001);
        Assert.assertEquals(0, Input.CalculateNewCurrency(0, 0, 0, App.allCurrencies, App.allExchangeRates), 0.001);
    }
}
