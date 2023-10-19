package com.example.trabalhobd.view;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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



        clienteController = new ClienteController(getApplicationContext());

        lista = findViewById(R.id.lista);
        etLista = findViewById(R.id.etLista);
        clienteList = clienteController.listar();
        clientes = new ArrayList<>();




       for (Cliente obj: clienteList) {
            clientes.add(obj.getNome());
        }

        clienteAdapter = new ArrayAdapter<>(getApplicationContext(),R.layout.lista_cliente_item,R.id.textView, clientes);

        lista.setAdapter(clienteAdapter);

    }
}