package com.example.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class BancoDados extends SQLiteOpenHelper {

    public static final int VERSAO_BANCO = 1;
    public static final String BANCO_AGENDA = "db_agenda";


    public BancoDados(Context content) {
        super(content, BANCO_AGENDA, null, VERSAO_BANCO);
    }

    public static final String TABELA_PESSOA = "tb_pessoa";

    public static final String COLUNA_CODIGO = "codigo";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_VALOR = "valor";
    public static final String COLUNA_CELULAR = "celular";

    public static final String COLUNA_CPF = "CPF";


    // Criando a tabela do banco de dados
    @Override
    public void onCreate(SQLiteDatabase db) { //esse "db" pode ser qualquer nome, porém foi colocado pq é o resumo de "database".

        String CRIAR_TABELA = "CREATE TABLE " + TABELA_PESSOA + "("
                + COLUNA_CODIGO + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUNA_NOME + "TEXT,"
                + COLUNA_VALOR + "TEXT,"
                + COLUNA_CELULAR + "TEXT,"
                + COLUNA_CPF + "TEXT)";

        db.execSQL(CRIAR_TABELA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // Adicionar todos os dados que foram inseridos.
    void addPessoa(Pessoa pessoa) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valor = new ContentValues();

        valor.put(COLUNA_NOME, pessoa.getNome());
        valor.put(COLUNA_CELULAR, pessoa.getCelular());
        valor.put(COLUNA_VALOR, pessoa.getValor());
        valor.put(COLUNA_CPF, pessoa.getCPF());

        db.insert(TABELA_PESSOA, null, valor);
        db.close();

    }

    //Apagar as informações da pessoa do banco.
    void apagarPessoa(Pessoa pessoa) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABELA_PESSOA, COLUNA_CODIGO + "=?", new String[]{
                String.valueOf(pessoa.getCodigo())
        });

        db.close();
    }


    //Pegar uma conta.
    Pessoa selecionarPessoa(int codigo) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABELA_PESSOA, new String[]{COLUNA_CODIGO, COLUNA_NOME, COLUNA_VALOR, COLUNA_CELULAR, COLUNA_CPF},
                COLUNA_CODIGO + "=?", new String[]{String.valueOf(codigo)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Pessoa pessoa = new Pessoa(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

        return pessoa;

    }

    void atualizarPessoa(Pessoa pessoa) { // Seria um update.

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valor = new ContentValues();

        valor.put(COLUNA_NOME, pessoa.getNome());
        valor.put(COLUNA_VALOR, pessoa.getValor());
        valor.put(COLUNA_CELULAR, pessoa.getCelular());
        valor.put(COLUNA_CPF, pessoa.getCPF());

        db.update(TABELA_PESSOA, valor, COLUNA_CODIGO + " =?", new String[]{String.valueOf(pessoa.getCodigo())});

        db.close();
    }



    public List<Pessoa> listaPessoa() {

        List<Pessoa> pessoaLista = new ArrayList<Pessoa>();

        String query = "SELECT * FROM " + TABELA_PESSOA;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                Pessoa pessoa = new Pessoa();

                pessoa.setCodigo(Integer.parseInt(cursor.getString(0) != null ? cursor.getString(0) : "0"));
                pessoa.setNome(cursor.getString(1));
                pessoa.setValor(cursor.getString(2));
                pessoa.setCelular(cursor.getString(3));
                pessoa.setCPF(cursor.getString(4));

                pessoaLista.add(pessoa);

            } while (cursor.moveToNext());
        }

        return pessoaLista;

    }
}