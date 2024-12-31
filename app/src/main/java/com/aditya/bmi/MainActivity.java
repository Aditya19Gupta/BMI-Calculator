package com.aditya.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent nextIntent;
        nextIntent = new Intent(MainActivity.this, ResultActivity.class);
        Button button = findViewById(R.id.materialButton);
        TextInputEditText heightIn = findViewById((R.id.ageField));
        TextInputEditText weight = findViewById((R.id.weightField));
        TextInputEditText height = findViewById((R.id.heightField));
        TextView result = findViewById(R.id.result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int heightInText = Integer.parseInt(String.valueOf(heightIn.getText()));
                int weightText = Integer.parseInt(String.valueOf(weight.getText()));
                int heightText = Integer.parseInt(String.valueOf(height.getText()));

                int totalIn = heightText*12 + heightInText;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;
                double bmi = weightText/(totalM*totalM);
                nextIntent.putExtra("bmiValue",bmi);
                startActivity(nextIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out);

            }
        });


    }
}