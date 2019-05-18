package com.sergey.didenko.spring.generic.domain.abstr;

import com.sergey.didenko.spring.generic.repository.abstr.EntityRepositoryInterface;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public abstract class EntityWithOwnerAbstr<O_E extends EntityAbstr,
                                           O_R extends EntityRepositoryInterface> extends EntityAbstr {

    public abstract O_E getOwner();
    public abstract void setOwner(O_E owner);

    @Transactional
    @SuppressWarnings("unchecked")
    public O_E getOwner(O_R ownerRepository, Long ownerId) {
        Optional<O_E> ownerOptional = ownerRepository.findById(ownerId);
        return ownerOptional.orElse(null);
    }
}
