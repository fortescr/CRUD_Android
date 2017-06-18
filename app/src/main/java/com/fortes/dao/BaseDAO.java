package com.fortes.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by  Rodrigo Fortes
 */

public class BaseDAO extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "exemplosqlite";

    public static final int VERSAO_SCHEMA = 1;

    public static final String TABELA_CONTATO = "contato";

    public static final String CAMPO_ID = "_id";
    public static final String CAMPO_NOME = "nome";
    public static final String CAMPO_EMAIL = "email";
    public static final String CAMPO_CEP = "cep";
    public static final String CAMPO_LOGRADOURO = "logradouro";
    public static final String CAMPO_NUMERO = "numero";
    public static final String CAMPO_BAIRRO = "bairro";
    public static final String CAMPO_COMPLEMENTO = "complemento";
    public static final String CAMPO_CIDADE = "cidade";
    public static final String CAMPO_UF = "uf";

    private static final String CRIAR_TABELA_CONTATO = "CREATE TABLE "
            + TABELA_CONTATO + " (" + CAMPO_ID + " INTEGER PRIMARY KEY, "
            + CAMPO_NOME + " TEXT, "
            + CAMPO_EMAIL + " TEXT,"
            + CAMPO_CEP + " TEXT, "
            + CAMPO_LOGRADOURO + " TEXT, "
            + CAMPO_NUMERO + " TEXT, "
            + CAMPO_BAIRRO + " TEXT, "
            + CAMPO_COMPLEMENTO + " TEXT, "
            + CAMPO_CIDADE + " TEXT, "
            + CAMPO_UF + " TEXT) ";

    public BaseDAO(Context context) {
        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CRIAR_TABELA_CONTATO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
