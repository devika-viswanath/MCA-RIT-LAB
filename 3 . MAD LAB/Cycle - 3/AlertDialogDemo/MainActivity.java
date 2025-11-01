package com.example.myalert;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showDialogButton = findViewById(R.id.show_dialog_button);

//        showDialogButton.setOnClickListener(v -> {
//            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//            builder.setTitle("Alert Dialog Title")
//                    .setMessage("This is an alert dialog message.")
//                    .setCancelable(false)
//                    .setPositiveButton("Yes", (dialog, which) ->
//                            Toast.makeText(MainActivity.this, "You clicked YES", Toast.LENGTH_SHORT).show())
//                    .setNegativeButton("No", (dialog, which) ->
//                            Toast.makeText(MainActivity.this, "You clicked NO", Toast.LENGTH_SHORT).show())
//                    .setNeutralButton("Cancel", (dialog, which) ->
//                            Toast.makeText(MainActivity.this, "You clicked CANCEL", Toast.LENGTH_SHORT).show());
//            AlertDialog alertDialog = builder.create();
//            alertDialog.show();
//        });

//        you dont need toast message


        showDialogButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Alert Dialog Title")
                    .setMessage("This is an alert dialog message.")
                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialog, which) -> {
                        // Action when YES is clicked
                    })
                    .setNegativeButton("No", (dialog, which) -> {
                        // Action when NO is clicked
                        dialog.cancel();
                    })
                    .setNeutralButton("Cancel", (dialog, which) -> {
                        // Action when CANCEL is clicked
                        dialog.dismiss();
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });


    }
}
