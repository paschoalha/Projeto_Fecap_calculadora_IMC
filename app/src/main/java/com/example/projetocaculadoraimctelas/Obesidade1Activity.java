package com.example.projetocaculadoraimctelas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class Obesidade1Activity extends AppCompatActivity {

    private float peso;
    private float altura;
    private float IMC;
    private String nivel;
    private String fraseApoio;
    private TextView textPeso;
    private TextView textAltura;
    private TextView textIMC;
    private TextView textNivel;

    private TextView textFraseApoio;
    private Button btnObesidade1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade1);
        btnObesidade1 = findViewById(R.id.btnFecharObesidade1);
        btnObesidade1.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getFloat("peso");
        altura = bundle.getFloat("altura");
        IMC = bundle.getFloat("IMC");
        nivel= bundle.getString("nivel");
        fraseApoio = bundle.getString("fraseApoio");

        textPeso = findViewById(R.id.textPeso4);
        textAltura = findViewById(R.id.textAltura4);
        textIMC = findViewById(R.id.textIMC4);
        textNivel = findViewById(R.id.textNivel4);
        textFraseApoio = findViewById(R.id.textFraseApoio4);


        String formatado = String.format(Locale.US, "%.2f", IMC);

        textPeso.setText(" "+ peso+ "kg");
        textAltura.setText(" "+ altura+"m");
        textIMC.setText(" "+ formatado +" kg/m²");
        textNivel.setText(" "+ nivel);
        textFraseApoio.setText(""+ fraseApoio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}