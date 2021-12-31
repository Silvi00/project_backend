package com.project.hospital.pacient;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table(name = "pacient")
public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CNP;
    private String nume;
    private String prenume;
    private Date dataNasterii;
    private String sex;
    private String stareCivila;
    @Size(min = 10, max = 10, message = "Numarul de telefon trebuie sa fie format din 10 cifre")
    private String nrTelefon;
    private String adresa;  // strada + nr
    private String oras;
    private String judet;
    private String tara;
    private String antecedente;
    private String persoanaContact;
    @Size(min = 10, max = 10, message = "Numarul de telefon trebuie sa fie format din 10 cifre")
    private String telefonContact;

    public Pacient() {
    }

    public Pacient(String CNP, String nume, String prenume, Date dataNasterii, String sex, String stareCivila, String nrTelefon, String adresa, String oras, String judet, String tara, String antecedente, String persoanaContact, String telefonContact) {
        this.CNP = CNP;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.sex = sex;
        this.stareCivila = stareCivila;
        this.nrTelefon = nrTelefon;
        this.adresa = adresa;
        this.oras = oras;
        this.judet = judet;
        this.tara = tara;
        this.antecedente = antecedente;
        this.persoanaContact = persoanaContact;
        this.telefonContact = telefonContact;
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

    public Date getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Date dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStareCivila() {
        return stareCivila;
    }

    public void setStareCivila(String stareCivila) {
        this.stareCivila = stareCivila;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    public String getPersoanaContact() {
        return persoanaContact;
    }

    public void setPersoanaContact(String persoanaContact) {
        this.persoanaContact = persoanaContact;
    }

    public String getTelefonContact() {
        return telefonContact;
    }

    public void setTelefonContact(String telefonContact) {
        this.telefonContact = telefonContact;
    }
}
