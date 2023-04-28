package com.example.cadastro;
import android.content.Context;
import android.database.sqlite.SQLdatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDados extends SQLiteOpenHelper {

    public static  final int VERSAO_BANCO = 1;
    public static final String BANCO_CADASTRO = "db_cadastro";

    public BancoDados(Context content){

        super(content, BANCO_CADASTRO, null, VERSAO_BANCO);
    }

    public static final String TABELA_CADASTRO = "tb_cadastro";

    public static final String COLUNA_CODIGO = "codigo";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_SOBRENOME = "sobrenome";
    public static final String COLUNA_EMAIL = "email";
    public static final String COLUNA_SENHA = "senha";


}
