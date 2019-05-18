package com.sergey.didenko.spring.generic.service.abstr;

import com.sergey.didenko.spring.generic.criteria.predicate.DoubleJoinPredicate;
import com.sergey.didenko.spring.generic.domain.abstr.EntityAbstr;
import com.sergey.didenko.spring.generic.domain.abstr.EntityWithOwnerAbstr;
import com.sergey.didenko.spring.generic.repository.abstr.EntityRepositoryInterface;
import com.sergey.didenko.spring.generic.repository.abstr.EntityWithOwnerRepositoryInterface;
import com.sergey.didenko.spring.generic.service.criteria.abstr.QueryServiceAbstr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.metamodel.SingularAttribute;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public abstract class OwnerServiceAbstr<E extends EntityWithOwnerAbstr<O_E, O_R>,
                                        E_DTO extends E,
                                        R extends EntityWithOwnerRepositoryInterface,
                                        O_E extends EntityAbstr,
                                        O_R extends EntityRepositoryInterface,
                                        C,
                                        C_QS extends QueryServiceAbstr> extends ServiceAbstr<E, E_DTO, R, C, C_QS> {

    protected final O_R ownerRepository;

    public OwnerServiceAbstr(O_R ownerRepository, R repository, C_QS queryService) {
        super(repository, queryService);
        this.ownerRepository = ownerRepository;
    }

    //TODO : Owner DTO Object <? extends O_E>
    public O_E createOwnerDTO(O_E owner) {
        return owner;
    }

    public abstract SingularAttribute<E, O_E> getOwnerJoin1();
    public abstract SingularAttribute<O_E, Long> getOwnerJoin2();

    public Page<E> findAllByOwnerAndCriteriaAndPageable(O_E owner, C criteria, Pageable page) {
        return findAllByOwnerAndCriteriaAndPageable(owner.getId(), criteria, page);
    }

    @SuppressWarnings("unchecked")
    public Page<E> findAllByOwnerAndCriteriaAndPageable(Long ownerId, C criteria, Pageable page) {
        Specification<E> specification = queryService.createSpecificationByCriteria(criteria);

        specification.and(
            new DoubleJoinPredicate<E, O_E, Long>()
                .equal(ownerId, getOwnerJoin1(), getOwnerJoin2())
        );

        return repository.findAll(specification, page);
    }

    public List<E> getListByOwnerAndCriteria(O_E owner, C criteria) {
        return getListByOwnerAndCriteria(owner.getId(), criteria);
    }

    @SuppressWarnings("unchecked")
    public List<E> getListByOwnerAndCriteria(Long ownerId, C criteria) {
        Specification<E> specification = queryService.createSpecificationByCriteria(criteria);

        specification.and(
            new DoubleJoinPredicate<E, O_E, Long>()
                .equal(ownerId, getOwnerJoin1(), getOwnerJoin2())
        );

        return repository.findAll(specification);
    }

    @SuppressWarnings("unchecked")
    public List<E> getListByOwner(Long ownerId) {
        Optional<O_E> ownerOptional = ownerRepository.findById(ownerId);
        O_E owner = ownerOptional.orElse(null);
        if (owner != null) {
            return getListByOwner(owner);
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    public List<E> getListByOwner(O_E owner) {
        return repository.findAllByOwner(owner);
    }

    public O_E getOwner(E element) {
        return element.getOwner();
    }

}
