package com.example.sharedprefexample;  // Make sure this matches your app's package!

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etAge;
    Button btnSave;
    TextView tvDisplay;

    SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "user_prefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_AGE = "age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // R.layout refers to your layout xml

        etUsername = findViewById(R.id.etUsername);
        etAge = findViewById(R.id.etAge);
        btnSave = findViewById(R.id.btnSave);
        tvDisplay = findViewById(R.id.tvDisplay);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        loadData();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { saveData(); }
        });
    }

    private void saveData() {
        String username = etUsername.getText().toString();
        String age = etAge.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_AGE, age);
        editor.apply();

        tvDisplay.setText("Saved Username: " + username + "\nSaved Age: " + age);
    }

    private void loadData() {
        String username = sharedPreferences.getString(KEY_USERNAME, "No Username");
        String age = sharedPreferences.getString(KEY_AGE, "No Age");

        tvDisplay.setText("Username: " + username + "\nAge: " + age);
    }
}
