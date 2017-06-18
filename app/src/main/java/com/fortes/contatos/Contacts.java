package com.fortes.contatos;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.fortes.dao.BaseDAO;
import com.fortes.dao.ContactAdapter;
import com.fortes.dao.ContactDAO;
import com.fortes.model.Contato;

import java.util.List;

/**
 * Created by  Rodrigo Fortes
 */

public class Contacts extends AppCompatActivity {

    private ContactDAO contatoDAO;
    private List<Contato> contatos;
    private ContactAdapter adapter;
    private BaseDAO baseDAO;
    private int posicao = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        baseDAO = new BaseDAO(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contacts_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.register:
                    Intent intent = new Intent(this, Contact.class);
                    startActivity(intent);
                }
        return true;
    }

    @Override
    protected void onResume() {
        contatoDAO = new ContactDAO(this);
        contatoDAO.open();
        contatos = contatoDAO.getAll();

        adapter = new ContactAdapter(this, contatos);
        ListView listView = (ListView)findViewById(android.R.id.list);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int codigo;
                codigo = contatos.get(position).getId();
                Intent intent = new Intent(Contacts.this, Contact.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });

        super.onResume();
    }
}
