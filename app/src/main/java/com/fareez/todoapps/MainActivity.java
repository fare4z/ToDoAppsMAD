package com.fareez.todoapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText etNama, etPassword, etAge;
    Button btnSubmit, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.etNama);
        etAge = findViewById(R.id.etAge);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnDelete = findViewById(R.id.btnDelete);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDataSource userDataSource = new UserDataSource(getApplicationContext());
                userDataSource.open();// Insert data
                long newId = userDataSource.insertData(
                        etNama.getText().toString(),
                        Integer.parseInt(etAge.getText().toString()),
                        etPassword.getText().toString());
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long id = 1;
                UserDataSource userDataSource = new UserDataSource(getApplicationContext());
                userDataSource.open();

                userDataSource.deleteData(id);
                userDataSource.close();

            }
        });


    }
}