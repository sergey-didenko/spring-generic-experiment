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

import com.sergey.didenko.spring.generic.domain.abstr.EntityAbstr;
import com.sergey.didenko.spring.generic.repository.abstr.EntityRepositoryInterface;
import com.sergey.didenko.spring.generic.criteria.service.abstr.QueryServiceAbstr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * TODO : Methods:
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
@Transactional
public abstract class ServiceAbstr<E extends EntityAbstr,
                                   E_DTO extends E,
                                   R extends EntityRepositoryInterface,
                                   C,
                                   C_QS extends QueryServiceAbstr> {

    protected final R repository;
    protected final C_QS queryService;

    public ServiceAbstr(R repository, C_QS queryService) {
        this.repository = repository;
        this.queryService = queryService;
    }

    //TODO : DTO Object <? extends E>
    public E toDTO(E element) {
        return element;
    }

    //TODO : Entity from DTO Object
    public E toEntity(E_DTO dto) {
        return dto;
    }

    @SuppressWarnings("unchecked")
    public Page<E> findAllByCriteriaAndPageable(C criteria, Pageable page) {
        return repository.findAll(queryService.createSpecificationByCriteria(criteria), page);
    }

    @SuppressWarnings("unchecked")
    public List<E> getListByCriteria(C criteria) {
        return repository.findAll(queryService.createSpecificationByCriteria(criteria));
    }

    @SuppressWarnings("unchecked")
    public E get(Long id) {
        Optional<E> obj = repository.findById(id);
        return obj.orElse(null);
    }

    @SuppressWarnings("unchecked")
    public E create(E element) {
        element.setId(null);//clear ID
        return update(element);
    }

    @SuppressWarnings("unchecked")
    public E update(E element) {
        return (E) repository.save(element);
    }

    public void delete(Long id) {
        delete(get(id));
    }

    @SuppressWarnings("unchecked")
    public void delete(E element) {
        //TODO : delete parents
        repository.delete(element);
    }

}
