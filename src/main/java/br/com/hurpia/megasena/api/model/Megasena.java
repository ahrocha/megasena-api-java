package br.com.hurpia.megasena.api.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "sorteio")
public class Megasena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "sorteados", length = 130)
    private String sorteados;

    @Column(name = "status", nullable = false)
    private Integer status;

    public Megasena() {
        // Default Constructor (Required by JPA)
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSorteados() {
        return sorteados;
    }

    public void setsorteados(String sorteados) {
        this.sorteados = sorteados;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
