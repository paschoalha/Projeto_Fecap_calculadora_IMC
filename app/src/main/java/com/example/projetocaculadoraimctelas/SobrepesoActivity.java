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

    public class SobrepesoActivity extends AppCompatActivity {

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
    private Button btnFecharSobrePeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sobrepeso);
        btnFecharSobrePeso = findViewById(R.id.btnFecharSobrePeso);
        btnFecharSobrePeso.setOnClickListener(view -> {
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

        textPeso = findViewById(R.id.textPeso3);
        textAltura = findViewById(R.id.textAltura3);
        textIMC = findViewById(R.id.textIMC3);
        textNivel = findViewById(R.id.textNivel3);
        textFraseApoio = findViewById(R.id.textFraseApoio3);


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