package rys.calculogalonaje2.app;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;

/**
 * Created by Sairamkrishna on 4/11/2015.
 */
public class ManejoTabla13Xml {
    private final InputStream _archivoXml;
    private String api;
    private String factor;
    private XmlPullParserFactory _xmlFactoryObject;
    XmlPullParser _myparser;
    public volatile boolean _terminoRecorrido = false;

    public ManejoTabla13Xml(InputStream archivoXml){
        this._archivoXml = archivoXml;
        this.api="";
        this.factor="";
        this.Inicializar();
    }

    private void Inicializar() {
        try {
            _xmlFactoryObject = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        try {
            _myparser = _xmlFactoryObject.newPullParser();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        try {
            _myparser.setInput(this._archivoXml, null);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    public String getApi(){
        return api;
    }

    public String getFactor(){
        return factor;
    }

    public boolean getTerminoRecorrido(){
        return this._terminoRecorrido;
    }

    public void BuscarFactor(String apiABuscar) {
        int event;
        String text = null;

        try {
            event = _myparser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT && !_terminoRecorrido) {
                String name=_myparser.getName();

                switch (event){
                    case XmlPullParser.START_TAG:
                        if(name.equals("api")){
                            api = _myparser.getAttributeValue(null,"value");
                            if (api.equals(apiABuscar)) {
                                factor = "";
                            }
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = _myparser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if(name.equals("factor")){
                            factor = text;
                        }

                        break;
                }
                _terminoRecorrido = !factor.equals("") && api.equals(apiABuscar);
                event = _myparser.next();
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
