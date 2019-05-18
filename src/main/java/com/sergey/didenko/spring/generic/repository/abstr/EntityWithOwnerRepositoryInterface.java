package com.sergey.didenko.spring.generic.repository.abstr;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface EntityWithOwnerRepositoryInterface<E, O_E, ID> extends EntityRepositoryInterface<E, ID> {

    List<E> findAllByOwner(O_E owner);

}
