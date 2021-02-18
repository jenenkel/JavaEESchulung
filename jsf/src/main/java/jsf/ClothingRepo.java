package jsf;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class ClothingRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void persist(Clothing clothing) {
        entityManager.persist(clothing);
    }

    public Clothing findById(long id) {
        return entityManager.find(Clothing.class, id);
    }

    public List<Clothing> getAllSelected() {
        Query query = entityManager.createQuery("select c from Clothing c where c.selected = 'TRUE'");
        return (List<Clothing>) query.getResultList();
    }
}
