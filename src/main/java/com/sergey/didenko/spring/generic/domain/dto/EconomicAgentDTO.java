package com.sergey.didenko.spring.generic.domain.dto;

import com.sergey.didenko.spring.generic.domain.EconomicAgent;
import com.sergey.didenko.spring.generic.domain.EconomicSector;

public class EconomicAgentDTO extends EconomicAgent {

    private Long ownerId;
    private EconomicSector economicSector;

    public EconomicAgentDTO() {}

    public EconomicAgentDTO(EconomicAgent o) {
        this.setId(o.getId());
        this.setName(o.getName());
        this.setAddr(o.getAddr());
        this.setEmail(o.getEmail());
        this.setPhone(o.getPhone());
        this.setFax(o.getFax());

        this.setOwnerId(o.getOwner().getId());
        this.setEconomicSector(o.getOwner());
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public EconomicSector getEconomicSector() {
        return economicSector;
    }

    public void setEconomicSector(EconomicSector economicSector) {
        this.economicSector = economicSector;
    }
}
