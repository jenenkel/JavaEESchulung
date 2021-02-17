package jpa;

import javax.persistence.*;

public class JpaExample {
    public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // TODO Objekte erzeugen

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            try {
                // TODO Objekte persistieren

                transaction.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
            }

            entityManager.clear();
            // TODO Objekte abfragen
            Query query = entityManager.createQuery("select x from ... x where ...");
            System.out.println(query.getResultList());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
            System.exit(0);
        }
    }
}
