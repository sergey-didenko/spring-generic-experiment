package com.sergey.didenko.spring.generic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sergey.didenko.spring.generic.domain.abstr.EntityWithOwnerAbstr;
import com.sergey.didenko.spring.generic.repository.EconomicSectorRepository;

import javax.persistence.*;

@Entity
public class EconomicAgent extends EntityWithOwnerAbstr<EconomicSector, EconomicSectorRepository> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * @see EconomicSector
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ownerId")
    @JsonIgnore
    private EconomicSector owner;

    private String name;
    private String addr;
    private String email;
    private String phone;
    private String fax;

    public EconomicAgent() {}

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public EconomicSector getOwner() {
        return owner;
    }

    @Override
    public void setOwner(EconomicSector owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
