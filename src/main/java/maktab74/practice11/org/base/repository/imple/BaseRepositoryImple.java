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
        return null;
    }

    @Override
    public void delelt(ID id) {

    }

    @Override
    public E findById(ID id) {
        return null;
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<E> findList() {
        return null;
    }

    @Override
    public EntityTransaction getTransaction() {
        return null;
    }


    @Override
    public void commitTransaction() {

    }

    @Override
    public void beginTransaction() {

    }

    @Override
    public void rollBackTransaction() {

    }
}
