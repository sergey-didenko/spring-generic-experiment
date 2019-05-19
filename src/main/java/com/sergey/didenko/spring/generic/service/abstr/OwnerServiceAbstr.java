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

package com.sergey.didenko.spring.generic.service.abstr;

import com.sergey.didenko.spring.generic.criteria.predicate.DoubleJoinPredicate;
import com.sergey.didenko.spring.generic.domain.abstr.EntityAbstr;
import com.sergey.didenko.spring.generic.domain.abstr.EntityWithOwnerAbstr;
import com.sergey.didenko.spring.generic.repository.abstr.EntityRepositoryInterface;
import com.sergey.didenko.spring.generic.repository.abstr.EntityWithOwnerRepositoryInterface;
import com.sergey.didenko.spring.generic.criteria.service.abstr.QueryServiceAbstr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.metamodel.SingularAttribute;
import java.util.List;
import java.util.Optional;

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
 * TODO : Methods:
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
@Transactional
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
