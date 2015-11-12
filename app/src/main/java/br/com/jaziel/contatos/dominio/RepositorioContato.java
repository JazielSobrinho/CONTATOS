package br.com.jaziel.contatos.dominio;

import android.content.Context;
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

        ArrayAdapter<String> adpcontatos = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_activated_1)
    }


}
