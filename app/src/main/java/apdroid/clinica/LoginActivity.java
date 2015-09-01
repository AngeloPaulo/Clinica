package apdroid.clinica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText etUser, etPass;
    Button btIngresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);
        btIngresar = (Button) findViewById(R.id.btIngresar);
        btIngresar.setOnClickListener(btIngresarOnClickListener);



    }

    View.OnClickListener btIngresarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String user = etUser.getText().toString();
            String pass = etPass.getText().toString();

            if (user.equalsIgnoreCase("Angelo") && pass.equalsIgnoreCase("qwerty")) {
                Intent i=new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(i);
            }else{
                Toast.makeText(getApplicationContext(), "Ups !!!", Toast.LENGTH_LONG).show();
            }



        }
    };








}
