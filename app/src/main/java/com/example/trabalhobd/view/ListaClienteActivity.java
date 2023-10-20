package com.example.trabalhobd.view;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
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

        lista = findViewById(R.id.lista);
        etLista = findViewById(R.id.etLista);
        clienteList = clienteController.listar();
        clientes = new ArrayList<>();




       for (Cliente obj: clienteList) {
            clientes.add("Nome: "+obj.getNome()+"\nCpf:" +obj.getCpf());
        }

        clienteAdapter = new ArrayAdapter<>(getApplicationContext(),R.layout.lista_cliente_item,R.id.textView, clientes);

        lista.setAdapter(clienteAdapter);

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
}