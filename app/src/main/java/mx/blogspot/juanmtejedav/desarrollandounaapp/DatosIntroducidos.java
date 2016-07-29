package mx.blogspot.juanmtejedav.desarrollandounaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosIntroducidos extends AppCompatActivity {

    private Button btnEditarDJ;
    private TextView tvNombreJ;
    private TextView tvFechaN;
    private TextView tvEmailJ;
    private TextView tvTelefonoJ;
    private TextView tvDescripcionJ;
    private Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_introducidos);

        getViewIDs();

        setTextViewsWithExtras();

        toMain();
    }


    private void getViewIDs() {
        btnEditarDJ = (Button) findViewById(R.id.BT_editarDatos);
        tvNombreJ = (TextView) findViewById(R.id.TV_nombreCompleto);
        tvFechaN = (TextView) findViewById(R.id.TV_fechaN);
        tvEmailJ = (TextView) findViewById(R.id.TV_email);
        tvTelefonoJ = (TextView) findViewById(R.id.TV_telefono);
        tvDescripcionJ = (TextView) findViewById(R.id.TV_descripcion);
    }

    private void setTextViewsWithExtras() {
        extras = getIntent().getExtras();
        tvNombreJ.setText(extras.getString("NombreCompleto"));
        tvFechaN.setText(extras.getString("Fecha"));
        tvEmailJ.setText(extras.getString("Email"));
        tvTelefonoJ.setText(extras.getString("Telefono"));
        tvDescripcionJ.setText(extras.getString("Descripcion"));
    }

    private void toMain() {
        btnEditarDJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}