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

package com.sergey.didenko.spring.generic.web.rest;

import com.sergey.didenko.spring.generic.criteria.model.EconomicSectorCriteria;
import com.sergey.didenko.spring.generic.criteria.service.EconomicSectorQueryService;
import com.sergey.didenko.spring.generic.domain.EconomicSector;
import com.sergey.didenko.spring.generic.repository.EconomicSectorRepository;
import com.sergey.didenko.spring.generic.service.EconomicSectorService;
import com.sergey.didenko.spring.generic.web.rest.abstr.ControllerAbstr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 */
@RestController
@RequestMapping("/api/economic-sector")
public class EconomicSectorController extends ControllerAbstr<EconomicSector,
                                                              EconomicSector,
                                                              EconomicSectorRepository,
                                                              EconomicSectorCriteria,
                                                              EconomicSectorQueryService,
                                                              EconomicSectorService> {

    @Autowired
    public EconomicSectorController(EconomicSectorService service) {
        super(service);
    }

}
