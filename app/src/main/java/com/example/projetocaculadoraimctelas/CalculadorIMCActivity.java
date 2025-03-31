package com.example.projetocaculadoraimctelas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class CalculadorIMCActivity extends AppCompatActivity {

    private Button btnSet;
    private EditText editPeso;
    private EditText editAltura;
    private float peso;
    private float altura;
    private float IMC;
    private String nivel;
    private String fraseApoio;

    private Button btnFechar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora_imc);

        editPeso = findViewById(R.id.editTextPeso);
        editAltura = findViewById(R.id.editTextAltura);

        DecimalFormat df = new DecimalFormat("#.00");

        btnSet = findViewById(R.id.btnSet);
        btnSet.setOnClickListener(view -> {
            peso = Float.parseFloat(editPeso.getText().toString());
            altura = Float.parseFloat(editAltura.getText().toString());
            IMC = peso/((altura)*(altura));

            Class activity = MainActivity.class;

            if(IMC<18.5){
                activity = AbaixoDoPesoActivity.class;
                nivel = "Abaixo do peso";
                fraseApoio = "Cada dia é uma oportunidade para fortalecer seu corpo e sua mente. Pequenos passos levam a grandes conquistas!";
            }
            else if(IMC>=18.5 && IMC<25){
                activity = PesoNormalActivity.class;
                nivel = "Peso normal";
                fraseApoio = "Parabéns! Seu equilíbrio reflete sua dedicação. Continue cultivando hábitos saudáveis e aproveite sua jornada!";
            }
            else if(IMC>=25 && IMC<30){
                activity = SobrepesoActivity.class;
                nivel = "Sobrepeso";
                fraseApoio = "Seu corpo é capaz de coisas incríveis! Pequenas mudanças hoje criam grandes transformações amanhã. Você consegue!";
            }
            else if(IMC>=30 && IMC<35){
                activity = Obesidade1Activity.class;
                nivel = "Obesidade grau 1";
                fraseApoio = "O primeiro passo para uma mudança começa com uma decisão. Cada escolha saudável te aproxima do seu objetivo!";
            }
            else if(IMC>=35 && IMC<40){
                activity = Obesidade2Activity.class;
                nivel = "Obesidade grau 2";
                fraseApoio = "Seu valor vai muito além de números! Cada dia é uma nova chance de cuidar do seu corpo e viver com mais energia!";
            }
            else if(IMC>=40){
                activity = Obesidade3Activity.class;
                nivel = "Obesidade grau 3";
                fraseApoio = "Sua jornada é única, e cada esforço conta. Com paciência e determinação, você pode alcançar qualquer meta!";
            }

            Intent intent = new Intent(this, activity);

            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            intent.putExtra("IMC", IMC);
            intent.putExtra("nivel", nivel);
            intent.putExtra("fraseApoio", fraseApoio);

            startActivity(intent);
        });

        btnFechar = findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



    }
    public void Limpar(View view){
        editPeso = findViewById(R.id.editTextPeso);
        editAltura = findViewById(R.id.editTextAltura);
        editPeso.setText("");
        editAltura.setText("");
    }
    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }
}