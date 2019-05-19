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

package com.sergey.didenko.spring.generic.web.rest.abstr;

import com.sergey.didenko.spring.generic.domain.abstr.EntityAbstr;
import com.sergey.didenko.spring.generic.domain.abstr.EntityWithOwnerAbstr;
import com.sergey.didenko.spring.generic.repository.abstr.EntityRepositoryInterface;
import com.sergey.didenko.spring.generic.repository.abstr.EntityWithOwnerRepositoryInterface;
import com.sergey.didenko.spring.generic.service.abstr.OwnerServiceAbstr;
import com.sergey.didenko.spring.generic.criteria.service.abstr.QueryServiceAbstr;
import com.sergey.didenko.spring.generic.web.rest.util.PaginationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO : Inherited methods From ControllerAbstr.java:
 *
 * @GetMapping("/findAllByCriteriaAndPageable")
 * ResponseEntity<List<E>> findAllByCriteriaAndPageable(C criteria, Pageable pageable);
 *
 * @GetMapping("/getListByCriteria")
 * ResponseEntity<List<E>> getListByCriteria(C criteria);
 *
 * @GetMapping
 * ResponseEntity<E> get(@RequestParam("id") Long id);
 *
 * @PutMapping
 * ResponseEntity<E> create(@RequestBody E_DTO body);
 *
 * @PostMapping
 * ResponseEntity<E> update(@RequestBody E_DTO body);
 *
 * @DeleteMapping
 * void remove(@RequestParam(value = "id") Long id);
 *
 * E toDTO(E element);
 * List<E> toDTO(List<E> elementList);
 * List<E> toDTO(Page<E> elementPage);
 *
 * TODO : Methods:
 *
 * @GetMapping(path = "/findAllByOwnerAndCriteriaAndPageable")
 * ResponseEntity<List<E>> findAllByOwnerAndCriteriaAndPageable(@RequestParam(value = "ownerId") Long ownerId, C criteria, Pageable pageable);
 *
 * @GetMapping(path = "/getListByOwnerAndCriteria")
 * ResponseEntity<List<E>> getListByOwnerAndCriteria(@RequestParam(value = "ownerId") Long ownerId, C criteria);
 *
 * @GetMapping(path = "/getListByOwner")
 * ResponseEntity<List<E>> getListByOwner(@RequestParam(value = "ownerId") Long ownerId);
 *
 * @PostMapping(path = "/getOwner")
 * ResponseEntity<O_E> getOwner(@RequestBody E element);
 */
public class OwnerControllerAbstr<E extends EntityWithOwnerAbstr<O_E, O_R>,
                                  E_DTO extends E,
                                  R extends EntityWithOwnerRepositoryInterface,
                                  O_E extends EntityAbstr,
                                  O_R extends EntityRepositoryInterface,
                                  C,
                                  C_QS extends QueryServiceAbstr,
                                  S extends OwnerServiceAbstr<E, E_DTO, R, O_E, O_R, C, C_QS>> extends ControllerAbstr<E, E_DTO, R, C, C_QS, S> {

    public OwnerControllerAbstr(S service) {
        super(service);
    }

    /**
     * Get Page of Elements who has an Owner
     * and Criteria
     * and Pageable
     *
     * @param ownerId id of Owner
     * @param criteria Criteria DTO of Element
     * @param pageable Pageable Object for sorting in page
     * @return Page of Elements DTO
     */
    @GetMapping(path = "/findAllByOwnerAndCriteriaAndPageable")
    public ResponseEntity<List<E>> findAllByOwnerAndCriteriaAndPageable(@RequestParam(value = "ownerId") Long ownerId,
                                                                        C criteria,
                                                                        Pageable pageable) {
        Page<E> elementPage = service.findAllByOwnerAndCriteriaAndPageable(ownerId, criteria, pageable);

        List<E> dtoList = toDTO(elementPage);

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(elementPage, this.getClass().getAnnotation(RequestMapping.class).name());
        return new ResponseEntity<>(dtoList, headers, HttpStatus.OK);
    }

    /**
     * Get List of Elements who has an Owner
     * and Criteria
     *
     * @param ownerId id of Owner
     * @param criteria Criteria DTO of Element
     * @return List of Elements DTO
     */
    @GetMapping(path = "/getListByOwnerAndCriteria")
    public ResponseEntity<List<E>> getListByOwnerAndCriteria(@RequestParam(value = "ownerId") Long ownerId,
                                                             C criteria) {
        List<E> list = service.getListByOwnerAndCriteria(ownerId, criteria);

        List<E> dtoList = toDTO(list);

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    /**
     * Get List of Elements who has an Owner
     *
     * @param ownerId id of Owner
     * @return List of Elements DTO
     */
    @GetMapping(path = "/getListByOwner")
    public ResponseEntity<List<E>> getListByOwner(@RequestParam(value = "ownerId") Long ownerId) {
        List<E> list = service.getListByOwner(ownerId);

        List<E> dtoList = toDTO(list);

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    /**
     * Get Owner by Element
     *
     * @param element who has an Owner
     * @return Owner DTO
     */
    @PostMapping(path = "/getOwner")
    public ResponseEntity<O_E> getOwner(@RequestBody E element) {
        O_E owner = service.getOwner(element);

        O_E dto = service.createOwnerDTO(owner);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
