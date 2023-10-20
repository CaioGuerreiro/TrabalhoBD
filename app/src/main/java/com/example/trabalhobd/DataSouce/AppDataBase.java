package com.example.trabalhobd.DataSouce;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.trabalhobd.api.AppUtil;
import com.example.trabalhobd.datamodel.ClienteDataModel;
import com.example.trabalhobd.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "TrabalhoBD.sqlite";
    public static final int DB_VERSION = 1;


    Cursor cursor;
    SQLiteDatabase db;
    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.d(AppUtil.TAG, "AppDataBase: Criando Banco de Dados");

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ClienteDataModel.criarTabela());

        Log.d(AppUtil.TAG, "onCreate: Tabela Cliente Criada"+ClienteDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String tabela, ContentValues dados){

        db = getWritableDatabase();

        boolean retorno = false;

        // Regra de negócio

        try {
            // O que deve ser realizado?
            // Salvar os dados

            retorno = db.insert(tabela,null,dados) > 0;


        }catch (Exception e){


            Log.d(AppUtil.TAG, "insert: "+e.getMessage());


        }


        return retorno; // FALSE ou TRUE
    }



    public boolean deleteById(String tabela, int id){

        boolean retorno = false;

        // regra de negocio

        retorno = db.delete(tabela,"id = ?", new String[]{String.valueOf(id)}) > 0;

        return retorno;
    }

    public boolean update(String tabela, ContentValues dados){

        boolean retorno = false;

        // regra de negocio


        retorno = db.update(tabela,dados,"id = ?",new String[] {String.valueOf(dados.get("id"))}) > 0;



        return retorno;
    }

    @SuppressLint("Range")
    public List<Cliente> getAllClientes(String tabela){

        db  = getWritableDatabase();

        List<Cliente> cliente = new ArrayList<>();

        String sql = "SELECT * FROM  "+tabela;

        Cliente obj;

        Cursor cursor;

        cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){

            do{
                obj = new Cliente();

                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setCpf(cursor.getString(cursor.getColumnIndex(ClienteDataModel.CPF)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setLougradouro(cursor.getString(cursor.getColumnIndex(ClienteDataModel.LOGRADOURO)));
                obj.setNumero(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NUMERO)));
                obj.setBairro(cursor.getString(cursor.getColumnIndex(ClienteDataModel.BAIRRO)));
                obj.setCidade(cursor.getString(cursor.getColumnIndex(ClienteDataModel.CIDADE)));
                obj.setEstado(cursor.getString(cursor.getColumnIndex(ClienteDataModel.ESTADO)));

                cliente.add(obj);

            }while (cursor.moveToNext());
        }


        return cliente;
    }

}
