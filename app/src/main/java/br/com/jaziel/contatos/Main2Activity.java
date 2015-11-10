package br.com.jaziel.contatos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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





    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
