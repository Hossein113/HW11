package maktab74.practice11.org.base.service.imple;

import maktab74.practice11.org.base.domain.BaseEntity;
import maktab74.practice11.org.base.repository.BaseRepository;
import maktab74.practice11.org.base.service.BaseService;

import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

public class BaseServiceImple<E extends BaseEntity<ID>, ID extends Serializable, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {
    protected final R repository;

    public BaseServiceImple(R repository) {
        this.repository = repository;
    }

    @Override
    public E saveAndEdit(E e) {
        return null;
    }

    @Override
    public void delelt(ID id) {

    }

    @Override
    public Long countAll() {
        return repository.countAll();
    }

    @Override
    public E findById(ID id) {
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
