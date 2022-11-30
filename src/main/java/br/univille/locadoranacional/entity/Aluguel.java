package br.univille.locadoranacional.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int diarias;
    private Date dataRetirada;
    private Date dataEntrega;
   
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Cliente cliente;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Funcionario funcionario;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Carro carro;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Pagamento pagamento;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getDiarias() {
        return diarias;
    }
    public void setDiarias(int diarias) {
        this.diarias = diarias;
    }
    public Date getDataRetirada() {
        return dataRetirada;
    }
    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }
    public Date getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    
    
}
