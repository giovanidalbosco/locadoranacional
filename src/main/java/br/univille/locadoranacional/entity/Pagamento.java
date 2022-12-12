package br.univille.locadoranacional.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String metodo;
    private int numero;
    private Date validade;
    private int codSeguranca;
    private String parcelas;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMetodo() {
        return metodo;
    }
    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public Date getValidade() {
        return validade;
    }
    public void setValidade(Date validade) {
        this.validade = validade;
    }
    public int getCodSeguranca() {
        return codSeguranca;
    }
    public void setCodSeguranca(int codSeguranca) {
        this.codSeguranca = codSeguranca;
    }
    public String getParcelas() {
        return parcelas;
    }
    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    
}
