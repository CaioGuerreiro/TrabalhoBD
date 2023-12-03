package com.example.trabalhobd.controller;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.trabalhobd.DataSouce.AppDataBase;
import com.example.trabalhobd.api.AppUtil;
import com.example.trabalhobd.datamodel.ProdutoDataModel;
import com.example.trabalhobd.model.Produto;

import java.util.List;

public class ProdutoController extends AppDataBase implements ICrud<Produto> {

    ContentValues dadoDoObjeto;

    public ProdutoController(Context context){
        super(context);
        Log.d(AppUtil.TAG, "ProdutoController: Conectado");
    }
    @Override
    public boolean incluir(Produto obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ProdutoDataModel.QUANTIDADE, obj.getQuantidade());
        dadoDoObjeto.put(ProdutoDataModel.TIPO, obj.getTipo());
        dadoDoObjeto.put(ProdutoDataModel.ID_CLIENTE, obj.getId_cliente());

        return insert(ProdutoDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean alterar(Produto obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ProdutoDataModel.QUANTIDADE, obj.getQuantidade());
        dadoDoObjeto.put(ProdutoDataModel.TIPO, obj.getTipo());
        dadoDoObjeto.put(ProdutoDataModel.ID_CLIENTE, obj.getId_cliente());

        return update(ProdutoDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(ProdutoDataModel.TABELA, id);
    }


    public List<Produto> listar() {





        return getProduto(ProdutoDataModel.TABELA);
    }



}
