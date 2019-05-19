package com.sergey.didenko.spring.generic.criteria.service;

import com.sergey.didenko.spring.generic.criteria.model.EconomicSectorCriteria;
import com.sergey.didenko.spring.generic.criteria.predicate.JoinPredicate;
import com.sergey.didenko.spring.generic.domain.*;
import com.sergey.didenko.spring.generic.criteria.service.abstr.QueryServiceAbstr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EconomicSectorQueryService extends QueryServiceAbstr<EconomicSector, EconomicSectorCriteria> {

    @Autowired
    public EconomicSectorQueryService() {}

    @Override
    @Transactional
    public Specification<EconomicSector> createSpecificationByCriteria(EconomicSectorCriteria criteria) {
        Specification<EconomicSector> specification = null;
        boolean wherePresent = false;

        //
        if (criteria.getId() != null) {
            specification = Specification.where(buildSpecification(criteria.getId(), EconomicSector_.id));
            wherePresent = true;
        }

        //
        if (criteria.getName() != null) {
            if (!wherePresent) {
                specification = Specification.where(buildStringSpecification(criteria.getName(), EconomicSector_.name));
                wherePresent = true;
            } else {
                specification = specification.and(buildStringSpecification(criteria.getName(), EconomicSector_.name));
            }
        }

        //if criteria not exist
        if (!wherePresent) {
            specification =  new JoinPredicate<EconomicSector, String>().findAll(EconomicSector_.id);
        }

        return specification;
    }
}
