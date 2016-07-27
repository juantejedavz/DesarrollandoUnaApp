package mx.blogspot.juanmtejedav.desarrollandounaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;

public class MainActivity extends AppCompatActivity {

    String nombreCompletoJ= getString(R.string.nombreCompleto);
    String emailJ= getString(R.string.email);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void intentToDetail(View v){
        Intent detalleActividad = new Intent(MainActivity.this, .class);
        detalleActividad.putExtra(KEY_EXTRA_NAME, nombreCompletoJ);
        Adapter
        startActivity(detalleActividad);
        finish();
    }
}
