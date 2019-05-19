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

package com.sergey.didenko.spring.generic.service;

import com.sergey.didenko.spring.generic.criteria.model.EconomicSectorCriteria;
import com.sergey.didenko.spring.generic.criteria.service.EconomicSectorQueryService;
import com.sergey.didenko.spring.generic.domain.EconomicSector;
import com.sergey.didenko.spring.generic.repository.EconomicSectorRepository;
import com.sergey.didenko.spring.generic.service.abstr.ServiceAbstr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO : Inherited methods From ServiceAbstr.java:
 *
 * E toDTO(E element);
 * E toEntity(E_DTO dto);
 *
 * Page<E> findAllByCriteriaAndPageable(C criteria, Pageable page);
 * List<E> getListByCriteria(C criteria);
 * E get(Long id);
 * E create(E element);
 * E update(E element);
 * void delete(Long id);
 * void delete(E element);
 */
@Service
@Transactional
public class EconomicSectorService extends ServiceAbstr<EconomicSector,
                                                        EconomicSector,
                                                        EconomicSectorRepository,
                                                        EconomicSectorCriteria,
                                                        EconomicSectorQueryService> {

    @Autowired
    public EconomicSectorService(EconomicSectorRepository repository,
                                 EconomicSectorQueryService economicSectorQueryService) {
        super(repository, economicSectorQueryService);
    }

}
