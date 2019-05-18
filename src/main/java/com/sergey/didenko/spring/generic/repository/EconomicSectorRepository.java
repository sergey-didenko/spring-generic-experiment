package com.sergey.didenko.spring.generic.repository;

import com.sergey.didenko.spring.generic.domain.EconomicSector;
import com.sergey.didenko.spring.generic.repository.abstr.EntityRepositoryInterface;
import org.springframework.stereotype.Repository;

@Repository
public interface EconomicSectorRepository extends EntityRepositoryInterface<EconomicSector, Long> {

}
