package com.fortes.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.fortes.model.Contato;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Fortes.
 */

public class ContactDAO {
    private SQLiteDatabase database;
    private BaseDAO baseDAO;

    public ContactDAO(Context context) {
        baseDAO = new BaseDAO(context);
    }

    public void open() throws SQLException {
        database = baseDAO.getWritableDatabase();
    }

    public void close() {
        baseDAO.close();
    }

    public long save(Contato contato) {
        ContentValues values = new ContentValues();

        values.put(BaseDAO.CAMPO_NOME, contato.getNome());
        values.put(BaseDAO.CAMPO_EMAIL, contato.getEmail());
        values.put(BaseDAO.CAMPO_CEP, contato.getCep());
        values.put(BaseDAO.CAMPO_LOGRADOURO, contato.getLogradouro());
        values.put(BaseDAO.CAMPO_NUMERO, contato.getNumero());
        values.put(BaseDAO.CAMPO_BAIRRO, contato.getBairro());
        values.put(BaseDAO.CAMPO_COMPLEMENTO, contato.getComplemento());
        values.put(BaseDAO.CAMPO_CIDADE, contato.getCidade());
        values.put(BaseDAO.CAMPO_UF, contato.getUf());

        return database.insert(BaseDAO.TABELA_CONTATO, null, values);
    }

    public List<Contato> getAll() {
        Cursor c = database.rawQuery("SELECT * FROM " + BaseDAO.TABELA_CONTATO, null);
        List<Contato> contatos = new ArrayList<Contato>();
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                Contato contato = new Contato(
                        c.getInt(c.getColumnIndex(BaseDAO.CAMPO_ID)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_NOME)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_EMAIL)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_CEP)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_LOGRADOURO)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_NUMERO)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_BAIRRO)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_COMPLEMENTO)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_CIDADE)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_UF)));
                contatos.add(contato);
                c.moveToNext();
            }
        }
        c.close();

        return contatos;
    }

    public Contato getById(int codigo) {
        Cursor c = database.rawQuery("SELECT * FROM " + BaseDAO.TABELA_CONTATO + " where "+BaseDAO.CAMPO_ID + " = " + codigo, null);
        Contato contato = new Contato();
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                contato = new Contato(
                        c.getInt(c.getColumnIndex(BaseDAO.CAMPO_ID)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_NOME)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_EMAIL)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_CEP)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_LOGRADOURO)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_NUMERO)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_BAIRRO)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_COMPLEMENTO)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_CIDADE)),
                        c.getString(c.getColumnIndex(BaseDAO.CAMPO_UF)));
                c.moveToNext();
            }
        }
        c.close();

        return contato;
    }

    public int update(Contato contato) {
        long id = contato.getId();
        ContentValues values = new ContentValues();

        values.put(BaseDAO.CAMPO_NOME, contato.getNome());
        values.put(BaseDAO.CAMPO_EMAIL, contato.getEmail());
        values.put(BaseDAO.CAMPO_CEP, contato.getCep());
        values.put(BaseDAO.CAMPO_LOGRADOURO, contato.getLogradouro());
        values.put(BaseDAO.CAMPO_NUMERO, contato.getNumero());
        values.put(BaseDAO.CAMPO_BAIRRO, contato.getBairro());
        values.put(BaseDAO.CAMPO_COMPLEMENTO, contato.getComplemento());
        values.put(BaseDAO.CAMPO_CIDADE, contato.getCidade());
        values.put(BaseDAO.CAMPO_UF, contato.getUf());


        return database.update(BaseDAO.TABELA_CONTATO, values, BaseDAO.CAMPO_ID + " = " + id, null);
    }

    public void delete(Contato contato) {
        long id = contato.getId();

        database.delete(BaseDAO.TABELA_CONTATO, BaseDAO.CAMPO_ID + " = " + id, null);
    }

}
