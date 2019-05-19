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
