package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.entities.Product;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(),new HashMap<>()) ;


        EntityManager em = emf.createEntityManager();

       try {
           em.getTransaction().begin();

           Product p = new Product();
           p.setId(1L);
           p.setName("USopp");

           em.persist(p);


           em.getTransaction().commit();
       }finally {
           em.close();

       }

    }
}