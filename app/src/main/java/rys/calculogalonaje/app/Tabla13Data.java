package rys.calculogalonaje.app;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by User on 21/01/2016.
 */
public class Tabla13Data implements TablaData {

    private InputStream _archivoXml;

    public Tabla13Data(InputStream archivoXml){
        this._archivoXml = archivoXml;
    }

    @Override
    public double ObtenerFactor(String api) throws XmlPullParserException, IOException {
        double factor=-1;

        ManejoTabla13Xml xml = new ManejoTabla13Xml(this._archivoXml);
        xml.BuscarFactor(api);
        if (xml.getTerminoRecorrido()) {
            factor = Double.parseDouble(xml.getFactor());
        }
        else
            throw new java.lang.IllegalArgumentException(api);

        return factor;
    }
}
