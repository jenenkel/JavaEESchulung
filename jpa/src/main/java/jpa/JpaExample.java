package jpa;

import javax.persistence.*;
import java.util.Arrays;

public class JpaExample {
    public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // TODO Objekte erzeugen
            Person father = new Person("Bob");
            Person mother = new Person("Alice");
            Person son = new Person("Carlos");

            Family theSmiths = new Family("Smith", Arrays.asList(father, mother, son));
            father.setFamily(theSmiths);
            mother.setFamily(theSmiths);
            son.setFamily(theSmiths);

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            try {
                // TODO Objekte persistieren
                entityManager.persist(theSmiths);

                transaction.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
            }

            entityManager.clear();
            // TODO Objekte abfragen
            Query query = entityManager.createQuery("select f from Family f where f.name = 'Smith'", Family.class);
            Family family = (Family) query.getSingleResult();
            System.out.println(family.getMembers());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
            System.exit(0);
        }
    }
}
