package com.snim.notes.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "notes")
public class Note {
    @Id
    private Long id;
    private String createur;
    private Date createdAt;
    private String ecole;
    private String anneeScolaire;
}
