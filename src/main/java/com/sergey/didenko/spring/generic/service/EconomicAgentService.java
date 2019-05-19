package com.sergey.didenko.spring.generic.service;

import com.sergey.didenko.spring.generic.criteria.model.EconomicAgentCriteria;
import com.sergey.didenko.spring.generic.criteria.service.EconomicAgentQueryService;
import com.sergey.didenko.spring.generic.domain.EconomicAgent;
import com.sergey.didenko.spring.generic.domain.EconomicSector;
import com.sergey.didenko.spring.generic.domain.dto.EconomicAgentDTO;
import com.sergey.didenko.spring.generic.repository.EconomicAgentRepository;
import com.sergey.didenko.spring.generic.repository.EconomicSectorRepository;
import com.sergey.didenko.spring.generic.service.abstr.OwnerServiceAbstr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.metamodel.SingularAttribute;

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
 *
 * TODO : Inherited methods From OwnerServiceAbstr.java:
 *
 * O_E createOwnerDTO(O_E owner);
 * SingularAttribute<E, O_E> getOwnerJoin1();
 * SingularAttribute<O_E, Long> getOwnerJoin2();
 *
 * Page<E> findAllByOwnerAndCriteriaAndPageable(O_E owner, C criteria, Pageable page);
 * Page<E> findAllByOwnerAndCriteriaAndPageable(Long ownerId, C criteria, Pageable page);
 * List<E> getListByOwnerAndCriteria(O_E owner, C criteria);
 * List<E> getListByOwnerAndCriteria(Long ownerId, C criteria);
 * List<E> getListByOwner(Long ownerId);
 * List<E> getListByOwner(O_E owner);
 * O_E getOwner(E element);
 */
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

}
