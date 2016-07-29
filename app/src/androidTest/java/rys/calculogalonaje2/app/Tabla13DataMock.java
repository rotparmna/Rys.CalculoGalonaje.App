package rys.calculogalonaje2.app;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by User on 21/01/2016.
 */
public class Tabla13DataMock implements TablaData {
    @Override
    public double ObtenerFactor(String api) throws XmlPullParserException, IOException {
        if (api.equals("-1"))
            throw new  IllegalArgumentException("El factor no se encuentra para el API " + api);
        return 4.0653;
    }
}
