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
