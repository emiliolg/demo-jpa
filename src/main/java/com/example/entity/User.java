package com.example.entity;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String email;

    @ManyToOne(targetEntity = Office.class)
    @JoinColumn(name = "office_id")
    private Office office;

    @Embedded
// Si queres cambiar los nombres de la columnas de la tabla
//    @AttributeOverrides(value = {
//            @AttributeOverride(name = "areaCode", column = @Column(name = "phone_area_code")),
//            @AttributeOverride(name = "number", column = @Column(name = "phone_number"))
//    })
// Si queres cambiar el nombre de la columna de la tabla
//    @AssociationOverrides(value = {
//            @AssociationOverride(name = "pais", joinColumns = @JoinColumn(name = "phone_pais_id"))
//    })
    private Phone phone;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Office getOffice() {
        return office;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
