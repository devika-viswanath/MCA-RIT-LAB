package com.example.sharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//Declaration
//    EditText etUsername, etAge;
//    Button btnSave;
//    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare + initialize in one line
        EditText etUsername = findViewById(R.id.etUsername);
        EditText etAge = findViewById(R.id.etAge);
        Button btnSave = findViewById(R.id.btnSave);
        TextView tvResult = findViewById(R.id.tvResult);

        // SharedPreferences object
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Load saved data
        String name = prefs.getString("username", "");
        int age = prefs.getInt("age", 0);
        if (!name.isEmpty()) {
            tvResult.setText("Username: " + name + "\nAge: " + age);
        }

        // Save button click
        btnSave.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            int userAge = Integer.parseInt(etAge.getText().toString());

            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("username", username);
            editor.putInt("age", userAge);
            editor.apply();

            tvResult.setText("Username: " + username + "\nAge: " + userAge);
        });
    }
}
