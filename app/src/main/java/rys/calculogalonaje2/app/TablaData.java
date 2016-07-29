package rys.calculogalonaje2.app;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by User on 21/01/2016.
 */
public interface TablaData {
    double ObtenerFactor(String api) throws XmlPullParserException, IOException;
}
