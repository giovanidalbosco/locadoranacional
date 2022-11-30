package br.univille.locadoranacional.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String marca;
    private String modelo;
    private String placa;
    private String cor;
    private float custoDiaria;
    private String foto;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getCustoDiaria() {
        return custoDiaria;
    }
    public void setCustoDiaria(float custoDiaria) {
        this.custoDiaria = custoDiaria;
    }
    
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }

}
