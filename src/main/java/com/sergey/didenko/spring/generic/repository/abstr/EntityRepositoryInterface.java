package com.sergey.didenko.spring.generic.repository.abstr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityRepositoryInterface<E, ID> extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {

}
