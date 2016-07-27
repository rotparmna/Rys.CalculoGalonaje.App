package rys.calculogalonaje.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final EditText txtPesoNeto = (EditText) findViewById(R.id.txtPesoNeto);
        final EditText txtAPI = (EditText) findViewById(R.id.txtAPI);
        Button btnCalcularGalon = (Button) findViewById(R.id.btnCalcularGalon);
        final TextView txtGalones = (TextView) findViewById(R.id.txtGalones);
        final TextView txtBarriles = (TextView) findViewById(R.id.txtBarriles);

        btnCalcularGalon.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View v) {
                                                    // Perform action on click
                                                    AssetManager assets = getAssets();

                                                    InputStream xml = null;
                                                    try {
                                                        xml = assets.open("tabla13.xml");
                                                    } catch (IOException e) {
                                                        e.printStackTrace();
                                                    }
                                                    TablaData tabla13Data = new Tabla13Data(xml);
                                                    Tabla13 tabla13 = new Tabla13(tabla13Data);
                                                    API api = new API(txtAPI.getText().toString());

                                                    txtAPI.setText(api.getAPI());

                                                    tabla13.setPesoNeto(Double.parseDouble(txtPesoNeto.getText().toString()));
                                                    tabla13.setApi(Double.parseDouble(txtAPI.getText().toString()));

                                                    double galones = -1;
                                                    try {
                                                        galones = tabla13.CalcularGalonaje();
                                                    } catch (IllegalArgumentException ex) {
                                                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                        AlertDialog alertDialog = builder.create();
                                                        alertDialog.setTitle("Mensaje");
                                                        alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                                                        Object[] argMensaje = {txtAPI.getText().toString()};
                                                        MessageFormat mensaje = new MessageFormat(getResources().getString(R.string.MensajeFactorNoEncontrado));
                                                        alertDialog.setMessage(mensaje.format(argMensaje));
                                                        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                dialog.cancel();
                                                            }
                                                        });
                                                        alertDialog.show();
                                                    }

                                                    if (galones !=-1) {

                                                        Redondeo redondeo = new Redondeo(galones);
                                                        redondeo.Redondear();

                                                        Conversor conversor = new Conversor();
                                                        conversor.setTipo(Conversiones.GalonAmericanoABarrilAmericano);
                                                        int barriles = conversor.Convertir((int)Double.parseDouble(redondeo.toString()));

                                                        txtGalones.setText(redondeo.toString());
                                                        txtBarriles.setText(String.valueOf(barriles));
                                                    }

                                                }
                                            }
        );

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://rys.calculogalonaje.app/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://rys.calculogalonaje.app/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
