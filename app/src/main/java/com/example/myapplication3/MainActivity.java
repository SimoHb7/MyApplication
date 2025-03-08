package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNom = findViewById(R.id.etNom);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etAdresse = findViewById(R.id.etAdresse);
        Spinner spinnerVille = findViewById(R.id.spinnerVille);
        RadioGroup radioGenre = findViewById(R.id.radioGenre);
        Button btnEnvoyer = findViewById(R.id.btnEnvoyer);

        String[] villes = {"Marrakech", "Casablanca", "Rabat"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, villes);
        spinnerVille.setAdapter(adapter);

        btnEnvoyer.setOnClickListener(v -> {
            String nom = etNom.getText().toString();
            String email = etEmail.getText().toString();
            String phone = etPhone.getText().toString();
            String adresse = etAdresse.getText().toString();
            String ville = spinnerVille.getSelectedItem().toString();
            String genre = ((RadioButton) findViewById(radioGenre.getCheckedRadioButtonId())).getText().toString();

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("nom", nom);
            intent.putExtra("email", email);
            intent.putExtra("phone", phone);
            intent.putExtra("adresse", adresse);
            intent.putExtra("ville", ville);
            intent.putExtra("genre", genre);
            startActivity(intent);


        });
    }

}
