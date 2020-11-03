package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Office {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @Column(name = "office_name")
    private String officeName;

    public List<User> getUsers() {
        return users;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "office", orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    public Office(String officeName) {
        this.officeName = officeName;
    }

    public Office() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public void addUser(User user) {
        users.add(user);
        user.setOffice(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return id == office.id &&
                Objects.equals(officeName, office.officeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, officeName);
    }
}
