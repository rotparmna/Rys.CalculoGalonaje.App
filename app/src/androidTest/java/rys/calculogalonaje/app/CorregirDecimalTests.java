package rys.calculogalonaje.app;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by User on 28/01/2016.
 */
public class CorregirDecimalTests {
    
    @Test
    public void CambiarComaPorPunto(){
        String valorConComa = "20,1";

        CorregirDecimal corregir = new CorregirDecimal('.');

        Assert.assertTrue(corregir.CambiarDecimal(valorConComa).equals("20.1"));
    }
}
