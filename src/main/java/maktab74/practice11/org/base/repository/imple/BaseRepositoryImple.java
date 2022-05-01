package maktab74.practice11.org.base.repository.imple;

import maktab74.practice11.org.base.domain.BaseEntity;
import maktab74.practice11.org.base.repository.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

public abstract class BaseRepositoryImple<E extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<E, ID> {

    protected final EntityManager entityManager;
    private Class<E> entityClass;

    public BaseRepositoryImple(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;

    }

    public abstract Class<E> entityClass();

    @Override
    public E saveAndEdit(E e) {
        beginTransaction();
        if (e.getId() != null) {
            entityManager.persist(e);
        } else {
            entityManager.merge(e);
        }
        commitTransaction();
        return e;
    }

    @Override
    public void delelt(ID id) {
        entityManager.createQuery("delete from" + entityClass.getSimpleName() +
                " e where e.id=:id ").setParameter("id", id).executeUpdate();

    }

    @Override
    public E findById(ID id) {

        return entityManager.find(entityClass, id);
        //return entityManager.createQuery("select e form"+entityClass.getSimpleName()+" e where" +
        //   " e.id =: id" ,entityClass ).setParameter("id",id).getSingleResult();
    }

    @Override
    public Long countAll() {
        return entityManager.createQuery("select count (id) from" + entityClass + " e",
                Long.class).getSingleResult();
    }

    @Override
    public List<E> findList() {
        return entityManager.createQuery("select e form" + entityClass.getSimpleName() + " e",
                entityClass).getResultList();
    }

    @Override
    public EntityTransaction getTransaction() {
        return entityManager.getTransaction();
    }


    @Override
    public void commitTransaction() {
        getTransaction().commit();
    }

    @Override
    public void beginTransaction() {
        if (!entityManager.getTransaction().isActive()) {
            getTransaction().begin();
        }
    }

    @Override
    public void rollBackTransaction() {
        getTransaction().rollback();
    }
}
