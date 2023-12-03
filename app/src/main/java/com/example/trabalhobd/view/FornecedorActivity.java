package com.example.trabalhobd.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalhobd.R;
import com.example.trabalhobd.controller.ClienteController;
import com.example.trabalhobd.model.Cliente;

public class FornecedorActivity extends AppCompatActivity {

    EditText etNome,etCpf;
    Button btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fornecedor);

        inicializarComponentes();
        btnListener();
    }

    void inicializarComponentes(){
        etNome = findViewById(R.id.etNome);
        etCpf = findViewById(R.id.etCpf);
        btnSalvar = findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();
        clienteController = new ClienteController(getApplicationContext());
    }

    private void btnListener() {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isDadosOk = true;

                if(TextUtils.isEmpty(etNome.getText())){
                    isDadosOk = false;
                    etNome.setError("ERROR");
                    Toast.makeText(FornecedorActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }

                // populando o banco de dados
                novoCliente.setNome(etNome.getText().toString());
                novoCliente.setCpf(etCpf.getText().toString());
                clienteController.incluir(novoCliente);

                Toast.makeText(FornecedorActivity.this, "Cliente Salvo!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

}