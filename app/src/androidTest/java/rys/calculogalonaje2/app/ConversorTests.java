package rys.calculogalonaje2.app;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by User on 21/01/2016.
 */
public class ConversorTests {

    @Test
    public void ConvertirGalonesABarriles()    {
        int galones = 20000;
        int valorEsperado = 476;
        Conversor conversor = new Conversor();
        conversor.setTipo(Conversiones.GalonAmericanoABarrilAmericano);

        int valorActual = conversor.Convertir(galones);

        Assert.assertEquals(valorEsperado, valorActual);
    }

    @Test
    public void ConvertirGalonesABarrilesConDecimalMayorACinco()
    {
        int galones = 671;
        int valorEsperado = 16;
        Conversor conversor = new Conversor();
        conversor.setTipo(Conversiones.GalonAmericanoABarrilAmericano);

        int valorActual = conversor.Convertir(galones);

        Assert.assertEquals(valorEsperado, valorActual);
    }
}
