package com.example.demo.common.repository

import com.example.demo.common.entity.User
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

class UserDynamicQueryRepositoryImpl: UserDynamicQueryRepository {
    @PersistenceContext private lateinit var entityManager: EntityManager

    /**
     * 네이티브 쿼리를 문자열로 넘기는 전형적인 동적 쿼리 생성
     * 쉽고 익숙하고 편함, 하지만 당연히 데이터베이스의 종류에 따라 쿼리가 바뀜
     */
    override fun selectUserForPagingUsingEntityManagerNativeSyntax(page: Int, size: Int): Iterable<User> {
        return entityManager.createQuery("SELECT * FROM test_user LIMIT ${page * size}, $size", User::class.java)
                .resultList
    }
    /**
     * JPA에서 제공해주는 [EntityManager]를 이용한 동적 쿼리 생성
     * 데이터베이스에 종속적이지 않다는 장점이 있을듯
     * 하지만 전형적인 SELECT-FROM-WHERE 등의 문법에 익숙한 나로서는 이해하기 힘든 구조
     * 조금 더 상세히 들어갈 필요성이 있음
     */
    override fun selectUserForPagingUsingEntityManagerJpaSyntax(page: Int, size: Int): Iterable<User> {
        return entityManager.createQuery(entityManager.criteriaBuilder
                .createQuery(User::class.java).apply { select(from(User::class.java)) })
                .setFirstResult(page * size)
                .setMaxResults(size)
                .resultList
    }
}