package com.sergey.didenko.spring.generic.repository;

import com.sergey.didenko.spring.generic.domain.EconomicAgent;
import com.sergey.didenko.spring.generic.domain.EconomicSector;
import com.sergey.didenko.spring.generic.repository.abstr.EntityWithOwnerRepositoryInterface;
import org.springframework.stereotype.Repository;

@Repository
public interface EconomicAgentRepository extends EntityWithOwnerRepositoryInterface<EconomicAgent, EconomicSector, Long> {

}
