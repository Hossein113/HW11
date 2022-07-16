package maktab74.practice11.org.base.service;

import maktab74.practice11.org.base.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity<ID>, ID extends Serializable> {


    E saveAndEdit(E e);

    void delelt(ID id);

    Long countAll();

    E findById(ID id);

    List<E> findList();




}
