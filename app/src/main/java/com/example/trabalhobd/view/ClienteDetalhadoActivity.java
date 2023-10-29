package com.example.trabalhobd.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalhobd.R;
import com.example.trabalhobd.controller.ClienteController;
import com.example.trabalhobd.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDetalhadoActivity extends AppCompatActivity {

    EditText etNome, etEmail, etNumero, etCpf, etLougradoro, etBairro, etCidade, etEstado;
    Button btnEditar,btnExcluir,btnProdutos;
    List<Cliente> clienteList;
    List<String> clientes;
    Cliente novoCliente;
    ClienteController clienteController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_detalhado);
        clienteController = new ClienteController(getApplicationContext());

        clienteList = clienteController.listar();
        clientes = new ArrayList<>();

        trazerDados();
        excluirCliente();
    }

    public void inicializaVariaveis() {
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
    }
    private void trazerDados(){
        inicializaVariaveis();

        String nome=getIntent().getStringExtra("CLIENTE_NOME");
        String email=getIntent().getStringExtra("CLIENTE_EMAIL");
        String numero=getIntent().getStringExtra("CLIENTE_NUMERO");
        String cpf=getIntent().getStringExtra("CLIENTE_CPF");
        String log=getIntent().getStringExtra("CLIENTE_LOG");
        String bairro=getIntent().getStringExtra("CLIENTE_BAIRRO");
        String cidade=getIntent().getStringExtra("CLIENTE_CIDADE");
        String estado=getIntent().getStringExtra("CLIENTE_ESTADO");

        etNome.setText(nome);
        etEmail.setText(email);
        etNumero.setText(numero);
        etCpf.setText(cpf);
        etLougradoro.setText(log);
        etBairro.setText(bairro);
        etCidade.setText(cidade);
        etEstado.setText(estado);

    }
        private void excluirCliente() {
            int id=getIntent().getIntExtra("CLIENTE_ID",-1);
            btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clienteController.deletar(id);
            }
        });
    }
    private void editar() {
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          //  clienteController.update(clienteController,);
            }
        });
    }

}