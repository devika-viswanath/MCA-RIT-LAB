package com.example.sharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    boolean isImage1 = true;  // Track which image is showing
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(v -> {
            if (isImage1) {
                imageView.setImageResource(R.drawable.image2);
                Toast.makeText(MainActivity.this, "Image 2 displayed!", Toast.LENGTH_SHORT).show();
                isImage1 = false;
            } else {
                imageView.setImageResource(R.drawable.image1);
                Toast.makeText(MainActivity.this, "Image 1 displayed!", Toast.LENGTH_SHORT).show();
                isImage1 = true;
            }
        });
    }
}
