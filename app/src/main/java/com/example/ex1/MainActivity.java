package com.example.ex1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // TODO: définition d'une catégorie de messages
    // TODO : affiche la console logcat et filter
    //  suivant les occurrences du mot-clé "pmr2024"
    private static final String PMR = "pmr2024";
    Button refBtnOK;
    EditText refEdtNom;

    void alerter(String s) {
        Log.i(PMR, s);

        Toast myToast = Toast.makeText(this,s,Toast.LENGTH_LONG);
        myToast.show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: affichage d'un message
        //alerter("onCreate");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        refBtnOK= findViewById(R.id.button);
        refEdtNom= findViewById(R.id.edtNom);

        refBtnOK.setOnClickListener(this);
        refEdtNom.setOnClickListener(this);
    /*
        refBtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerter("onclick2");
            }
        });

     */
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        alerter("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        alerter("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        alerter("onResume");
    }


    @Override
    public void onClick(View view) {
        // NB: on ne peut plus utiliser switch car les identifiants ne sont pas des constantes
        // https://stackoverflow.com/questions/51401999/how-to-solve-error-resource-ids-cannot-be-used-in-switch-statement-in-android
        if (view.getId() == R.id.edtNom) {
            //alerter("click sur edt");
        } else if (view.getId() == R.id.button) {
            alerter("contenu : " + refEdtNom.getText().toString());
            // TODO: changer d'activité lors du clic sur le bouton
            Intent myIntent;
            myIntent = new Intent(MainActivity.this,MainActivity2.class);
            Bundle bdlData = new Bundle();
            bdlData.putString("pseudo",refEdtNom.getText().toString());
            myIntent.putExtras(bdlData);
            startActivity(myIntent);


        }

    }

    /*
    public void foo(View view) {
        alerter("click");
    }
    */
}