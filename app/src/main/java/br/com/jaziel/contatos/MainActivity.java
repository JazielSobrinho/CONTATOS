package br.com.jaziel.contatos;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private EditText edtpesquisar;
    private ImageButton btnAdicionar;
    private ListView lstContatos;

    private DataBase dataBase;
    private SQLiteDatabase com;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtpesquisar = (EditText) findViewById(R.id.edtPesquisa);
        lstContatos = (ListView) findViewById(R.id.lstContatos);

        try {
            dataBase = new DataBase(this);
            com = dataBase.getReadableDatabase();
        } catch (android.database.SQLException ex) {

        }
    }





     public void abrirNovaTela(View view){
          Intent i = new Intent(this, Main2Activity.class);
         startActivity(i);
      //abrrir nova tela

    }


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
