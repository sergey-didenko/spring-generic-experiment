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
