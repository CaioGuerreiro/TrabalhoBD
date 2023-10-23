package com.example.trabalhobd.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalhobd.R;
import com.example.trabalhobd.controller.ClienteController;
import com.example.trabalhobd.model.Cliente;

public class ClienteDetalhadoActivity extends AppCompatActivity {

    EditText etNome, etEmail, etNumero, etCpf, etLougradoro, etBairro, etCidade, etEstado;
    Button btnEditar,btnExcluir,btnProdutos;

    Cliente novoCliente;
    ClienteController clienteController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_detalhado);

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

        btnEditar = findViewById(R.id.btnEditar);
        btnExcluir = findViewById(R.id.btnExcluir);
        btnProdutos = findViewById(R.id.btnProdutos);

        clienteController = new ClienteController(getApplicationContext());
    }

    private void btnListener() {
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clienteController.deletar(2);
            }
        });
    }

}