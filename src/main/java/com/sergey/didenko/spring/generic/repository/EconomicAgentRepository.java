package com.sergey.didenko.spring.generic.repository;

import com.sergey.didenko.spring.generic.domain.EconomicAgent;
import com.sergey.didenko.spring.generic.domain.EconomicSector;
import com.sergey.didenko.spring.generic.repository.abstr.EntityWithOwnerRepositoryInterface;
import org.springframework.stereotype.Repository;

/**
 * TODO : Inherited methods From EntityWithOwnerRepositoryInterface.java:
 *
 * List<E> findAllByOwner(O_E owner);
 */
@Repository
public interface EconomicAgentRepository extends EntityWithOwnerRepositoryInterface<EconomicAgent, EconomicSector, Long> {

}
