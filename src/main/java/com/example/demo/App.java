package com.example.demo;

import com.example.entity.Office;
import com.example.entity.Pais;
import com.example.entity.Phone;
import com.example.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("aca");
            EntityManager entityManager = Persistence
                    .createEntityManagerFactory("user-unit")
                    .createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();

            /* Persist a User entity */
            entityTransaction.begin();
            Office office = new Office("Buenos Aires");
            User user = new User("Alejandro", "alejandro@domain.com");
            Pais pais = entityManager.find(Pais.class, "ar");
            user.setPhone(new Phone(11, 59566007, pais));
            office.addUser(user);
            entityManager.persist(office);
            entityTransaction.commit();

            /* Fetch a User entity */
            int id = user.getId();

            /* Update a User entity */
            {
                entityTransaction.begin();
                user = entityManager.find(User.class, id);
                user.setName("Alex");
                user.setEmail("alex@domain.com");
                entityManager.merge(user);
                entityTransaction.commit();

                /* Remove a User entity */
//                entityTransaction.begin();
//                user = entityManager.find(User.class, 1);
//                entityManager.remove(user);
//                entityTransaction.commit();
//
                entityManager.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("xxx");
        }
    }
}
