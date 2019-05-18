package com.sergey.didenko.spring.generic.service;

import com.sergey.didenko.spring.generic.criteria.model.EconomicAgentCriteria;
import com.sergey.didenko.spring.generic.criteria.service.EconomicAgentQueryService;
import com.sergey.didenko.spring.generic.domain.*;
import com.sergey.didenko.spring.generic.domain.dto.EconomicAgentDTO;
import com.sergey.didenko.spring.generic.repository.EconomicAgentRepository;
import com.sergey.didenko.spring.generic.repository.EconomicSectorRepository;
import com.sergey.didenko.spring.generic.service.abstr.OwnerServiceAbstr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.metamodel.SingularAttribute;
import java.util.List;

@Service
@Transactional
public class EconomicAgentService extends OwnerServiceAbstr<EconomicAgent,
                                                            EconomicAgentDTO,
                                                            EconomicAgentRepository,
                                                            EconomicSector,
                                                            EconomicSectorRepository,
                                                            EconomicAgentCriteria,
                                                            EconomicAgentQueryService> {
    private EconomicSectorService economicSectorService;

    @Autowired
    public EconomicAgentService(EconomicSectorRepository ownerRepository,
                                EconomicAgentRepository repository,
                                EconomicAgentQueryService economicAgentQueryService,
                                EconomicSectorService economicSectorService) {
        super(ownerRepository, repository, economicAgentQueryService);
        this.economicSectorService = economicSectorService;
    }

    @Override
    public SingularAttribute<EconomicAgent, EconomicSector> getOwnerJoin1() {
        //TODO : get from <E_> JPAMetaModelEntity
        return EconomicAgent_.owner;
    }

    @Override
    public SingularAttribute<EconomicSector, Long> getOwnerJoin2() {
        //TODO : get from <E_> JPAMetaModelEntity
        return EconomicSector_.id;
    }

    //==============[DTO section]

    @Override
    public EconomicAgent toDTO(EconomicAgent element) {
        return new EconomicAgentDTO(element);
    }

    @Override
    public EconomicAgent toEntity(EconomicAgentDTO dto) {
        Long id = dto.getId();
        EconomicAgent element;
        if (id == null || id == 0) {
            element = new EconomicAgent();
        } else {
            element = get(id);
        }

        if (dto.getEconomicSector() == null) {
            EconomicSector economicSector = economicSectorService.get(dto.getOwnerId());
            element.setOwner(economicSector);
        } else {
            element.setOwner(dto.getEconomicSector());
        }

        //
        element.setName(dto.getName());
        element.setAddr(dto.getAddr());
        element.setEmail(dto.getEmail());
        element.setPhone(dto.getPhone());
        element.setFax(dto.getFax());

        return element;
    }

    //==============[DTO section]

    //TODO : for example only

    @Override
    public Page<EconomicAgent> findAllByOwnerAndCriteriaAndPageable(EconomicSector owner, EconomicAgentCriteria criteria, Pageable page) {
        return super.findAllByOwnerAndCriteriaAndPageable(owner.getId(), criteria, page);
    }

    @Override
    public Page<EconomicAgent> findAllByOwnerAndCriteriaAndPageable(Long ownerId, EconomicAgentCriteria criteria, Pageable page) {
        return super.findAllByOwnerAndCriteriaAndPageable(ownerId, criteria, page);
    }

    @Override
    public List<EconomicAgent> getListByOwnerAndCriteria(EconomicSector owner, EconomicAgentCriteria criteria) {
        return super.getListByOwnerAndCriteria(owner.getId(), criteria);
    }

    @Override
    public List<EconomicAgent> getListByOwnerAndCriteria(Long ownerId, EconomicAgentCriteria criteria) {
        return super.getListByOwnerAndCriteria(ownerId, criteria);
    }

    @Override
    public List<EconomicAgent> getListByOwner(EconomicSector owner) {
        return getListByOwner(owner.getId());
    }

    @Override
    public List<EconomicAgent> getListByOwner(Long id) {
        return super.getListByOwner(id);
    }

    @Override
    public EconomicSector getOwner(EconomicAgent element) {
        return super.getOwner(element);
    }

    @Override
    public Page<EconomicAgent> findAllByCriteriaAndPageable(EconomicAgentCriteria criteria, Pageable page) {
        return super.findAllByCriteriaAndPageable(criteria, page);
    }

    @Override
    public List<EconomicAgent> getListByCriteria(EconomicAgentCriteria criteria) {
        return super.getListByCriteria(criteria);
    }

    @Override
    public EconomicAgent get(Long id) {
        return super.get(id);
    }

    @Override
    public EconomicAgent create(EconomicAgent element) {
        return super.create(element);
    }

    @Override
    public EconomicAgent update(EconomicAgent element) {
        return super.update(element);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public void delete(EconomicAgent element) {
        //TODO : delete parents
        super.delete(element);
    }
}
