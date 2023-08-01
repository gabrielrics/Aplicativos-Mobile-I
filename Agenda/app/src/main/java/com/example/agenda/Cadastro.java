package com.example.agenda;

import android.annotation.SuppressLint;
import android.app.Service;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;



public class Cadastro extends AppCompatActivity {

    EditText Codigo;
    EditText Nome;
    EditText Celular;
    EditText Valor;
    EditText CPF;
    Button bntSalvar;
    Button bntExcluir;
    Button bntLimpar;
    ListView viewPessoa;

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    InputMethodManager imm;

    BancoDados db = new BancoDados(this);

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imm = (InputMethodManager) this.getSystemService(Service.INPUT_METHOD_SERVICE);

        Codigo = findViewById(R.id.Cadastro);

        Nome = findViewById(R.id.edt_nome);
        Celular = findViewById(R.id.edt_celular);
        Valor = findViewById(R.id.edt_valor);
        CPF = findViewById(R.id.edt_CPF);
        bntSalvar = findViewById(R.id.bntSalvar);
        bntExcluir = findViewById(R.id.bntExcluir);
        bntLimpar = findViewById(R.id.bntLimpar);
        viewPessoa = findViewById(R.id.listViewPessoa);

        Nome.requestFocus();

        viewPessoa.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, int position, long id) {
                String conteudo = (String) viewPessoa.getItemAtPosition(position);

                String codigo = conteudo.substring(0, conteudo.indexOf("-"));

                Pessoa pessoa = db.selecionarPessoa(Integer.parseInt(codigo));

                Codigo.setText(String.valueOf(pessoa.getCodigo()));
                Nome.setText(pessoa.getNome());
                Celular.setText(pessoa.getCelular());
                Valor.setText(pessoa.getValor());
                CPF.setText(pessoa.getCPF());

            }
        });
        bntLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparCampos();

            }

            private void limparCampos() {
            }
        });

        bntSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String codigo = Codigo.getText().toString();
                String nome = Nome.getText().toString();
                String telefone = Celular.getText().toString();
                String email = Valor.getText().toString();
                String endereco = CPF.getText().toString();

                if (nome.isEmpty()) {
                    Nome.setError("Este campo é obrigatorio");
                } else if (codigo.isEmpty()) {

                    String valor;
                    db.addPessoa(new Pessoa(Nome, Celular, Valor, CPF));
                    Toast.makeText(Cadastro.this, "Cadastro salvo com sucesso", Toast.LENGTH_SHORT).show();
                    listaPessoa();
                    limparCampos();
                    escondeTeclado();

                } else {
                    db.atualizarPessoa(new Pessoa(Integer.parseInt(codigo), nome, telefone, email, endereco));
                    Toast.makeText(Cadastro.this, "Cadastro atualizado com sucesso", Toast.LENGTH_SHORT).show();
                    listaPessoa();
                    limpaCampos();
                    escondeTeclado();

                }
            }
        });

        bntExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String codigo = Codigo.getText().toString();
                if (codigo.isEmpty()) {
                    Toast.makeText(Cadastro.this, "Nenhuma pessoa está selecionada", Toast.LENGTH_SHORT).show();
                } else {

                    Pessoa pessoa = new Pessoa();
                    pessoa.setCodigo(Integer.parseInt(codigo));
                    db.apagarPessoa(pessoa);
                    Toast.makeText(Cadastro.this, "Registro da pessoa apagada com sucesso", Toast.LENGTH_SHORT).show();
                    Codigo.setText("");
                    listaPessoa();
                    limpaCampos();
                }

            }
        });


    void escondeTeclado(){
        imm.hideSoftInputFromWindow( Nome.getWindowToken(),0 );
    }

    public void limpaCampos(){
        Codigo.setText("");
        Nome.setText("");
        Celular.setText("");
        Valor.setText("");
        CPF.setText("");

        Nome.requestFocus();
    }

        public void listaPessoa(){

            List<Pessoa> pessoas = db.listaPessoa();

            arrayList = new ArrayList<String>();

            adapter = new ArrayAdapter<String>(Cadastro.this, android.R.layout.simple_list_item_1, arrayList);

            viewPessoa.setAdapter(adapter);

            for (Pessoa c : pessoas) {
                //Log.d( "Lista", "\nID: " + c.getCodigo() + "Nome: " + c.getNome(  ));            //arrayList. add( c.getCodigo() + "-" + c.getCodigo());
                arrayList.add(c.getCodigo() + "-" + c.getNome());
                adapter.notifyDataSetChanged();
            }

        }
    }
}