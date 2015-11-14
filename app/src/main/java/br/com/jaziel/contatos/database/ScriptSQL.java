package br.com.jaziel.contatos.database;

/**
 * Created by LAB56 on 10/11/2015.
 */
public class ScriptSQL {

    public static String getCreateContao() {

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS CONTATO( ");
        sqlBuilder.append("_id                INTEGER NOT NULL ");
        sqlBuilder.append("PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("NOME      VARCHA(255), ");
        sqlBuilder.append("TELEFONE      VARCHA(14), ");
        sqlBuilder.append("TIPOTELEFONE  VARCHAR(1), ");
        sqlBuilder.append("EMAIL         VARCHAR(255), ");
        sqlBuilder.append("TIPOEMAIL     VARCHAR(1), ");
        sqlBuilder.append("ENDERECO      VARCHAR(255), ");
        sqlBuilder.append("TIPOENDERECO  VARCHAR(1), ");
        sqlBuilder.append("DATASESPECIAIS DATE, ");
        sqlBuilder.append("TIPODATAESPECIAIS VARCHAR(1), ");
        sqlBuilder.append("GRUPOS       VARCHAR(255) ");
        sqlBuilder.append(");");

        return sqlBuilder.toString();
    }

}
