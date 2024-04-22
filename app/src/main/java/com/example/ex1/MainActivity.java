package com.example.ex1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // TODO: définition d'une catégorie de messages
    // TODO : affiche la console logcat et filter
    //  suivant les occurrences du mot-clé "pmr2024"
    private static final String PMR = "pmr2024";

    void alerter(String s) {
        Log.i(PMR, s);

        Toast myToast = Toast.makeText(this,s,Toast.LENGTH_LONG);
        myToast.show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: affichage d'un message
        alerter("onCreate");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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
}