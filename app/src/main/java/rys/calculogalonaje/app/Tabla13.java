package rys.calculogalonaje.app;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by User on 21/01/2016.
 */
public class Tabla13 {
    private double _api;
    private double _pesoNeto;
    private double _factor;
    private TablaData _tabla13Data;

    public double getApi(){
        return this._api;
    }

    public void setApi(double api){
        this._api = api;
    }

    public double getPesoNeto(){
        return this._api;
    }

    public void setPesoNeto(double pesoNeto){
        this._pesoNeto = pesoNeto;
    }

    public Tabla13(TablaData tabla13Data)
    {
        this._tabla13Data = tabla13Data;
    }

    public double CalcularGalonaje()
    {
        try {
            this._factor = (double)this._tabla13Data.ObtenerFactor(String.valueOf(this._api));
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        double galonaje = 0;
        galonaje = this._pesoNeto / this._factor;
        return galonaje < 0 ? 0 : galonaje;
    }
}
