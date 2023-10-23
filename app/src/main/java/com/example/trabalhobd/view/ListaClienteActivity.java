package com.example.trabalhobd.view;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.trabalhobd.R;
import com.example.trabalhobd.controller.ClienteController;
import com.example.trabalhobd.model.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListaClienteActivity extends AppCompatActivity {


    EditText etLista;
    Button btnDetalhar;
    ListView lista;
    List<Cliente> clienteList;
    List<String> clientes;
    ArrayAdapter<String> clienteAdapter;
    //filtro de clientes
    ArrayList<HashMap<String, String>> filtroClientes;
    ClienteController clienteController;
    Cliente objCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cliente);

        clienteController = new ClienteController(ListaClienteActivity.this);
        //mainParaDetalharCliente();
        //inicializaVariaveis();


        lista = findViewById(R.id.lista);
        etLista = findViewById(R.id.etLista);
        clienteList = clienteController.listar();
        clientes = new ArrayList<>();


       for (Cliente obj: clienteList) {
            clientes.add("Nome: "+obj.getNome()+"\nCpf:" +obj.getCpf());
        }

        clienteAdapter = new ArrayAdapter<>(getApplicationContext(),R.layout.lista_cliente_item,R.id.textView, clientes);

        lista.setAdapter(clienteAdapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtenha o Cliente clicado
                Cliente clienteClicado = clienteList.get(position);

                // Crie uma nova Intent para a ClienteDetalhadoActivity
                Intent i = new Intent(ListaClienteActivity.this, ClienteDetalhadoActivity.class);

//                // Adicione quaisquer dados extras que você queira passar para a próxima Activity
//                i.putExtra("CLIENTE_NOME", clienteClicado.getNome());
//                i.putExtra("CLIENTE_CPF", clienteClicado.getCpf());

                // Inicie a Activity
                startActivity(i);
            }
        });


        etLista.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence filtro, int i, int i1, int i2) {

                ListaClienteActivity.this.clienteAdapter.getFilter().filter(filtro);
            }




            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

  /*  public void mainParaDetalharCliente(){
        btnDetalhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ponto de partida
                Intent i = new Intent(ListaClienteActivity.this, ClienteDetalhadoActivity.class);
                startActivity(i);
            }
        });
    }
    public void inicializaVariaveis(){
        btnDetalhar = findViewById(R.id.btnDetalhar);
    }
*/
}