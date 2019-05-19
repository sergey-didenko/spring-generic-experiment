package com.sergey.didenko.spring.generic.criteria.service;

import com.sergey.didenko.spring.generic.criteria.model.EconomicAgentCriteria;
import com.sergey.didenko.spring.generic.criteria.predicate.DoubleJoinPredicate;
import com.sergey.didenko.spring.generic.criteria.predicate.JoinPredicate;
import com.sergey.didenko.spring.generic.domain.*;
import com.sergey.didenko.spring.generic.criteria.service.abstr.QueryServiceAbstr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EconomicAgentQueryService extends QueryServiceAbstr<EconomicAgent, EconomicAgentCriteria> {

    @Autowired
    public EconomicAgentQueryService() {}

    @Override
    @Transactional
    public Specification<EconomicAgent> createSpecificationByCriteria(EconomicAgentCriteria criteria) {
        Specification<EconomicAgent> specification = null;
        boolean wherePresent = false;

        //
        if (criteria.getId() != null) {
            specification = Specification.where(buildSpecification(criteria.getId(), EconomicAgent_.id));
            wherePresent = true;
        }

        //
        if (criteria.getEconomicSector() != null) {
            Specification<EconomicAgent> economicSectorPredicate = new DoubleJoinPredicate<EconomicAgent, EconomicSector, String>()
                .like(criteria.getEconomicSector().getContains(), EconomicAgent_.owner, EconomicSector_.name);

            if (!wherePresent) {
                specification = Specification.where(economicSectorPredicate);
                wherePresent = true;
            } else {
                specification = specification.and(economicSectorPredicate);
            }
        }

        //
        if (criteria.getName() != null) {
            if (!wherePresent) {
                specification = Specification.where(buildStringSpecification(criteria.getName(), EconomicAgent_.name));
                wherePresent = true;
            } else {
                specification = specification.and(buildStringSpecification(criteria.getName(), EconomicAgent_.name));
            }
        }

        //
        if (criteria.getAddr() != null) {
            if (!wherePresent) {
                specification = Specification.where(buildStringSpecification(criteria.getAddr(), EconomicAgent_.addr));
                wherePresent = true;
            } else {
                specification = specification.and(buildStringSpecification(criteria.getAddr(), EconomicAgent_.addr));
            }
        }

        //
        if (criteria.getEmail() != null) {
            if (!wherePresent) {
                specification = Specification.where(buildStringSpecification(criteria.getEmail(), EconomicAgent_.email));
                wherePresent = true;
            } else {
                specification = specification.and(buildStringSpecification(criteria.getEmail(), EconomicAgent_.email));
            }
        }

        //
        if (criteria.getPhone() != null) {
            if (!wherePresent) {
                specification = Specification.where(buildStringSpecification(criteria.getPhone(), EconomicAgent_.phone));
                wherePresent = true;
            } else {
                specification = specification.and(buildStringSpecification(criteria.getPhone(), EconomicAgent_.phone));
            }
        }

        //
        if (criteria.getFax() != null) {
            if (!wherePresent) {
                specification = Specification.where(buildStringSpecification(criteria.getFax(), EconomicAgent_.fax));
                wherePresent = true;
            } else {
                specification = specification.and(buildStringSpecification(criteria.getFax(), EconomicAgent_.fax));
            }
        }

        //if criteria not exist
        if (!wherePresent) {
            specification =  new JoinPredicate<EconomicAgent, String>().findAll(EconomicAgent_.id);
        }

        return specification;
    }
}
