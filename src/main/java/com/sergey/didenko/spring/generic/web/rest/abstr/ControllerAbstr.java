package com.sergey.didenko.spring.generic.web.rest.abstr;

import com.sergey.didenko.spring.generic.domain.abstr.EntityAbstr;
import com.sergey.didenko.spring.generic.repository.abstr.EntityRepositoryInterface;
import com.sergey.didenko.spring.generic.service.abstr.ServiceAbstr;
import com.sergey.didenko.spring.generic.service.criteria.abstr.QueryServiceAbstr;
import com.sergey.didenko.spring.generic.web.rest.util.PaginationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public abstract class ControllerAbstr<E extends EntityAbstr,
                                      E_DTO extends E,
                                      R extends EntityRepositoryInterface,
                                      C,
                                      C_QS extends QueryServiceAbstr,
                                      S extends ServiceAbstr<E, E_DTO, R, C, C_QS>> {

    protected final S service;

    public ControllerAbstr(S service) {
        this.service = service;
    }

    /**
     * Page by Criteria
     * and Pageable
     *
     * @param criteria Criteria DTO of Element
     * @param pageable Pageable Object for sorting in page
     * @return Page of Elements DTO
     */
    @GetMapping("/findAllByCriteriaAndPageable")
    public ResponseEntity<List<E>> findAllByCriteriaAndPageable(C criteria,
                                                                Pageable pageable) {
        Page<E> elementPage = this.service.findAllByCriteriaAndPageable(criteria, pageable);

        List<E> dtoList = toDTO(elementPage);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(elementPage, this.getClass().getAnnotation(RequestMapping.class).name());
        return new ResponseEntity<>(dtoList, headers, HttpStatus.OK);
    }

    /**
     * List by Criteria
     *
     * @param criteria Criteria DTO of Element
     * @return List of Elements DTO
     */
    @GetMapping("/getListByCriteria")
    public ResponseEntity<List<E>> getListByCriteria(C criteria) {
        List<E> elementList = this.service.getListByCriteria(criteria);

        List<E> dtoList = toDTO(elementList);

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }


    /**
     * Get
     *
     * @param id of element
     * @return Element DTO
     */
    @GetMapping
    public ResponseEntity<E> get(@RequestParam("id") Long id) {
        E element = this.service.get(id);

        E dto = toDTO(element);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Create
     *
     * @param body for create
     * @return Element DTO
     */
    @PutMapping
    public ResponseEntity<E> create(@RequestBody E_DTO body) {
        E element = this.service.toEntity(body);

        element = this.service.create(element);

        E dto = toDTO(element);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Update
     *
     * @param body for update
     * @return Element DTO
     */
    @PostMapping
    public ResponseEntity<E> update(@RequestBody E_DTO body) {
        E element = this.service.toEntity(body);

        element = this.service.update(element);

        E dto = toDTO(element);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Remove
     *
     * @param id of element for remove
     */
    @DeleteMapping
    public void remove(@RequestParam(value = "id") Long id) {
        this.service.delete(id);
    }

    protected E toDTO(E element) {
        return this.service.toDTO(element);
    }

    protected List<E> toDTO(List<E> elementList) {
        List<E> objectList = new ArrayList<>();

        for (E element : elementList) {
            objectList.add(this.service.toDTO(element));
        }

        return objectList;
    }

    @SuppressWarnings("unchecked")
    protected List<E> toDTO(Page<E> elementPage) {
        return toDTO(elementPage.getContent());
    }

}
