package maktab74.practice11.org.base.service.imple;

import maktab74.practice11.org.base.domain.BaseEntity;
import maktab74.practice11.org.base.repository.BaseRepository;
import maktab74.practice11.org.base.service.BaseService;

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
        return repository.saveAndEdit(e);
    }

    @Override
    public void delelt(ID id) {
        repository.delelt(id);
    }

    @Override
    public Long countAll() {
        return repository.countAll();
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findList() {
        return repository.findList();
    }


    }

