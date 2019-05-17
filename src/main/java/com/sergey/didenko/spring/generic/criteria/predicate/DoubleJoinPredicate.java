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

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.metamodel.SingularAttribute;
import java.time.LocalDate;
import java.util.Date;

/**
 * Example:
 * new DoubleJoinPredicate<Entity, Entity2, Long>().equal(1L, Entity_.entity2, Entity_2.id);
 * 
 * Convert LocalDate to Date:
 * Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
 * 
 * @param <E> entity
 * @param <E_2> entity_2, who joining to entity
 * @param <A> attribute for predicate
 */
public class DoubleJoinPredicate<E, E_2, A> {

    public Specification<E> equal(A attribute,
                                  SingularAttribute<E, E_2> join,
                                  SingularAttribute<E_2, A> join2) {
        return equal(attribute, join, join2, JoinType.LEFT);
    }

    public Specification<E> equal(A attribute,
                                  SingularAttribute<E, E_2> join,
                                  SingularAttribute<E_2, A> join2,
                                  JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            return cb.equal(elementJoinOneJoin.get(join2), attribute);
        };
    }

    //

    public Specification<E> like(A attribute,
                                 SingularAttribute<E, E_2> join,
                                 SingularAttribute<E_2, A> join2) {
        return equal(attribute, join, join2, JoinType.LEFT);
    }

    public Specification<E> like(String attribute,
                                 SingularAttribute<E, E_2> join,
                                 SingularAttribute<E_2, String> join2,
                                 JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, JoinType.LEFT);
            return cb.like(elementJoinOneJoin.get(join2), "%" + attribute + "%");
        };
    }

    //

    public Specification<E> greaterThan(LocalDate attribute,
                                        SingularAttribute<E, E_2> join,
                                        SingularAttribute<E_2, LocalDate> join2) {
        return this.greaterThan(attribute, join, join2, JoinType.LEFT);
    }

    public Specification<E> greaterThan(LocalDate attribute,
                                        SingularAttribute<E, E_2> join,
                                        SingularAttribute<E_2, LocalDate> join2,
                                        JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            return cb.greaterThan(elementJoinOneJoin.get(join2), attribute);
        };
    }

    public Specification<E> greaterThan(Date attribute,
                                        SingularAttribute<E, E_2> join,
                                        SingularAttribute<E_2, Date> join2) {
        return greaterThan(attribute, join, join2, JoinType.LEFT);
    }

    public Specification<E> greaterThan(Date attribute,
                                        SingularAttribute<E, E_2> join,
                                        SingularAttribute<E_2, Date> join2,
                                        JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            return cb.greaterThan(elementJoinOneJoin.get(join2), attribute);
        };
    }

    //

    public Specification<E> lessThan(LocalDate attribute,
                                     SingularAttribute<E, E_2> join,
                                     SingularAttribute<E_2, LocalDate> join2) {
        return this.lessThan(attribute, join, join2, JoinType.LEFT);
    }

    public Specification<E> lessThan(LocalDate attribute,
                                     SingularAttribute<E, E_2> join,
                                     SingularAttribute<E_2, LocalDate> join2,
                                     JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            return cb.lessThan(elementJoinOneJoin.get(join2), attribute);
        };
    }

    public Specification<E> lessThan(Date attribute,
                                     SingularAttribute<E, E_2> join,
                                     SingularAttribute<E_2, Date> join2) {
        return lessThan(attribute, join, join2, JoinType.LEFT);
    }

    public Specification<E> lessThan(Date attribute,
                                     SingularAttribute<E, E_2> join,
                                     SingularAttribute<E_2, Date> join2,
                                     JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            return cb.lessThan(elementJoinOneJoin.get(join2), attribute);
        };
    }

    //

    public Specification<E> greaterThanOrEqualTo(LocalDate attribute,
                                                 SingularAttribute<E, E_2> join,
                                                 SingularAttribute<E_2, LocalDate> join2) {
        return this.greaterThanOrEqualTo(attribute, join, join2, JoinType.LEFT);
    }

    public Specification<E> greaterThanOrEqualTo(LocalDate attribute,
                                                 SingularAttribute<E, E_2> join,
                                                 SingularAttribute<E_2, LocalDate> join2,
                                                 JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            return cb.greaterThanOrEqualTo(elementJoinOneJoin.get(join2), attribute);
        };
    }

    public Specification<E> greaterThanOrEqualTo(Date attribute,
                                                 SingularAttribute<E, E_2> join,
                                                 SingularAttribute<E_2, Date> join2) {
        return greaterThanOrEqualTo(attribute, join, join2, JoinType.LEFT);
    }

    public Specification<E> greaterThanOrEqualTo(Date attribute,
                                                 SingularAttribute<E, E_2> join,
                                                 SingularAttribute<E_2, Date> join2,
                                                 JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            return cb.greaterThanOrEqualTo(elementJoinOneJoin.get(join2), attribute);
        };
    }

    //

    public Specification<E> lessOrEqualThan(LocalDate attribute,
                                            SingularAttribute<E, E_2> join,
                                            SingularAttribute<E_2, LocalDate> join2) {
        return this.lessOrEqualThan(attribute, join, join2, JoinType.LEFT);
    }

    public Specification<E> lessOrEqualThan(LocalDate attribute,
                                            SingularAttribute<E, E_2> join,
                                            SingularAttribute<E_2, LocalDate> join2,
                                            JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            return cb.lessThanOrEqualTo(elementJoinOneJoin.get(join2), attribute);
        };
    }

    public Specification<E> lessOrEqualThan(Date attribute,
                                            SingularAttribute<E, E_2> join,
                                            SingularAttribute<E_2, Date> join2) {
        return lessOrEqualThan(attribute, join, join2, JoinType.LEFT);
    }

    public Specification<E> lessOrEqualThan(Date attribute,
                                            SingularAttribute<E, E_2> join,
                                            SingularAttribute<E_2, Date> join2,
                                            JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            return cb.lessThanOrEqualTo(elementJoinOneJoin.get(join2), attribute);
        };
    }
}
