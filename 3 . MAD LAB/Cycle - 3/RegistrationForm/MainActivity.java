package com.example.registrationform;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge, etAddress, etPhone, etDOB, etQualification, etJob;
    RadioGroup rgGender;
    Button btnSubmit;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        etDOB = findViewById(R.id.etDOB);
        etQualification = findViewById(R.id.etQualification);
        etJob = findViewById(R.id.etJob);
        rgGender = findViewById(R.id.rgGender);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvDisplay = findViewById(R.id.tvDisplay);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    displayData();
                }
            }
        });
    }

    private boolean validateInputs() {
        if (TextUtils.isEmpty(etName.getText())) {
            etName.setError("Name required");
            return false;
        }
        if (TextUtils.isEmpty(etAge.getText())) {
            etAge.setError("Age required");
            return false;
        }
        if (rgGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(etAddress.getText())) {
            etAddress.setError("Address required");
            return false;
        }
        if (TextUtils.isEmpty(etPhone.getText()) || etPhone.getText().length() != 10) {
            etPhone.setError("Enter valid 10-digit phone number");
            return false;
        }
        if (TextUtils.isEmpty(etDOB.getText())) {
            etDOB.setError("DOB required");
            return false;
        }
        if (TextUtils.isEmpty(etQualification.getText())) {
            etQualification.setError("Qualification required");
            return false;
        }
        if (TextUtils.isEmpty(etJob.getText())) {
            etJob.setError("Job required");
            return false;
        }
        return true;
    }

    private void displayData() {
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        RadioButton rbGender = findViewById(selectedGenderId);
        String gender = rbGender.getText().toString();
        String address = etAddress.getText().toString();
        String phone = etPhone.getText().toString();
        String dob = etDOB.getText().toString();
        String qualification = etQualification.getText().toString();
        String job = etJob.getText().toString();

        String data = "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Gender: " + gender + "\n" +
                "Address: " + address + "\n" +
                "Phone: " + phone + "\n" +
                "DOB: " + dob + "\n" +
                "Qualification: " + qualification + "\n" +
                "Job: " + job;

        tvDisplay.setText(data);
    }
}
