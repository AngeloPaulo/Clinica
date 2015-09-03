package apdroid.clinica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/** ok
 * Created by AngeloPaulo on 28/agosto/2015.
 */
public class MenuActivity extends AppCompatActivity {

    Button btNuevaCita;
    View.OnClickListener btNuevaCitaOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent i2 = new Intent(getApplicationContext(), NuevaCitaActivity.class);
            btNuevaCita.setBackgroundColor(123456);
            startActivity(i2);

        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btNuevaCita = (Button) findViewById(R.id.btNuevaCita);
        btNuevaCita.setOnClickListener(btNuevaCitaOnClickListener);


}

}
