package br.com.jaziel.contatos.dominio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

/**
 * Created by LAB56 on 12/11/2015.
 */
public class RepositorioContato {

    private SQLiteDatabase com;

    public RepositorioContato(SQLiteDatabase com) {

        this.com = com;

    }

    public ArrayAdapter<String> buscacontatos(Context context) {

        ArrayAdapter<String> adpcontatos = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_activated_1);

        Cursor cursor = com.query("CONTATO", null, null, null, null, null, null);

        if (cursor.getCount() > 0) {

            do {

                String telefone = cursor.getString(1);
                adpcontatos.add(telefone);

            } while (cursor.moveToNext());


        }
        return adpcontatos;


    }


}
