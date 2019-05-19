package com.sergey.didenko.spring.generic.criteria.service.abstr;

import io.github.jhipster.service.QueryService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class QueryServiceAbstr<E, C> extends QueryService<E> {

    public QueryServiceAbstr() {}

    //TODO : create here new Specification<E>
    @Transactional
    public abstract Specification<E> createSpecificationByCriteria(C criteria);
}
