package com.fortes.dao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.fortes.contatos.R;
import com.fortes.model.Contato;

import java.util.List;

/**
 * Created by  Rodrigo Fortes
 */

public class ContactAdapter extends BaseAdapter {

    private Context context;

    private List<Contato> contatos;
    private LayoutInflater inflater;

    public ContactAdapter(Context context, List<Contato> contatos) {
        super();
        this.context = context;
        this.contatos = contatos;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void notifyDataSetChanged() {
        try {
            super.notifyDataSetChanged();
        } catch (Exception e) {
            trace("Erro: " + e.getMessage());
        }
    }

    private void trace(String msg) {
        toast(msg);
    }

    public void toast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public int getCount() {
        return contatos.size();
    }

    public void remove(final Contato contato) {
        this.contatos.remove(contato);
    }

    public void add(final Contato contato) {
        this.contatos.add(contato);
    }

    public Object getItem(int position) {
        return contatos.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup viewGroup2) {
        try {
            Contato contato = contatos.get(position);

            ViewHolder holder;

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.contact_line, null);

                holder = new ViewHolder();
                holder.tvNome = (TextView) convertView.findViewById(R.id.tvNome
                );
                holder.tvEmail = (TextView) convertView.findViewById(R.id.tvEmail);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.tvNome.setText(contato.getNome());
            holder.tvEmail.setText(contato.getEmail());

            return convertView;
        } catch (Exception e) {
            trace("Erro: " + e.getMessage());
        }

        return convertView;
    }

    static class ViewHolder {
        public TextView tvNome;
        public TextView tvTelefone;
        public TextView tvEmail;
    }
}
