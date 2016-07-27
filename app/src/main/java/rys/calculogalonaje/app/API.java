package rys.calculogalonaje.app;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Pattern;

/**
 * Created by User on 21/01/2016.
 */
public class API {
    private String _api;

    public API(String api) {
        this._api = api;

        CorregirAPI();
    }

    private void CorregirAPI() {
        //char separadorDecimal =((DecimalFormat) NumberFormat.getInstance()).getDecimalFormatSymbols().getDecimalSeparator();
        char separadorDecimal = '.';
        String[] api = this._api.split(Pattern.quote(Character.toString(separadorDecimal)));
        if (api.length == 1) {
            this._api = api[0].concat(".0");
        }
    }

    public String getAPI() {
        return this._api;
    }
}
