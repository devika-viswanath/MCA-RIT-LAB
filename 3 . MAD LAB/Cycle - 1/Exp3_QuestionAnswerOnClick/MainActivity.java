//Develop an android mobile application to display some Question and answer  in text boxes when a button event occurs.
//Set some questions in Text Views and display corresponding answers when a Button click event happens.
package com.example.quesandans;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvAnswer1, tvAnswer2;
    Button btnShowAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAnswer1 = findViewById(R.id.tvAnswer1);
        tvAnswer2 = findViewById(R.id.tvAnswer2);
        btnShowAnswers = findViewById(R.id.btnShowAnswers);

        btnShowAnswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvAnswer1.setText("A1: Android is an open-source mobile OS.");
                tvAnswer2.setText("A2: Android was developed by Android Inc., later acquired by Google.");
            }
        });
    }
}
