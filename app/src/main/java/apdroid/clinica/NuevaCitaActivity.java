package apdroid.clinica;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by AngeloPaulo on 01/septiembre/2015.
 */
public class NuevaCitaActivity extends AppCompatActivity {

    ArrayAdapter<String> aaEspecialidad, aaDoctor, aaHorario, aaClear;
    String[] opEspecialidad = new String[]{"Cardiologia", "Reumatologia", "Oftalmologia"};
    String[] opDoctor = new String[]{"Dr.Alvarez", "Dr.Vera", "Dra.Stegui"};
    String[] opHorario = new String[]{"8:00-9:00", "9:00-10:00", "10:00-11:00"};
    String[] opClear = new String[0];
    Calendar calendario = Calendar.getInstance();
    AdapterView.OnItemSelectedListener spEspOnItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    spDoctor.setAdapter(aaDoctor);
                    break;
                case 1:
                    spDoctor.setAdapter(aaClear);
                    break;
                case 2:
                    spDoctor.setAdapter(aaClear);
                    break;

            }


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    AdapterView.OnItemSelectedListener spDoctorOnItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    spHorario.setAdapter(aaHorario);
                    break;
                case 1:
                    spHorario.setAdapter(aaClear);
                    break;
                case 2:
                    spHorario.setAdapter(aaClear);
                    break;

            }


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            spHorario.setAdapter(aaClear);

        }
    };
    View.OnClickListener btCalendarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            setFecha();

        }
    };
    //private EditText etFecha;
    private TextView tvFecha;
    private ImageButton btCalendar;
    private Spinner spEspecialidad, spDoctor, spHorario;
    //DateFormat formatoFecha=DateFormat.getDateInstance();
    private SimpleDateFormat formatoFecha;
    DatePickerDialog.OnDateSetListener dpFechaOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            calendario.set(Calendar.YEAR, year);
            calendario.set(Calendar.MONTH, monthOfYear);
            calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateFecha();

        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevacita);

        //etFecha=(EditText)findViewById(R.id.etFecha);
        tvFecha = (TextView) findViewById(R.id.etFecha);
        btCalendar = (ImageButton) findViewById(R.id.btCal);
        spEspecialidad = (Spinner) findViewById(R.id.spEspecialidad);
        spDoctor = (Spinner) findViewById(R.id.spDoctor);
        spHorario = (Spinner) findViewById(R.id.spHorario);


        spEspecialidad.setOnItemSelectedListener(spEspOnItemSelectedListener);
        spDoctor.setOnItemSelectedListener(spDoctorOnItemSelectedListener);
        btCalendar.setOnClickListener(btCalendarOnClickListener);

        formatoFecha = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);

        aaEspecialidad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opEspecialidad);
        aaDoctor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opDoctor);
        aaHorario = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opHorario);
        aaClear = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opClear);

        spEspecialidad.setAdapter(aaEspecialidad);

    }

    //--------------------------------------------------------------------------------------------
    //  CALENDAR   -------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------
    // Para Visualizar la Fecha en el Edit Text
    public void updateFecha() {
        tvFecha.setText(formatoFecha.format(calendario.getTime()));

    }

    public void setFecha() {
        new DatePickerDialog(NuevaCitaActivity.this, dpFechaOnDateSetListener,
                calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH),
                calendario.get(Calendar.DAY_OF_MONTH)).show();
    }
    //--------------------------------------------------------------------------------------------
    //  CALENDAR   -------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------

}
