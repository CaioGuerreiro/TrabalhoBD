package com.example.trabalhobd.view;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalhobd.R;
import com.example.trabalhobd.controller.FornecedorController;
import com.example.trabalhobd.controller.ProdforController;
import com.example.trabalhobd.controller.ProdutoController;
import com.example.trabalhobd.model.Cliente;
import com.example.trabalhobd.model.Fornecedor;
import com.example.trabalhobd.model.Prodfor;
import com.example.trabalhobd.model.Produto;

public class FormularioProdutoActivity extends AppCompatActivity {

    EditText etNome, etQtd, etTipo, etIdCliente, etNomeFornecedor, etCnpj,etIdProduto,etIdFor;

    Button btnSalvar;

    Produto novoProduto;
    Fornecedor novoFornecedor;
    Prodfor novoProdfor;


    FornecedorController fornecedorController;
    ProdutoController produtoController;
    ProdforController prodforController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produto);
        inicializarComponentes();


        btnListener();
    }

    void inicializarComponentes(){
        etIdProduto = findViewById(R.id.etIdProduto);
        etIdFor = findViewById(R.id.etIdFor);
        etNome = findViewById(R.id.etNome);
        etQtd = findViewById(R.id.etQtd);
        etTipo = findViewById(R.id.etTipo);
        etIdCliente = findViewById(R.id.etIdCliente);
        etNomeFornecedor = findViewById(R.id.etNomeFornecedor);
//        etNomeFornecedor2 = findViewById(R.id.etNomeFornecedor2);
        etCnpj = findViewById(R.id.etCnpj);
//        etCnpj2 = findViewById(R.id.etCnpj2);

        btnSalvar = findViewById(R.id.btnSalvar);

        novoProduto = new Produto();
        novoFornecedor = new Fornecedor();
        novoProdfor = new Prodfor();

        produtoController = new ProdutoController(getApplicationContext());
        fornecedorController = new FornecedorController(getApplicationContext());
        prodforController = new ProdforController(getApplicationContext());
    }
    private void btnListener() {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // populando o banco de dados
                novoProduto.setId_produto(Integer.parseInt(etIdProduto.getText().toString()));// verificar se não ira dar erro de tipagem
                novoProduto.setNome(etNome.getText().toString());
                novoProduto.setQuantidade(Integer.parseInt(etQtd.getText().toString())); // verificar se não ira dar erro de tipagem
                novoProduto.setTipo(etTipo.getText().toString());
                novoProduto.setId_cliente(Integer.parseInt(etIdCliente.getText().toString()));// verificar se não ira dar erro de tipagem
                // aqui que vamos salvar os dados no banco de dados.
                produtoController.incluir(novoProduto);

                novoFornecedor.setId_fornecedor(Integer.parseInt(etIdFor.getText().toString()));// verificar se não ira dar erro de tipagem
                novoFornecedor.setNome(etNomeFornecedor.getText().toString()); // aqui pode tá errado
                novoFornecedor.setCnpj(etCnpj.getText().toString());

//                novoFornecedor.setNome(etNomeFornecedor2.getText().toString()); // aqui pode tá errado
//                novoFornecedor.setCnpj(etCnpj2.getText().toString());

                fornecedorController.incluir(novoFornecedor);
                novoProdfor.setId_produto(Integer.parseInt(etIdProduto.getText().toString()));// verificar se não ira dar erro de tipagem
                novoProdfor.setId_fornecedor(Integer.parseInt(etIdFor.getText().toString()));// verificar se não ira dar erro de tipagem

                prodforController.incluir(novoProdfor);


                Toast.makeText(FormularioProdutoActivity.this, "Produto Salvo!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}