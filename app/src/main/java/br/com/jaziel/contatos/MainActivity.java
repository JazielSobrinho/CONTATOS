package br.com.jaziel.contatos;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import br.com.jaziel.contatos.database.DataBase;
import br.com.jaziel.contatos.dominio.RepositorioContato;

public class MainActivity extends AppCompatActivity {


    private EditText edtpesquisar;
    private ImageButton btnAdicionar;
    private ListView lstContatos;

    private DataBase dataBase;
    private SQLiteDatabase com;
    private RepositorioContato repositorioContato;
    private ArrayAdapter<String> adpContatos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtpesquisar = (EditText) findViewById(R.id.edtPesquisa);
        lstContatos = (ListView) findViewById(R.id.lstContatos);
        btnAdicionar = (ImageButton) findViewById(R.id.btnAdicionar);


        try {

            dataBase = new DataBase(this);
            // com = dataBase.getReadableDatabase(); somente para inserir
            com = dataBase.getWritableDatabase(); //para update

            repositorioContato = new RepositorioContato(com);
            adpContatos = repositorioContato.buscacontatos(this);

            lstContatos.setAdapter(adpContatos);





        } catch (android.database.SQLException ex) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("ERRO COM BANCO DE DADOS " + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }


        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Main2Activity.class);
                startActivity(i);
            }
        });

    }











    /*public void abrirNovaTela(View view){
          Intent i = new Intent(this, Main2Activity.class);
         startActivity(i);
      //abrrir nova tela metodo amador mas porem rapido
      Toast t = Toast.makeText(this,"MENSAGEN",Toast.LENGTH_LONG);
            t.show();
    }
    */


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
