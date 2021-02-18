package jsf;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class CustomerRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void persist(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer findById(long id) {
        return entityManager.find(Customer.class, id);
    }
}
