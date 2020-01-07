package de.hdm_stuttgart.mi.se1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test of {@Input}.
 */
public class InputTest {

    @Test
    public void TestGetInput(){
        //Keine Ahnung, wie man Scanner-Inputs testen kann :P
        //Wenn ihr wisst wie, dann probierts einfach aus
    }

    @Test
    public void TestCalculateNewCurrency()
    {
        Assert.assertEquals(5.59d, Input.CalculateNewCurrency(1, 4, 5d), 0.001);
        Assert.assertEquals(0, Input.CalculateNewCurrency(0, 0, 0), 0.001);
        Assert.assertEquals(0, Input.CalculateNewCurrency(0, 0, 0), 0.001);
        Assert.assertEquals(0, Input.CalculateNewCurrency(0, 0, 0), 0.001);
        Assert.assertEquals(0, Input.CalculateNewCurrency(0, 0, 0), 0.001);
        Assert.assertEquals(0, Input.CalculateNewCurrency(0, 0, 0), 0.001);
    }
}
