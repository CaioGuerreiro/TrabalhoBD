package com.example.trabalhobd.controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.trabalhobd.DataSouce.AppDataBase;
import com.example.trabalhobd.datamodel.ClienteDataModel;
import com.example.trabalhobd.datamodel.ProdforDataModel;
import com.example.trabalhobd.model.Prodfor;

import java.util.List;

public class ProdforController extends AppDataBase implements ICrud<Prodfor>{

    ContentValues dadoDoObjeto;

    public ProdforController(Context context){
     super(context);
    }
    @Override
    public boolean incluir(Prodfor obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdforDataModel.NOME_FORNECEDOR, obj.getNome_fornecedor());
        dadoDoObjeto.put(ProdforDataModel.NOME_PRODUTO, obj.getNome_produto());

        return insert(ProdforDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean alterar(Prodfor obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdforDataModel.NOME_FORNECEDOR, obj.getNome_fornecedor());
        dadoDoObjeto.put(ProdforDataModel.NOME_PRODUTO, obj.getNome_produto());

        return update(ProdforDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean deletar(int id) {
         return deleteById(ClienteDataModel.TABELA,id);
    }

    @Override
    public List<Prodfor> listar() {
        return null;
    }
}
