package com.project.hospital.consultatie;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table(name = "consultatie")
public class Consultatie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CNP;
    private String nume;
    private String prenume;
    private Date dataConsultatie;
    private String simptome;
    private String diagnostic;
    private String prescriptie;

    public Consultatie() {
    }

    public Consultatie(String CNP, String nume, String prenume, Date dataConsultatie, String simptome, String diagnostic, String prescriptie) {
        this.CNP = CNP;
        this.nume = nume;
        this.prenume = prenume;
        this.dataConsultatie = dataConsultatie;
        this.simptome = simptome;
        this.diagnostic = diagnostic;
        this.prescriptie = prescriptie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Date getDataConsultatie() {
        return dataConsultatie;
    }

    public void setDataConsultatie(Date dataConsultatie) {
        this.dataConsultatie = dataConsultatie;
    }

    public String getSimptome() {
        return simptome;
    }

    public void setSimptome(String simptome) {
        this.simptome = simptome;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getPrescriptie() {
        return prescriptie;
    }

    public void setPrescriptie(String prescriptie) {
        this.prescriptie = prescriptie;
    }
}
