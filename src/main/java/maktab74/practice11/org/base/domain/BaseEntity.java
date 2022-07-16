package maktab74.practice11.org.base.domain;

import java.io.Serializable;

public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    private ID id;

    public BaseEntity() {
    }

    public BaseEntity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
