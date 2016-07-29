package rys.calculogalonaje2.app;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by User on 21/01/2016.
 */
public class ApiTests {
    @Test
    public void AgregarDecimalAValorEntero()
    {
        String APIsinDecimal = "20";
        API agregarDecimal = new API(APIsinDecimal);

        Assert.assertTrue(agregarDecimal.getAPI().equals("20.0"));
    }

    @Test
    public void AgregarDecimalAValorConDecimal()
    {
        String APIconDecimal = "20.0";
        API agregarDecimal = new API(APIconDecimal);

        Assert.assertTrue(agregarDecimal.getAPI().equals("20.0"));
    }

    @Test
    public void CorregirAPIConPunto()
    {
        String APIsinDecimalConError = "20.";

        API agregarDecimal = new API(APIsinDecimalConError);

        Assert.assertTrue(agregarDecimal.getAPI().equals("20.0"));
    }
}
