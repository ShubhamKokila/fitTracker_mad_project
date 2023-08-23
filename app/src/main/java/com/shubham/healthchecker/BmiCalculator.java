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

import java.text.DecimalFormat;

public class BmiCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);
        getSupportActionBar().setTitle("FIT TRACKER");

//        if (getSupportActionBar() != null) {
//            getSupportActionBar().hide();
//        }

        Button button = findViewById(R.id.button);

        EditText heightText = findViewById(R.id.height);
        EditText weightText = findViewById(R.id.weight);
        TextView BMICategory = findViewById(R.id.bmiCat);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightStr = heightText.getText().toString();
                String weightStr = weightText.getText().toString();
                TextView BMIResult = findViewById(R.id.result);



                if (TextUtils.isEmpty(heightStr) && TextUtils.isEmpty(weightStr) ){
                    BMICategory.setText("Enter correct values");
                    Snackbar snackbar = Snackbar.make(v, "Enter values ", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else {

                    double height = Double.parseDouble(heightStr);
                    double heightM = height/100;
                    double weight = Double.parseDouble(weightStr);

                    double BMI = (weight) / (heightM * heightM);
                    DecimalFormat df = new DecimalFormat("#.#");
                    double BMI_trimmed = Double.parseDouble(df.format(BMI));
                    BMIResult.setText(Double.toString(BMI_trimmed));
                    String BMI_Cat;
                    if (BMI < 15) {
                        BMI_Cat = "Very severely underweight";
                    } else if (BMI >= 15 && BMI < 16) {
                        BMI_Cat = "Severely underweight";
                    } else if (BMI >= 16 && BMI < 18.5) {
                        BMI_Cat = "Underweight";
                    } else if (BMI >= 18.5 && BMI < 25) {
                        BMI_Cat = "Normal";
                    } else if (BMI >= 25 && BMI < 30) {
                        BMI_Cat = "Overweight";
                    } else if (BMI >= 30 && BMI < 35) {
                        BMI_Cat = "Obese Class 1 - Moderately Obese";
                    } else if (BMI >= 35 && BMI < 40) {
                        BMI_Cat = "Obese Class 2 - Severely Obese";
                    } else {
                        BMI_Cat = "Obese Class 3 - Very Severely Obese";

                    }
                    BMICategory.setText(BMI_Cat);


                    Snackbar snackbar = Snackbar.make(v, "You are " + BMI_Cat, Snackbar.LENGTH_LONG);
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