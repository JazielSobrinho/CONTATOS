package br.com.jaziel.contatos.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import br.com.jaziel.contatos.dominio.entidades.Contato;

/**
 * Created by LAB56 on 12/11/2015.
 */
public class RepositorioContato {

    private SQLiteDatabase com;

    public RepositorioContato(SQLiteDatabase com) {

        this.com = com;

    }

    public void inserir(Contato contato){

        ContentValues values = new ContentValues();
        values.put("NOME",contato.getNome());
        values.put("TELEFONE", contato.getTelefone());
        values.put("TIPOTELEFONE", contato.getTipoTelefone());
        values.put("EMAIL", contato.getEmail());
        values.put("TIPOEMAIL",contato.getTipoEmail());
        values.put("ENDERECO", contato.getEndereco());
        values.put("TIPOENDERECO", contato.getTipoEndereco());
        values.put("DATASESPECIAIS", contato.getDataEspeciais().getTime());
        values.put("TIPODATAESPECIAIS", contato.getTipoEndereco());
        values.put("GRUPOS",    contato.getGrupos());



        com.insertOrThrow("CONTATO", null, values);
    }

    public void testeInserirContatos() {

        for (int i = 0; i < 10; i++) {
            ContentValues values = new ContentValues();
            values.put("TELEFONE", "9111 5357");
            com.insertOrThrow("CONTATO", null, values);
        }


    }

    public ArrayAdapter<String> buscacontatos(Context context) {

        ArrayAdapter<String> adpcontatos = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_activated_1);

        Cursor cursor = com.query("CONTATO", null, null, null, null, null, null);

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();
            do {

                String telefone = cursor.getString(1);
                adpcontatos.add(telefone);

            } while (cursor.moveToNext());


        }
        return adpcontatos;


    }


}
