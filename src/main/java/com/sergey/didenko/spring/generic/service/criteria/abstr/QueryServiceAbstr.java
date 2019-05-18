package com.sergey.didenko.spring.generic.service.criteria.abstr;

import io.github.jhipster.service.QueryService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public abstract class QueryServiceAbstr<E, C> extends QueryService<E> {

    public QueryServiceAbstr() {}

    //TODO : create here new Specification<E>
    @Transactional(readOnly = true)
    public abstract Specification<E> createSpecificationByCriteria(C criteria);
}
