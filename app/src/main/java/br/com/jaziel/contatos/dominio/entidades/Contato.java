package br.com.jaziel.contatos.dominio.entidades;

import java.util.Date;

/**
 * Created by DEVELOPER on 13-Nov-15.
 */
public class Contato {

    private long id;
    private String nome;
    private String telefone;
    private String tipoTelefone;
    private String email;
    private String tipoEmail;
    private String endereco;
    private String tipoEndereco;
    private Date dataEspeciais;
    private String tipoDataEspecial;
    private String grupos;

     public Contato(){


     }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoEmail() {
        return tipoEmail;
    }

    public void setTipoEmail(String tipoEmail) {
        this.tipoEmail = tipoEmail;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Date getDataEspeciais() {
        return dataEspeciais;
    }

    public void setDataEspeciais(Date dataEspeciais) {
        this.dataEspeciais = dataEspeciais;
    }

    public String getTipoDataEspecial() {
        return tipoDataEspecial;
    }

    public void setTipoDataEspecial(String tipoDataEspecial) {
        this.tipoDataEspecial = tipoDataEspecial;
    }

    public String getGrupos() {
        return grupos;
    }

    public void setGrupos(String grupos) {
        this.grupos = grupos;
    }
}
