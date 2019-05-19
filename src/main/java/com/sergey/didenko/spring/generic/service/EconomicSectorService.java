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
