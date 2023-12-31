package com.example.trabalhobd.datamodel;

import android.util.Log;

public class ClienteDataModel {

    // Nome da tabela

    public static final String TABELA = "cliente";

    // atributos com os nomes dos campos

    public static final String ID = "id"; // integer Primary key
    public static final String NOME = "nome"; // text
    public static final String EMAIL = "email"; // text
    public static final String NUMERO = "numero"; // text
    public static final String CPF = "cpf"; // text
    public static final String LOGRADOURO = "logradouro"; // text
    public static final String BAIRRO = "bairro"; // text
    public static final String CIDADE = "cidade"; // text
    public static final String ESTADO = "estado"; // text


    // Query para criar a tabela no banco de dados
    public static  String queryCriaTabela = "";

    // metodo para criar script para criar tabela

    public static String criarTabela(){

        // concatenacao de string

        Log.i("DB_Crud", "criarTabela: CRIANDO TABELA");

        queryCriaTabela += "CREATE TABLE "+TABELA+" (";
        queryCriaTabela += ID+" integer primary key autoincrement, ";
        queryCriaTabela += NOME+" text, "; // nome text
        queryCriaTabela += EMAIL+" text, "; // nome text
        queryCriaTabela += LOGRADOURO+" text, "; // nome text
        queryCriaTabela += NUMERO+" text, "; // nome text
        queryCriaTabela += CPF+" text, "; // nome text
        queryCriaTabela += BAIRRO+" text, "; // nome text
        queryCriaTabela += CIDADE+" text, "; // nome text
        queryCriaTabela += ESTADO+" text "; // nome text
        queryCriaTabela += ")";

        return queryCriaTabela;
    }
}




