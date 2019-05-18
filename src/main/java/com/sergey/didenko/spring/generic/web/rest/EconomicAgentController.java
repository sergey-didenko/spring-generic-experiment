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
