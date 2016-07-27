package rys.calculogalonaje.app;

/**
 * Created by User on 28/01/2016.
 */
public class CorregirDecimal {
    private final char _decimal;

    public CorregirDecimal(char decimal) {
        this._decimal = decimal;
    }

    public String CambiarDecimal(String valorConComa) {
        return valorConComa.replace(',', this._decimal);
    }
}
