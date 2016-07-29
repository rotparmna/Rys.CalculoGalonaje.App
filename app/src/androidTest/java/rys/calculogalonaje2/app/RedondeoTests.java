package rys.calculogalonaje2.app;


import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by User on 21/01/2016.
 */
public class RedondeoTests {

    @Test
    public void EliminarParteEnteraDejandolaEnCero()
    {
        double galonaje = 239.5;

        Redondeo redondeo = new Redondeo(galonaje);

        Assert.assertTrue(redondeo.EliminarParteEntera() == 0.5);
    }

    @Test
    public void RedondeConDecimalIgualACinco()
    {
        double galonaje = 239.5;
        Redondeo redondeo = new Redondeo(galonaje);

        redondeo.Redondear();

        Assert.assertTrue(redondeo.toString().equals("240.0"));
    }

    @Test
    public void RedondeConDecimalMayorACinco()
    {
        double galonaje = 239.62;
        Redondeo redondeo = new Redondeo(galonaje);

        redondeo.Redondear();

        Assert.assertTrue(redondeo.toString().equals("240.0"));
    }

    @Test
    public void RedondeConDecimalMenorACinco()
    {
        double galonaje = 239.44;
        Redondeo redondeo = new Redondeo(galonaje);

        redondeo.Redondear();

        Assert.assertTrue(redondeo.toString().equals("239.0"));
    }

    @Test
    public void RedondeConCero()
    {
        double galonaje = 0;
        Redondeo redondeo = new Redondeo(galonaje);

        redondeo.Redondear();

        Assert.assertTrue(redondeo.toString().equals("0.0"));
    }
}
