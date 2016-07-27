package rys.calculogalonaje.app;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;


/**
 * Created by User on 21/01/2016.
 */
public class Tabla13Test {

    @Test
    public void GalonajeMenorACeroEsIgualACero() throws IOException, XmlPullParserException {

        Tabla13 tabla13 = new Tabla13();
        tabla13.setApi(20);
        tabla13.setPesoNeto(-2000);

        Assert.assertTrue(tabla13.CalcularGalonaje() == 0);
    }

    @Test
    public void FactorNoexisteRetornaExcepcion()
    {
        Tabla13 tabla13 = new Tabla13();
        tabla13.setApi(-1);
        tabla13.setPesoNeto(2000);

        try
        {
            tabla13.CalcularGalonaje();
        }
        catch (IllegalArgumentException ex)
        {

        }
    }
}
