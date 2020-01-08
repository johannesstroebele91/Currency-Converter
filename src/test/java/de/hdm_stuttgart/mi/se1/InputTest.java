package de.hdm_stuttgart.mi.se1;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.Arrays;

/**
 * Unit Test of {@link Input}.
 */
public class InputTest {

    @Test
    public void testFileArrayProvider() throws IOException {
        String[] lines = Input.readLines("currencys.txt");
        for (String line : lines) {
            System.out.println(line);
        }
    }

    @Test
    public void TestGetInput(){
        Assert.assertTrue(Input.getInput("Hallo", "Hallo"));
        Assert.assertTrue(Input.getInput("aBcD", "AbCd"));
        Assert.assertTrue(Input.getInput("SE stinkt", "se Stinkt"));
        Assert.assertTrue(Input.getInput("Backfisch", "baCKfiSCH"));
        Assert.assertTrue(Input.getInput("baNane", "banane"));
        Assert.assertFalse(Input.getInput("Fail", "Success"));
        Assert.assertFalse(Input.getInput("Hallo Welt", "Hello World"));
    }

    String[] testSearchAllCurrencies_1 = {"U.S. dollar", "Australian dollar", "Brunei dollar", "Canadian dollar", "New Zealand dollar", "Singapore dollar", "Trinidadian dollar"};
    String[] testSearchAllCurrencies_2 = {"Euro"};
    String[] testSearchAllCurrencies_3 = {"Peruvian sol"};
    String[] testSearchAllCurrencies_4 = {"Danish krone", "Trinidadian dollar"};
    String[] testSearchAllCurrencies_5 = {"Algerian dinar", "Bahrain dinar", "Kuwaiti dinar", "Libyan dinar", "Tunisian dinar"};

    @Test
    public void TestSearchAllCurrencies() throws IOException{
        String[] testAllCurrencies = Input.splitArray(Input.readLines("currencys.txt"), 0);

        Assert.assertArrayEquals(testSearchAllCurrencies_1,Input.searchAllCurrencies(testAllCurrencies, "dol"));
        Assert.assertArrayEquals(testSearchAllCurrencies_2,Input.searchAllCurrencies(testAllCurrencies, "EU"));
        Assert.assertArrayEquals(testSearchAllCurrencies_3,Input.searchAllCurrencies(testAllCurrencies, "peru"));
        Assert.assertArrayEquals(testSearchAllCurrencies_4,Input.searchAllCurrencies(testAllCurrencies, "da"));
        Assert.assertArrayEquals(testSearchAllCurrencies_5,Input.searchAllCurrencies(testAllCurrencies, "dinar"));
    }

    @Test
    public void TestCalculateNewCurrency() throws IOException{
        double[] testAllExchangeRates = Arrays.stream(Input.splitArray(Input.readLines("currencys.txt"), 1)).mapToDouble(Double::parseDouble).toArray();
        String[] testAllCurrencies = Input.splitArray(Input.readLines("currencys.txt"), 0);

        Assert.assertEquals(5.72, Input.CalculateNewCurrency(1, 4, 5.00, testAllCurrencies, testAllExchangeRates), 0.001);
        Assert.assertEquals(0.07, Input.CalculateNewCurrency(5, 3, 10.00, testAllCurrencies, testAllExchangeRates), 0.001);
        Assert.assertEquals(2.66, Input.CalculateNewCurrency(21, 6, 7.00, testAllCurrencies, testAllExchangeRates), 0.001);
        Assert.assertEquals(554.37, Input.CalculateNewCurrency(7, 18, 3.00, testAllCurrencies, testAllExchangeRates), 0.001);
        Assert.assertEquals(0.01, Input.CalculateNewCurrency(13, 1, 20.00, testAllCurrencies, testAllExchangeRates), 0.001);
        Assert.assertEquals(1298.52, Input.CalculateNewCurrency(0, 50, 14.00, testAllCurrencies, testAllExchangeRates), 0.001);
    }
}
