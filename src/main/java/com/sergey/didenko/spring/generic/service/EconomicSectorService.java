package com.sergey.didenko.spring.generic.service;

import com.sergey.didenko.spring.generic.criteria.model.EconomicSectorCriteria;
import com.sergey.didenko.spring.generic.criteria.service.EconomicSectorQueryService;
import com.sergey.didenko.spring.generic.domain.EconomicSector;
import com.sergey.didenko.spring.generic.repository.EconomicSectorRepository;
import com.sergey.didenko.spring.generic.service.abstr.ServiceAbstr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    //TODO : for example only

    @Override
    public Page<EconomicSector> findAllByCriteriaAndPageable(EconomicSectorCriteria criteria, Pageable page) {
        return super.findAllByCriteriaAndPageable(criteria, page);
    }

    @Override
    public List<EconomicSector> getListByCriteria(EconomicSectorCriteria criteria) {
        return super.getListByCriteria(criteria);
    }

    @Override
    public EconomicSector get(Long id) {
        return super.get(id);
    }

    @Override
    public EconomicSector create(EconomicSector element) {
        return super.create(element);
    }

    @Override
    public EconomicSector update(EconomicSector element) {
        return super.update(element);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public void delete(EconomicSector element) {
        //TODO : delete parents
        super.delete(element);
    }
}
