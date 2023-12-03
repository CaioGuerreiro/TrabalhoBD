package com.example.trabalhobd.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.material.icons.sharp.ClearKt;

import com.example.trabalhobd.R;
import com.example.trabalhobd.controller.ClienteController;
import com.example.trabalhobd.controller.ProdutoController;
import com.example.trabalhobd.model.Cliente;
import com.example.trabalhobd.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ClienteDetalhadoActivity extends AppCompatActivity {

    EditText etNome, etEmail, etNumero, etCpf, etLougradoro, etBairro, etCidade, etEstado;
    Button btnEditar, btnExcluir, btnProdutos;
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
        inicializaVariaveis();
        trazerDados();

        excluirCliente();
        editarCliente();
        btnProdutos();

    }

    public void btnProdutos(){
        btnProdutos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(ClienteDetalhadoActivity.this, ListaProdutoActivity.class);
                startActivity(i);

            }
        });
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
        //inicializaVariaveis();
        //pegando os dados enviados por "i.put.extra" da tela ListCliente
        String nome = getIntent().getStringExtra("CLIENTE_NOME");
        String email = getIntent().getStringExtra("CLIENTE_EMAIL");
        String numero = getIntent().getStringExtra("CLIENTE_NUMERO");
        String cpf = getIntent().getStringExtra("CLIENTE_CPF");
        String log = getIntent().getStringExtra("CLIENTE_LOG");
        String bairro = getIntent().getStringExtra("CLIENTE_BAIRRO");
        String cidade = getIntent().getStringExtra("CLIENTE_CIDADE");
        String estado = getIntent().getStringExtra("CLIENTE_ESTADO");

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
        //caso ele não encontre o id do usuário, ele vai retornar o -1
        int id = getIntent().getIntExtra("CLIENTE_ID", -1);

        // Criar o AlertDialog.Builder fora do OnClickListener
        AlertDialog.Builder caixaTexto = new AlertDialog.Builder(ClienteDetalhadoActivity.this);
        caixaTexto.setTitle("Excluir");
        caixaTexto.setMessage("Tem certeza que deseja excluir?");

        // Impedir que clique fora
        caixaTexto.setCancelable(false);
        caixaTexto.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Excluir o cliente
                clienteController.deletar(id);
                Toast.makeText(getApplicationContext(), "Excluído com sucesso", Toast.LENGTH_LONG).show();


                Intent intent = new Intent(ClienteDetalhadoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        caixaTexto.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //mostra caixa de mensagem pequena por um longo tempo
                Toast.makeText(getApplicationContext(), "Operação cancelada", Toast.LENGTH_LONG).show();
            }
        });

        // Exibir o diálogo quando o botão for clicado
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Exibir o AlertDialog
                caixaTexto.show();
            }
        });
    }

    private void editarCliente() {
        //trazendo o objeto cliente selecionado
        Cliente clienteClicado = (Cliente) getIntent().getSerializableExtra("CLIENTE");

        AlertDialog.Builder caixaTexto = new AlertDialog.Builder(ClienteDetalhadoActivity.this);
        caixaTexto.setTitle("Editar");
        caixaTexto.setMessage("Tem certeza que deseja editar?");

        caixaTexto.setCancelable(false);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                caixaTexto.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //alterando os dados conforme vao sendo preenchidos
                        clienteClicado.setNome(etNome.getText().toString());
                        clienteClicado.setEmail(etEmail.getText().toString());
                        clienteClicado.setNumero(etNumero.getText().toString());
                        clienteClicado.setCpf(etCpf.getText().toString());
                        clienteClicado.setLougradouro(etLougradoro.getText().toString());
                        clienteClicado.setBairro(etBairro.getText().toString());
                        clienteClicado.setCidade(etCidade.getText().toString());
                        clienteClicado.setEstado(etEstado.getText().toString());

                        clienteController.alterar(clienteClicado);
                        Toast.makeText(getApplicationContext(), "Editado com sucesso", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(ClienteDetalhadoActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                });
                caixaTexto.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //mostra caixa de mensagem pequena por um longo tempo
                        Toast.makeText(getApplicationContext(), "Operação cancelada", Toast.LENGTH_LONG).show();
                    }
                });


                caixaTexto.show();
            }
        });

    }



}