package com.andrade.hamburgueriaz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    int numero=0, valorTotal, adicionais =0;
    private EditText nomeCliente;
    private TextView quantidade, valorPedido ;
    private Button adicionarQuantidade,subtrairQuantidade, enviarPedido;
    private CheckBox ingrediente1, ingrediente2, ingrediente3;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        nomeCliente = findViewById(R.id.nomeCliente);
        quantidade = (TextView) findViewById(R.id.valorQuantidade);
        adicionarQuantidade = findViewById(R.id.adicionarQuantidade);
        subtrairQuantidade = findViewById(R.id.subtrairQuantidade);
        valorPedido = (TextView) findViewById(R.id.valor_pedido);
        enviarPedido = findViewById(R.id.botaoPedido);
        ingrediente1 = findViewById(R.id.ingrediente1);
        ingrediente2 = findViewById(R.id.ingrediente2);
        ingrediente3 = findViewById(R.id.ingrediente3);

        nomeCliente.setAutofillHints(View.AUTOFILL_HINT_NAME);

        adicionarQuantidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero++;
                quantidade.setText(String.valueOf(numero));
                somar();
            }
        });

        subtrairQuantidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numero>0){
                    numero--;
                    quantidade.setText(String.valueOf(numero));
                    subtrair();
                }

            }
        });

        enviarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editNome = nomeCliente.getText().toString();

                if(editNome.isEmpty()){
                    Snackbar.make(v, "Preencha o nome", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void verificarAdicional() {


        if (numero >0 ) {
            if (ingrediente1.isChecked() && ingrediente2.isChecked() && ingrediente3.isChecked()) {
                adicionais += 7;
            } else if (ingrediente1.isChecked() && ingrediente2.isChecked()) {
                adicionais += 4;
            } else if (ingrediente1.isChecked() && ingrediente3.isChecked()) {
                adicionais += 5;
            } else if (ingrediente2.isChecked() && ingrediente3.isChecked()) {
                adicionais += 5;
            } else if (ingrediente3.isChecked()) {
                adicionais += 3;
            } else if (ingrediente1.isChecked() || ingrediente2.isChecked()) {
                adicionais += 2;
            }
            this.valorTotal+=adicionais;
        }
    }

    private void somar(){
        if(numero ==1){
            valorTotal = 20;
            verificarAdicional();
            valorPedido.setText(String.valueOf(valorTotal));

        }else if(numero>1){
            valorTotal= valorTotal + 20;
            verificarAdicional();
            valorPedido.setText(String.valueOf(valorTotal));
        }
        
    }
    private void subtrair(){
        if(numero > -1){
            valorTotal = valorTotal - 20 - adicionais;
            valorPedido.setText(String.valueOf(valorTotal));
        }

    }

    private void enviarPedido(){

    }

}