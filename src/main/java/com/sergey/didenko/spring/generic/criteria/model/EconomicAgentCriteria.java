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

package com.sergey.didenko.spring.generic.criteria.model;

import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

import java.io.Serializable;

public class EconomicAgentCriteria implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter economicSector;

    private StringFilter name;
    private StringFilter addr;
    private StringFilter email;
    private StringFilter phone;
    private StringFilter fax;

    public EconomicAgentCriteria() {}

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getEconomicSector() {
        return economicSector;
    }

    public void setEconomicSector(StringFilter economicSector) {
        this.economicSector = economicSector;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public StringFilter getAddr() {
        return addr;
    }

    public void setAddr(StringFilter addr) {
        this.addr = addr;
    }

    public StringFilter getEmail() {
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
    }

    public StringFilter getPhone() {
        return phone;
    }

    public void setPhone(StringFilter phone) {
        this.phone = phone;
    }

    public StringFilter getFax() {
        return fax;
    }

    public void setFax(StringFilter fax) {
        this.fax = fax;
    }

    @Override
    public String toString() {
        return "EconomicAgentCriteria{" +
            "id=" + id +
            ", economicSector=" + economicSector +
            ", name=" + name +
            ", addr=" + addr +
            ", email=" + email +
            ", phone=" + phone +
            ", fax=" + fax +
            '}';
    }
}
