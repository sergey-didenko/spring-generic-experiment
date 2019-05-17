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

package com.sergey.didenko.spring.generic.criteria.predicate;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.metamodel.SingularAttribute;
import java.time.LocalDate;
import java.util.Date;

/**
 * Example:
 * new JoinPredicate<Entity, Long>().equal(1L, Entity_.id);
 * 
 * Convert LocalDate to Date:
 * Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
 * 
 * @param <E> entity
 * @param <A> attribute for predicate
 */
public class JoinPredicate<E, A> {

    public Specification<E> equal(A attribute,
                                  SingularAttribute<E, A> join) {
        return (root, query, cb) -> cb.equal(root.get(join), attribute);
    }

    //

    public Specification<E> like(String attribute,
                                 SingularAttribute<E, String> join) {
        return (root, query, cb) -> cb.like(root.get(join), "%" + attribute + "%");
    }

    //

    public Specification<E> greaterThan(LocalDate attribute,
                                        SingularAttribute<E, LocalDate> join) {
        return (root, query, cb) -> cb.greaterThan(root.get(join), attribute);
    }

    public Specification<E> greaterThan(Date attribute,
                                        SingularAttribute<E, Date> join) {
        return (root, query, cb) -> cb.greaterThan(root.get(join), attribute);
    }

    //

    public Specification<E> lessThan(LocalDate attribute,
                                     SingularAttribute<E, LocalDate> join) {
        return (root, query, cb) -> cb.lessThan(root.get(join), attribute);
    }

    public Specification<E> lessThan(Date attribute,
                                     SingularAttribute<E, Date> join) {
        return (root, query, cb) -> cb.lessThan(root.get(join), attribute);
    }

    //

    public Specification<E> greaterThanOrEqualTo(LocalDate attribute,
                                                 SingularAttribute<E, LocalDate> join) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get(join), attribute);
    }

    public Specification<E> greaterThanOrEqualTo(Date attribute,
                                                 SingularAttribute<E, Date> join) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get(join), attribute);
    }

    //

    public Specification<E> lessOrEqualThan(LocalDate attribute,
                                            SingularAttribute<E, LocalDate> join) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get(join), attribute);
    }

    public Specification<E> lessOrEqualThan(Date attribute, SingularAttribute<E, Date> join) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get(join), attribute);
    }

    //

    public Specification<E> findAll(SingularAttribute<E, Long> entityIdAttribute) {
        return (root, query, cb) -> cb.greaterThan(root.get(entityIdAttribute), 0L);
    }
}
