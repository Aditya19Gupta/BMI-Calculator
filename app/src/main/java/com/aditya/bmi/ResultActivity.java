package com.aditya.bmi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.resultMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("bmiValue",0);
        LinearLayout linearLayout = findViewById(R.id.resultMain);
        MaterialButton button = findViewById(R.id.result);
        if(bmi > 25){
            linearLayout.setBackgroundColor(Color.parseColor("#85050a"));
            button.setText("Overweight");
        }
        else if(bmi < 18){
            linearLayout.setBackgroundColor(Color.parseColor("#888f03"));
            button.setText("Underweight");
        }else{
            linearLayout.setBackgroundColor(Color.parseColor("#035e20"));
            button.setText("Fit");
        }
        ListView listView = findViewById(R.id.list_of_names);
        ArrayList<String> names = new ArrayList<>();

        // Add exactly 50 names to the ArrayList
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Eva");
        names.add("Frank");
        names.add("Grace");
        names.add("Hannah");
        names.add("Ivy");
        names.add("Jack");
        names.add("Kathy");
        names.add("Leo");
        names.add("Megan");
        names.add("Nathan");
        names.add("Olivia");
        names.add("Paul");
        names.add("Quincy");
        names.add("Rachel");
        names.add("Sam");
        names.add("Tina");
        names.add("Ursula");
        names.add("Victor");
        names.add("Wendy");
        names.add("Xander");
        names.add("Yvonne");
        names.add("Zack");
        names.add("Amber");
        names.add("Brandon");
        names.add("Cindy");
        names.add("Derek");
        names.add("Ella");
        names.add("Felix");
        names.add("Gina");
        names.add("Henry");
        names.add("Iris");
        names.add("Jacob");
        names.add("Kylie");
        names.add("Liam");
        names.add("Mia");
        names.add("Noah");
        names.add("Oscar");
        names.add("Penny");
        names.add("Quinn");
        names.add("Riley");
        names.add("Sophia");
        names.add("Tom");
        names.add("Uma");
        names.add("Violet");
        names.add("Will");
        names.add("Xena");
        names.add("Yasmin");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);
        Animation animation = AnimationUtils.loadAnimation(ResultActivity.this,R.anim.zoom_anim);
        button.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animationArg) {
                // Optionally disable the button during the animation
                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        //SPINNER DEMO
        Spinner spinner = findViewById(R.id.list_ids);
        ArrayList<String> idsList  = new ArrayList<>();
        idsList.add("Adhaar");
        idsList.add("Passport");
        idsList.add("Rasan");
        idsList.add("10 Marksheet");
        idsList.add("12 Marksheet");
        idsList.add("PAN");
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,idsList);
        spinner.setAdapter(spinnerAdapter);

        //auto complete list view
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.tech_list);
        ArrayList<String> techList  = new ArrayList<>();
        techList.add("Java");
        techList.add("Spring MVC");
        techList.add("Python");
        techList.add("Spring Boot");
        techList.add("Django");
        techList.add("JS");
        ArrayAdapter<String> autoAdaptor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,techList);
        autoCompleteTextView.setAdapter(autoAdaptor);
        autoCompleteTextView.setThreshold(2);
    }
}