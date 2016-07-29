package rys.calculogalonaje2.app;

/**
 * Created by Michael Navarro Ariza on 21/01/2016.
 */
public class Tabla13 {
    private double _api;
    private double _pesoNeto;
    private double _factor;

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

    public Tabla13()   {       }

    public double CalcularGalonaje()
    {
        this._factor = (22.4780262/(131.5+this._api)-0.00019526137)*23.8095238095238; //Formula dada por Jacob Lemus
        double galonaje;
        galonaje = this._pesoNeto / this._factor;
        return galonaje < 0 ? 0 : galonaje;
    }
}
