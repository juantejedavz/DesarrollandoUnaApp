package mx.blogspot.juanmtejedav.desarrollandounaapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnSiguienteJ;
    private Button btnFechaN;
    private EditText etNombreCJ;
    private EditText etEmailJ;
    private EditText etTelefonoJ;
    private EditText etDescripcionJ;
    String fecha;
    int year, month, day;
    static final int DIALOG_ID = 0;
    final Calendar cal = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViewsIDs();

        //Date Picker
        year = cal.get(Calendar.YEAR);
        onPressFechaBtn();

        //Child Detail for introduced data viewing detail
        toDetail();
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID)
            return new DatePickerDialog(this, datePickerListener, year, month, day);
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i0, int i1, int i2) {
            year = i0;
            month = i1 + 1;
            day = i2;
            fecha = day + "/" + month + "/" + year;
        }
    };


    private void getViewsIDs() {
        //Assign-Relate Buttons and EditText Objects to XML
        btnSiguienteJ = (Button) findViewById(R.id.BT_siguiente);
        btnFechaN = (Button) findViewById(R.id.BT_fechaNacimiento);
        etNombreCJ = (EditText) findViewById(R.id.ET_NombreCompleto);
        etEmailJ = (EditText) findViewById(R.id.ET_email);
        etTelefonoJ = (EditText) findViewById(R.id.ET_Telefono);
        etDescripcionJ = (EditText) findViewById(R.id.ET_descripcionContacto);
    }

    private void onPressFechaBtn() {
        btnFechaN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
            }
        });
    }

    private void toDetail() {
        btnSiguienteJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detalleActividad = new Intent(MainActivity.this, DatosIntroducidos.class);
                detalleActividad.putExtra("NombreCompleto", etNombreCJ.getText().toString());
                detalleActividad.putExtra("Fecha", "Fecha de nacimiento: " + fecha);
                detalleActividad.putExtra("Email", "Email: " + etEmailJ.getText().toString());
                detalleActividad.putExtra("Telefono", "Tel. " + etTelefonoJ.getText().toString());
                detalleActividad.putExtra("Descripcion", "Descripción: " + etDescripcionJ.getText().toString());
                startActivity(detalleActividad);
            }
        });
    }
}
