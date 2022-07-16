package maktab74.practice11.org.base.repository;

import maktab74.practice11.org.base.domain.BaseEntity;

import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends Serializable> {

    E saveAndEdit(E e);

    void delelt(ID id);

    Long countAll();

    E findById(ID id);

    List<E> findList();

    EntityTransaction getTransaction();

    void commitTransaction();

    void beginTransaction();

    void rollBackTransaction();
}
