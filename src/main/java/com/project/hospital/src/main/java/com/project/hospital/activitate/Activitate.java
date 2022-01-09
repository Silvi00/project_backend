package com.project.hospital.activitate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table(name = "activitate")
public class Activitate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @JsonFormat(pattern = "HH:mm")
//    private LocalTime ora;
    private String ora;
    private Date data;
    private String subiect;
    private String descriere;

    public Activitate() {
    }

    public Activitate(String ora, Date data, String subiect, String descriere) {
        this.ora = ora;
        this.data = data;
        this.subiect = subiect;
        this.descriere = descriere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSubiect() {
        return subiect;
    }

    public void setSubiect(String subiect) {
        this.subiect = subiect;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
