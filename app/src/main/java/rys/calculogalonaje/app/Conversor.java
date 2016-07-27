package rys.calculogalonaje.app;

import static rys.calculogalonaje.app.Conversiones.GalonAmericanoABarrilAmericano;

/**
 * Created by User on 21/01/2016.
 */
public class Conversor {
    private final double FactorGalonAmericanoBarrilAmericano = 42;
    private Conversiones _tipo;

    public void setTipo(Conversiones tipo){
        this._tipo = tipo;
    }

    public int Convertir(int valorAConvertir) {
        double resultado = 0;
        switch (this._tipo)
        {
            case None:
                break;
            case GalonAmericanoABarrilAmericano:
                resultado = valorAConvertir / FactorGalonAmericanoBarrilAmericano;
                break;
            default:
                break;
        }

        Redondeo redondear = new Redondeo((double)resultado);
        redondear.Redondear();
        double cadenaValorRedondeado = Double.parseDouble(redondear.toString());
        return (int)cadenaValorRedondeado;
    }
}
