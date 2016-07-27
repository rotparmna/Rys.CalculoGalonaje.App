package rys.calculogalonaje.app;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Pattern;

/**
 * Created by User on 21/01/2016.
 */
public class Redondeo {
    private double _valor;

    public Redondeo(double valor) {
        this._valor = valor;
    }

    public double EliminarParteEntera() {
        //char separadorDecimal =((DecimalFormat) NumberFormat.getInstance()).getDecimalFormatSymbols().getDecimalSeparator();
        char separadorDecimal = '.';
        int parteEntera = Integer.parseInt(Double.toString(this._valor).split(Pattern.quote(Character.toString(separadorDecimal)))[0]);
        CorregirDecimal corregir = new CorregirDecimal(separadorDecimal);

        String redondeo = String.format("%.2f", (_valor - parteEntera));
        redondeo = corregir.CambiarDecimal(redondeo);

        return Double.parseDouble(redondeo);
    }

    public void Redondear() {
        char separadorDecimal = '.';
        CorregirDecimal corregir = new CorregirDecimal(separadorDecimal);
        double decimalesParteEnteraCero = EliminarParteEntera();
        this._valor = this._valor - decimalesParteEnteraCero;
        if (decimalesParteEnteraCero >= 0.5)
            this._valor =this. _valor + 1;

        String redondeo = String.format("%.2f", this._valor);
        redondeo = corregir.CambiarDecimal(redondeo);

        this._valor = Double.parseDouble(redondeo);
    }

    @Override
    public String toString() {
        return Double.toString(this._valor);
    }
}
