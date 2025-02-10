package br.com.hurpia.megasena.api.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbSorteio")
public class Megasena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdSorteio")
    private Integer cdSorteio;

    @Column(name = "cdTipoSorteio", nullable = false)
    private Integer cdTipoSorteio;

    @Column(name = "nrSorteio", nullable = false)
    private Integer nrSorteio;

    @Column(name = "dtSorteio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtSorteio;

    @Column(name = "dsSorteadosSorteio", length = 130)
    private String dsSorteadosSorteio;

    @Column(name = "cdStatusSorteio", nullable = false)
    private Integer cdStatusSorteio;

    public Megasena() {
        // Default Constructor (Required by JPA)
    }

    // Getters and Setters
    public Integer getCdSorteio() {
        return cdSorteio;
    }

    public void setCdSorteio(Integer cdSorteio) {
        this.cdSorteio = cdSorteio;
    }

    public Integer getCdTipoSorteio() {
        return cdTipoSorteio;
    }

    public void setCdTipoSorteio(Integer cdTipoSorteio) {
        this.cdTipoSorteio = cdTipoSorteio;
    }

    public Integer getNrSorteio() {
        return nrSorteio;
    }

    public void setNrSorteio(Integer nrSorteio) {
        this.nrSorteio = nrSorteio;
    }

    public Date getDtSorteio() {
        return dtSorteio;
    }

    public void setDtSorteio(Date dtSorteio) {
        this.dtSorteio = dtSorteio;
    }

    public String getDsSorteadosSorteio() {
        return dsSorteadosSorteio;
    }

    public void setDsSorteadosSorteio(String dsSorteadosSorteio) {
        this.dsSorteadosSorteio = dsSorteadosSorteio;
    }

    public Integer getCdStatusSorteio() {
        return cdStatusSorteio;
    }

    public void setCdStatusSorteio(Integer cdStatusSorteio) {
        this.cdStatusSorteio = cdStatusSorteio;
    }
}
