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
 * new TripleJoinPredicate<Entity, Entity2, Entity3, Long>().equal(1L, Entity_.entity2, Entity2_.entity3, Entity3_.id);
 * 
 * Convert LocalDate to Date:
 * Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
 * 
 * @param <E> entity
 * @param <E_2> entity_2, who joining to entity
 * @param <E_2> entity_3, who joining to entity_2
 * @param <A> attribute for predicate
 */
public class TripleJoinPredicate<E, E_2, E_3, A> {

    public Specification<E> equal(A attribute,
                                  SingularAttribute<E, E_2> join,
                                  SingularAttribute<E_2, E_3> join2,
                                  SingularAttribute<E_3, A> join3) {
        return equal(attribute, join, join2, join3, JoinType.LEFT);
    }

    public Specification<E> equal(A attribute,
                                  SingularAttribute<E, E_2> join,
                                  SingularAttribute<E_2, E_3> join2,
                                  SingularAttribute<E_3, A> join3,
                                  JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            final Join<E_2, E_3> joinOneJoinTwoJoin = elementJoinOneJoin.join(join2, joinType);
            return cb.equal(joinOneJoinTwoJoin.get(join3), attribute);
        };
    }

    //

    public Specification<E> like(A attribute,
                                 SingularAttribute<E, E_2> join,
                                 SingularAttribute<E_2, E_3> join2,
                                 SingularAttribute<E_3, A> join3) {
        return equal(attribute, join, join2, join3, JoinType.LEFT);
    }

    public Specification<E> like(String attribute,
                                 SingularAttribute<E, E_2> join,
                                 SingularAttribute<E_2, E_3> join2,
                                 SingularAttribute<E_3, String> join3,
                                 JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            final Join<E_2, E_3> joinOneJoinTwoJoin = elementJoinOneJoin.join(join2, joinType);
            return cb.like(joinOneJoinTwoJoin.get(join3), "%" + attribute + "%");
        };
    }

    //

    public Specification<E> greaterThan(LocalDate attribute,
                                        SingularAttribute<E, E_2> join,
                                        SingularAttribute<E_2, E_3> join2,
                                        SingularAttribute<E_3, LocalDate> join3) {
        return this.greaterThan(attribute, join, join2, join3, JoinType.LEFT);
    }

    public Specification<E> greaterThan(LocalDate attribute,
                                        SingularAttribute<E, E_2> join,
                                        SingularAttribute<E_2, E_3> join2,
                                        SingularAttribute<E_3, LocalDate> join3,
                                        JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            final Join<E_2, E_3> joinOneJoinTwoJoin = elementJoinOneJoin.join(join2, joinType);
            return cb.greaterThan(joinOneJoinTwoJoin.get(join3), attribute);
        };
    }

    public Specification<E> greaterThan(Date attribute,
                                        SingularAttribute<E, E_2> join,
                                        SingularAttribute<E_2, E_3> join2,
                                        SingularAttribute<E_3, Date> join3) {
        return greaterThan(attribute, join, join2, join3, JoinType.LEFT);
    }

    public Specification<E> greaterThan(Date attribute,
                                        SingularAttribute<E, E_2> join,
                                        SingularAttribute<E_2, E_3> join2,
                                        SingularAttribute<E_3, Date> join3,
                                        JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            final Join<E_2, E_3> joinOneJoinTwoJoin = elementJoinOneJoin.join(join2, joinType);
            return cb.greaterThan(joinOneJoinTwoJoin.get(join3), attribute);
        };
    }

    //

    public Specification<E> lessThan(LocalDate attribute,
                                     SingularAttribute<E, E_2> join,
                                     SingularAttribute<E_2, E_3> join2,
                                     SingularAttribute<E_3, LocalDate> join3) {
        return this.lessThan(attribute, join, join2, join3, JoinType.LEFT);
    }

    public Specification<E> lessThan(LocalDate attribute,
                                     SingularAttribute<E, E_2> join,
                                     SingularAttribute<E_2, E_3> join2,
                                     SingularAttribute<E_3, LocalDate> join3,
                                     JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            final Join<E_2, E_3> joinOneJoinTwoJoin = elementJoinOneJoin.join(join2, joinType);
            return cb.lessThan(joinOneJoinTwoJoin.get(join3), attribute);
        };
    }

    public Specification<E> lessThan(Date attribute,
                                     SingularAttribute<E, E_2> join,
                                     SingularAttribute<E_2, E_3> join2,
                                     SingularAttribute<E_3, Date> join3) {
        return lessThan(attribute, join, join2, join3, JoinType.LEFT);
    }

    public Specification<E> lessThan(Date attribute,
                                     SingularAttribute<E, E_2> join,
                                     SingularAttribute<E_2, E_3> join2,
                                     SingularAttribute<E_3, Date> join3,
                                     JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            final Join<E_2, E_3> joinOneJoinTwoJoin = elementJoinOneJoin.join(join2, joinType);
            return cb.lessThan(joinOneJoinTwoJoin.get(join3), attribute);
        };
    }

    //

    public Specification<E> greaterThanOrEqualTo(LocalDate attribute,
                                                 SingularAttribute<E, E_2> join,
                                                 SingularAttribute<E_2, E_3> join2,
                                                 SingularAttribute<E_3, LocalDate> join3) {
        return this.greaterThanOrEqualTo(attribute, join, join2, join3, JoinType.LEFT);
    }

    public Specification<E> greaterThanOrEqualTo(LocalDate attribute,
                                                 SingularAttribute<E, E_2> join,
                                                 SingularAttribute<E_2, E_3> join2,
                                                 SingularAttribute<E_3, LocalDate> join3,
                                                 JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            final Join<E_2, E_3> joinOneJoinTwoJoin = elementJoinOneJoin.join(join2, joinType);
            return cb.greaterThanOrEqualTo(joinOneJoinTwoJoin.get(join3), attribute);
        };
    }

    public Specification<E> greaterThanOrEqualTo(Date attribute,
                                                 SingularAttribute<E, E_2> join,
                                                 SingularAttribute<E_2, E_3> join2,
                                                 SingularAttribute<E_3, Date> join3) {
        return greaterThanOrEqualTo(attribute, join, join2, join3, JoinType.LEFT);
    }

    public Specification<E> greaterThanOrEqualTo(Date attribute,
                                                 SingularAttribute<E, E_2> join,
                                                 SingularAttribute<E_2, E_3> join2,
                                                 SingularAttribute<E_3, Date> join3,
                                                 JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            final Join<E_2, E_3> joinOneJoinTwoJoin = elementJoinOneJoin.join(join2, joinType);
            return cb.greaterThanOrEqualTo(joinOneJoinTwoJoin.get(join3), attribute);
        };
    }

    //

    public Specification<E> lessOrEqualThan(LocalDate attribute,
                                            SingularAttribute<E, E_2> join,
                                            SingularAttribute<E_2, E_3> join2,
                                            SingularAttribute<E_3, LocalDate> join3) {
        return this.lessOrEqualThan(attribute, join, join2, join3, JoinType.LEFT);
    }

    public Specification<E> lessOrEqualThan(LocalDate attribute,
                                            SingularAttribute<E, E_2> join,
                                            SingularAttribute<E_2, E_3> join2,
                                            SingularAttribute<E_3, LocalDate> join3,
                                            JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            final Join<E_2, E_3> joinOneJoinTwoJoin = elementJoinOneJoin.join(join2, joinType);
            return cb.lessThanOrEqualTo(joinOneJoinTwoJoin.get(join3), attribute);
        };
    }

    public Specification<E> lessOrEqualThan(Date attribute,
                                            SingularAttribute<E, E_2> join,
                                            SingularAttribute<E_2, E_3> join2,
                                            SingularAttribute<E_3, Date> join3) {
        return lessOrEqualThan(attribute, join, join2, join3, JoinType.LEFT);
    }

    public Specification<E> lessOrEqualThan(Date attribute,
                                            SingularAttribute<E, E_2> join,
                                            SingularAttribute<E_2, E_3> join2,
                                            SingularAttribute<E_3, Date> join3,
                                            JoinType joinType) {
        return (root, query, cb) -> {
            final Join<E, E_2> elementJoinOneJoin = root.join(join, joinType);
            final Join<E_2, E_3> joinOneJoinTwoJoin = elementJoinOneJoin.join(join2, joinType);
            return cb.lessThanOrEqualTo(joinOneJoinTwoJoin.get(join3), attribute);
        };
    }

}
