package com.example.trabalhobd.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trabalhobd.R;
import com.example.trabalhobd.controller.ClienteController;
import com.example.trabalhobd.controller.ProdutoController;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    ProdutoController produtoController;
    Button btnCadastrar, btnListar, btnCadastrarProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        clienteController = new ClienteController(getApplicationContext());
        produtoController = new ProdutoController(getApplicationContext());

        inicializaVariaveis();
        mainParaFormulario();
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
    }
}