package com.example.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable()
public class Phone {
    int areacode;
    int number;

    @ManyToOne
    Pais pais;

    public Phone(int codArea, int number, Pais pais) {
        this.areacode = codArea;
        this.number = number;
        this.pais = pais;
    }

    public Phone() {
    }

}
