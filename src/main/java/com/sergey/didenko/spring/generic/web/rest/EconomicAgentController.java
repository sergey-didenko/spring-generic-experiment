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

import com.sergey.didenko.spring.generic.criteria.model.EconomicAgentCriteria;
import com.sergey.didenko.spring.generic.criteria.service.EconomicAgentQueryService;
import com.sergey.didenko.spring.generic.domain.EconomicAgent;
import com.sergey.didenko.spring.generic.domain.EconomicSector;
import com.sergey.didenko.spring.generic.domain.dto.EconomicAgentDTO;
import com.sergey.didenko.spring.generic.repository.EconomicAgentRepository;
import com.sergey.didenko.spring.generic.repository.EconomicSectorRepository;
import com.sergey.didenko.spring.generic.service.EconomicAgentService;
import com.sergey.didenko.spring.generic.web.rest.abstr.OwnerControllerAbstr;
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
 *
 * TODO : Inherited methods From OwnerControllerAbstr.java:
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
@RestController
@RequestMapping("/api/economic-agent")
public class EconomicAgentController extends OwnerControllerAbstr<EconomicAgent,
                                                                  EconomicAgentDTO,
                                                                  EconomicAgentRepository,
                                                                  EconomicSector,
                                                                  EconomicSectorRepository,
                                                                  EconomicAgentCriteria,
                                                                  EconomicAgentQueryService,
                                                                  EconomicAgentService> {

    @Autowired
    public EconomicAgentController(EconomicAgentService service) {
        super(service);
    }

}
