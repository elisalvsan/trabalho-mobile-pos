package com.andrade.hamburgueriaz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int numero=0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        EditText name = findViewById(R.id.nomeCliente);
        name.setAutofillHints(View.AUTOFILL_HINT_NAME);

        TextView quantidade = (TextView) findViewById(R.id.valorQuantidade);

        Button adicionarQuantidade = findViewById(R.id.adicionarQuantidade);
        adicionarQuantidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero++;
                quantidade.setText(String.valueOf(numero));
            }
        });

        Button subtrairQuantidade = findViewById(R.id.subtrairQuantidade);
        subtrairQuantidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numero>0){
                    numero--;
                    quantidade.setText(String.valueOf(numero));
                }

            }
        });
    }
}