package com.example.angel.practica4;

import android.app.Dialog;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, frag1.OnFragmentInteractionListener, frag2.OnFragmentInteractionListener{
    Button btnfrag1, btnfrag2, bot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnfrag1 = (Button)findViewById(R.id.fragmento1);
        btnfrag2 = (Button)findViewById(R.id.fragmento2);
        btnfrag2.setOnClickListener(this);
        btnfrag1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.fragmento1:
                frag1 fragmento1 = new frag1();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.contenedor, fragmento1);
                transaction1.commit();
                break;
            case R.id.fragmento2:
                frag2 fragmento2 = new frag2();
                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.contenedor, fragmento2);
                transaction2.commit();
                break;

        }


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.men, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.opcionlogin:
                Dialog dialogologin = new Dialog(MainActivity.this);
                dialogologin.setContentView(R.layout.dlg_login);


                bot = (Button) dialogologin.findViewById(R.id.btnauten);
                final EditText cajausuario = (EditText) dialogologin.findViewById(R.id.txtusuario);
                final EditText cajauclave = (EditText) dialogologin.findViewById(R.id.txtcontra);

                bot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, cajausuario.getText().toString() + " " + cajauclave.getText().toString(), Toast.LENGTH_SHORT);
                    }
                });

                dialogologin.show();
                break;
            case R.id.opcionregistro:
                
        }

        return true;
    }
}
