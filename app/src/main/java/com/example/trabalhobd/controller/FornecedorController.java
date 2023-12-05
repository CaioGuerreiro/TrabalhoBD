package com.example.trabalhobd.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.trabalhobd.DataSouce.AppDataBase;
import com.example.trabalhobd.api.AppUtil;
import com.example.trabalhobd.datamodel.FornecedorDataModel;
import com.example.trabalhobd.datamodel.ProdutoDataModel;
import com.example.trabalhobd.model.Fornecedor;

import java.util.List;

public class FornecedorController extends AppDataBase implements ICrud<Fornecedor>{

    ContentValues dadoDoObjeto;

    public FornecedorController(Context context){
        super(context);

        Log.d(AppUtil.TAG, "FornecedorController: Conectado");
    }


    @Override
    public boolean incluir(Fornecedor obj) {
        dadoDoObjeto = new ContentValues();
        dadoDoObjeto.put(FornecedorDataModel.ID_FORNECEDOR, obj.getId_fornecedor());
        dadoDoObjeto.put(FornecedorDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(FornecedorDataModel.CNPJ,obj.getCnpj());
        dadoDoObjeto.put(FornecedorDataModel.NOME,obj.getNome());

        return insert(FornecedorDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean alterar(Fornecedor obj) {
        dadoDoObjeto.put(FornecedorDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(FornecedorDataModel.CNPJ,obj.getCnpj());
        dadoDoObjeto.put(FornecedorDataModel.NOME,obj.getNome());

        return update(FornecedorDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(FornecedorDataModel.TABELA, id);
    }

    @Override
    public List<Fornecedor> listar() {
        return getAllFornecedor(ProdutoDataModel.TABELA);
    }
}
