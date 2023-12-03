package com.example.trabalhobd.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trabalhobd.R;
import com.example.trabalhobd.controller.ClienteController;
import com.example.trabalhobd.controller.FornecedorController;
import com.example.trabalhobd.controller.ProdutoController;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    ProdutoController produtoController;
    FornecedorController fornecedorController;
    Button btnCadastrar, btnListar, btnCadastrarProduto, btnCadastrarFornecedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        clienteController = new ClienteController(getApplicationContext());
        produtoController = new ProdutoController(getApplicationContext());
        fornecedorController = new FornecedorController(getApplicationContext());

        inicializaVariaveis();
        mainParaFormulario();
        mainParaFormularioFornecedor();
        mainParaListaCliente();
        mainParaFormularioProduto();
    }

    public void mainParaFormularioProduto(){
        btnCadastrarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FormularioProdutoActivity.class);
                startActivity(i);
            }
        });
    }

    public void mainParaFormularioFornecedor(){
        btnCadastrarFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FornecedorActivity.class);
                startActivity(i);
            }
        });
    }

    public void mainParaFormulario(){
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity(i);
            }
        });
    }

    public void mainParaListaCliente(){
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListaClienteActivity.class);
                startActivity(i);
            }
        });
    }

    public void inicializaVariaveis(){
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnListar = findViewById(R.id.btnListar);
        btnCadastrarProduto = findViewById(R.id.btnCadastrarProduto);
        btnCadastrarFornecedor = findViewById(R.id.btnCadastrarFornecedor);

    }
}