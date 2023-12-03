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
import com.example.trabalhobd.controller.FornecedorController;
import com.example.trabalhobd.model.Cliente;
import com.example.trabalhobd.model.Fornecedor;

public class FornecedorActivity extends AppCompatActivity {

    EditText etNome,etCnpj;
    Button btnSalvar;

    Fornecedor novoFornecedor;
    FornecedorController fornecedorController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fornecedor);

        inicializarComponentes();
        btnListener();
    }

    void inicializarComponentes(){
        etNome = findViewById(R.id.etNome);
        etCnpj = findViewById(R.id.etCnpj);
        btnSalvar = findViewById(R.id.btnSalvar);

        novoFornecedor = new Fornecedor();
        fornecedorController = new FornecedorController(getApplicationContext());
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
                novoFornecedor.setNome(etNome.getText().toString());
                novoFornecedor.setCnpj(etCnpj.getText().toString());
                fornecedorController.incluir(novoFornecedor);

                Toast.makeText(FornecedorActivity.this, "Fornecedor Salvo!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

}