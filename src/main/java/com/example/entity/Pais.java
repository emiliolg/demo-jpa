package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pais")
public class Pais {
    @Id
    @Column(name= "id")
    String id;
    String name;

    public Pais(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Pais() {

    }
}
