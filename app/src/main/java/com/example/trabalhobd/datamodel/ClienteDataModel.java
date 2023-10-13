package com.example.trabalhobd.datamodel;

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


    // Query para criar a tabela no banco de dados
    public static  String queryCriaTabela = "";

    // metodo para criar script para criar tabela

    public static String criarTabela(){

        // concatenacao de string

        queryCriaTabela += "CREATE TABLE "+TABELA+" (";
        queryCriaTabela += ID+" integer primary key autoincrement, ";
        queryCriaTabela += NOME+" text, ";
        queryCriaTabela += EMAIL+" text, ";
        queryCriaTabela += NUMERO+" text, ";
        queryCriaTabela += CPF+" text, ";
        queryCriaTabela += LOGRADOURO+" text ";
        queryCriaTabela += ")";

        return queryCriaTabela;
    }
}
