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

public class FormularioActivity extends AppCompatActivity {

    EditText etNome, etEmail, etNumero, etCpf, etLougradoro, etBairro, etCidade, etEstado;
    Button btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        inicializarComponentes();
        btnListener();
    }

    void inicializarComponentes(){
        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etNumero = findViewById(R.id.etNumero);
        etCpf = findViewById(R.id.etCpf);
        etLougradoro = findViewById(R.id.etLougradoro);
        etBairro = findViewById(R.id.etBairro);
        etCidade = findViewById(R.id.etCidade);
        etEstado = findViewById(R.id.etEstado);


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
                    Toast.makeText(FormularioActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }

                // populando o banco de dados
                novoCliente.setNome(etNome.getText().toString());
                novoCliente.setEmail(etEmail.getText().toString());
                novoCliente.setNumero(etNumero.getText().toString());
                novoCliente.setCpf(etCpf.getText().toString());
                novoCliente.setLougradouro(etLougradoro.getText().toString());
                novoCliente.setBairro(etBairro.getText().toString());
                novoCliente.setCidade(etCidade.getText().toString());
                novoCliente.setEstado(etEstado.getText().toString());
                // aqui que vamos salvar os dados no banco de dados.
                clienteController.incluir(novoCliente);

                Toast.makeText(FormularioActivity.this, "Cliente Salvo!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

}