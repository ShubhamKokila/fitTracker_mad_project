
package com.anoop.healthchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.snackbar.Snackbar;

public class Bodyfat extends AppCompatActivity {

    private double height;
    private double neck;
    private double abdomen;
    private double bodyFat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyfat);
        getSupportActionBar().setTitle("FIT TRACKER");


//        if (getSupportActionBar() != null) {
//            getSupportActionBar().hide();
//        }


        EditText hei = findViewById(R.id.height);
        EditText ne = findViewById(R.id.neck);
        EditText abd = findViewById(R.id.abdomen);
        Button calculateButton = findViewById(R.id.button);
        TextView resultView = findViewById(R.id.result2);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the user's input

                String heightStr = hei.getText().toString();
                String neckStr = ne.getText().toString();
                String abdStr = abd.getText().toString();




                if (TextUtils.isEmpty(heightStr) && TextUtils.isEmpty(neckStr) && TextUtils.isEmpty(abdStr) ){
                    Snackbar snackbar = Snackbar.make(view, "Enter correct values", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    resultView.setText("");

                }else{

                    height = Double.parseDouble(heightStr);
                    neck = Double.parseDouble(neckStr);
                    abdomen = Double.parseDouble(abdStr);


                    // Perform the body fat calculation

                bodyFat =86.010 * Math.log10(abdomen - neck) - 70.041 * Math.log10(height) + 36.76;

                // Display the result


                resultView.setText(bodyFat+"%");

                Snackbar snackbar = Snackbar.make(view, "Your body fat is  " + bodyFat+"%", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
            }
        });



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

    }
}

//86.010 x log10 (abdomen – neck) – 70.041 x log10 (height) + 36.76