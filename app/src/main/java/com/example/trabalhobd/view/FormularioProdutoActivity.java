package com.example.trabalhobd.view;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalhobd.R;
import com.example.trabalhobd.controller.ProdutoController;
import com.example.trabalhobd.model.Produto;

public class FormularioProdutoActivity extends AppCompatActivity {

    EditText etNome, etQtd, etTipo, etIdCliente;

    Button btnSalvar;

    Produto novoProduto;

    ProdutoController produtoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_produto);

        inicializarComponentes();
        btnListener();
    }

    void inicializarComponentes(){
        etNome = findViewById(R.id.etNome);
        etQtd = findViewById(R.id.etQtd);
        etTipo = findViewById(R.id.etTipo);
        etIdCliente = findViewById(R.id.etIdCliente);

        btnSalvar = findViewById(R.id.btnSalvar);

        novoProduto = new Produto();
        produtoController = new ProdutoController(getApplicationContext());
    }
    private void btnListener() {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                // populando o banco de dados
                novoProduto.setNome(etNome.getText().toString());
                novoProduto.setQuantidade(Integer.parseInt(etQtd.getText().toString())); // verificar se não ira dar erro de tipagem
                novoProduto.setTipo(etTipo.getText().toString());
                novoProduto.setId_cliente(Integer.parseInt(etIdCliente.getText().toString()));// verificar se não ira dar erro de tipagem
                // aqui que vamos salvar os dados no banco de dados.
                produtoController.incluir(novoProduto);

                Toast.makeText(FormularioProdutoActivity.this, "Produto Salvo!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}