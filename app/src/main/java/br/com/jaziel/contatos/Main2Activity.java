package br.com.jaziel.contatos;

import android.app.AlertDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;

import br.com.jaziel.contatos.database.DataBase;
import br.com.jaziel.contatos.dominio.RepositorioContato;
import br.com.jaziel.contatos.dominio.entidades.Contato;

public class Main2Activity extends AppCompatActivity {


    private EditText edtNome;
    private EditText edtFone;
    private EditText edtEmail;
    private EditText edtEnderco;
    private EditText edtDataEspeciais;
    private EditText edtGrupos;

    private Spinner spnFone;
    private Spinner spnEmail;
    private Spinner spnEndereco;
    private Spinner spnDataEspeciais;

    private ArrayAdapter<String>  adpTipoEmail;
    private ArrayAdapter<String> adpTipoFone;
    private ArrayAdapter<String> adpTipoEndereco;
    private ArrayAdapter<String> adpTipoDataEspeciais;

    private DataBase dataBase;
    private SQLiteDatabase com;
    private RepositorioContato repositorioContato;
    private Contato contato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtNome = (EditText)findViewById(R.id.edtNome);
        edtFone = (EditText)findViewById(R.id.edtFone);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtEnderco = (EditText)findViewById(R.id.edtEndereco);
        edtDataEspeciais = (EditText)findViewById(R.id.edtDataEspeciais);
        edtGrupos = (EditText)findViewById(R.id.edtGrupos);

        spnFone = (Spinner)findViewById(R.id.spnFone);
        spnEmail = (Spinner)findViewById(R.id.spnEmail);
        spnEndereco = (Spinner)findViewById(R.id.spnEndereco);
        spnDataEspeciais = (Spinner)findViewById(R.id.spnDataEspeciais);

        adpTipoFone = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        adpTipoFone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpTipoEmail = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        adpTipoEmail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpTipoEndereco = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        adpTipoEndereco.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpTipoDataEspeciais = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        adpTipoDataEspeciais.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnFone.setAdapter(adpTipoFone);
        spnEmail.setAdapter(adpTipoEmail);
        spnEndereco.setAdapter(adpTipoEndereco);
        spnDataEspeciais.setAdapter(adpTipoDataEspeciais);

        adpTipoFone.add("PESSOAL");
        adpTipoFone.add("CASA");
        adpTipoFone.add("TRABALHO");
        adpTipoFone.add("OUTROS");

        adpTipoEmail.add("PESSOAL");
        adpTipoEmail.add("CASA");
        adpTipoEmail.add("TRABALHO");
        adpTipoEmail.add("OUTROS");

        adpTipoEndereco.add("CASA");
        adpTipoEndereco.add("TRABALHO");
        adpTipoEndereco.add("OUTROS");

        adpTipoDataEspeciais.add("ANIVERSARIO");
        adpTipoDataEspeciais.add("OUTROS");

        try {

            dataBase = new DataBase(this);
            // com = dataBase.getReadableDatabase(); somente para inserir
            com = dataBase.getWritableDatabase(); //para update

            repositorioContato = new RepositorioContato(com);


        } catch (android.database.SQLException ex) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("ERRO COM BANCO DE DADOS " + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }





    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // int id = item.getItemId();
        //if (id == R.id.action_settings) {
        //      return true;
        //}

        switch (item.getItemId()) {
            case R.id.action1Menu:

                break;
            case R.id.action2Menu:

                break;
            default:

                break;

        }

        return super.onOptionsItemSelected(item);


    }
    private  void inserir(){


        contato = new Contato();
        contato.setNome(edtNome.getText().toString());
        contato.setTelefone(edtFone.getText().toString());
        contato.setTipoEmail(edtEmail.getText().toString());
        contato.setEndereco(edtEnderco.getText().toString());

        Date date = new Date();

        contato.setDataEspeciais(date);

        contato.setGrupos(edtGrupos.getText().toString());

    }


}
