package com.example.trabalhobd.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.trabalhobd.R;
import com.example.trabalhobd.controller.ClienteController;
import com.example.trabalhobd.controller.ProdutoController;
import com.example.trabalhobd.model.Cliente;
import com.example.trabalhobd.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutoActivity extends AppCompatActivity {

    ListView listaProduto;
    List<Produto> produtoList;
    ArrayAdapter<String> produtoAdapter;
    ProdutoController produtoController;
    ClienteController clienteController;
    Cliente cliente;
    List<Cliente> clienteList;

    Produto objProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produto);

        inicializaComponentes();
        mostraLista();

    }

    public void inicializaComponentes(){

        produtoController = new ProdutoController(ListaProdutoActivity.this);
        clienteController = new ClienteController(ListaProdutoActivity.this);

        listaProduto = findViewById(R.id.listaProduto);
        produtoList = produtoController.listar();
        clienteList = clienteController.listar();

       // produtos = new ArrayList<>();
    }

    public void mostraLista(){
        Cliente clienteClicado = (Cliente) getIntent().getSerializableExtra("CLIENTE");
        // Lista para armazenar os produtos do cliente selecionado
        List<Produto> produtosDoCliente = new ArrayList<>();

        // Filtrando os produtos associados ao cliente selecionado
        for (Produto produto : produtoList) {
            if (produto.getId_cliente() == clienteClicado.getId()) {
                produtosDoCliente.add(produto);
            }
        }

        // Criando uma lista de strings para exibir na ListView
        List<String> produtos = new ArrayList<>();
        for (Produto obj : produtosDoCliente) {
            produtos.add("Nome: " + obj.getNome() + "\nTipo: " + obj.getTipo() + "\nQuantidade: " + obj.getQuantidade()+"\nTipo: "+obj.getTipo());
        }

        // Atualizando o Adapter da ListView com os produtos filtrados do cliente
        ArrayAdapter<String> produtoAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.lista_produto_item, R.id.textView, produtos);
        listaProduto.setAdapter(produtoAdapter);
    }
}