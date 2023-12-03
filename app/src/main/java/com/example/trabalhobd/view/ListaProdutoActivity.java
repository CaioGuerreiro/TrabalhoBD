package com.example.trabalhobd.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.trabalhobd.R;
import com.example.trabalhobd.controller.ClienteController;
import com.example.trabalhobd.controller.ProdutoController;
import com.example.trabalhobd.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutoActivity extends AppCompatActivity {

    ListView listaProduto;
    List<Produto> produtoList;
    List<String> produtos;
    ArrayAdapter<String> produtoAdapter;
    ProdutoController produtoController;
    Produto objProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produto);



        inicializaComponentes();
        mostraLista();

    }

    public void inicializaComponentes(){
        int id = getIntent().getIntExtra("CLIENTE_ID", -1);

        produtoController = new ProdutoController(ListaProdutoActivity.this);
        listaProduto = findViewById(R.id.listaProduto);
        produtoList = produtoController.listar();
        produtos = new ArrayList<>();
    }

    public void mostraLista(){
        for (Produto obj: produtoList){
            produtos.add("Nome: "+obj.getNome()+"\nTipo: "+obj.getTipo()+"\nQuantidade: "+obj.getQuantidade());
        }
        produtoAdapter = new ArrayAdapter<>(getApplicationContext(),R.layout.lista_produto_item,R.id.textView, produtos);
        listaProduto.setAdapter(produtoAdapter);
    }
}