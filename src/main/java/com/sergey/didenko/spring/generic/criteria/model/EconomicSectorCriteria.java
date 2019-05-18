package com.sergey.didenko.spring.generic.criteria.model;

import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

import java.io.Serializable;

public class EconomicSectorCriteria implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongFilter id;
    private StringFilter name;

    public EconomicSectorCriteria() {}

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EconomicSectorCriteria{" +
            "id=" + id +
            ", name=" + name +
            '}';
    }
}
