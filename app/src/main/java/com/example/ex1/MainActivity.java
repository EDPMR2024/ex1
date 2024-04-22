package com.example.ex1;

import android.annotation.SuppressLint;
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
        //alerter("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //alerter("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //alerter("onResume");
    }


    @Override
    public void onClick(View view) {
        alerter(Integer.toString(view.getId()));
        /*switch(view.getId()) {
            case R.id.edtNom:
                alerter("click sur edt");
                break;

            case R.id.button:
                alerter("click sur bouton");
                break;

        }*/
    }

    /*
    public void foo(View view) {
        alerter("click");
    }
    */
}