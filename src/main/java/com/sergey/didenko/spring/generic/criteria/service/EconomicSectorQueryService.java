/*
Copyright 2019 Sergey Didenko <sergey.didenko.dev@gmail.com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

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
