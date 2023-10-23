package com.example.trabalhobd.controller;



import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.trabalhobd.DataSouce.AppDataBase;
import com.example.trabalhobd.api.AppUtil;
import com.example.trabalhobd.datamodel.ClienteDataModel;
import com.example.trabalhobd.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;
    public ClienteController(Context context) {
        super(context);

        Log.d(AppUtil.TAG, "ClienteController: Conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail());
        dadoDoObjeto.put(ClienteDataModel.CPF,obj.getCpf());
        dadoDoObjeto.put(ClienteDataModel.NUMERO,obj.getNumero());
        dadoDoObjeto.put(ClienteDataModel.LOGRADOURO,obj.getLougradouro());
        dadoDoObjeto.put(ClienteDataModel.BAIRRO,obj.getBairro());
        dadoDoObjeto.put(ClienteDataModel.CIDADE,obj.getCidade());
        dadoDoObjeto.put(ClienteDataModel.ESTADO,obj.getEstado());

        return insert(ClienteDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean alterar(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.ID,obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail());
        dadoDoObjeto.put(ClienteDataModel.CPF,obj.getCpf());
        dadoDoObjeto.put(ClienteDataModel.NUMERO,obj.getNumero());
        dadoDoObjeto.put(ClienteDataModel.LOGRADOURO,obj.getLougradouro());
        dadoDoObjeto.put(ClienteDataModel.BAIRRO,obj.getBairro());
        dadoDoObjeto.put(ClienteDataModel.CIDADE,obj.getCidade());
        dadoDoObjeto.put(ClienteDataModel.ESTADO,obj.getEstado());

        return insert(ClienteDataModel.TABELA, dadoDoObjeto);

    }

    @Override
    public boolean deletar(int id) {
        return deleteById(ClienteDataModel.TABELA,id);
    }

    @Override
    public List<Cliente> listar() {


        return getAllClientes(ClienteDataModel.TABELA);





        // saber quantos elementos tem na lista
        //int totalClientes = lista.size();

    }
}
