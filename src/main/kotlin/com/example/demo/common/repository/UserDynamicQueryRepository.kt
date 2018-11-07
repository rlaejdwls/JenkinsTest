package com.example.demo.common.repository

import com.example.demo.common.entity.User

/**
 * Implemented in [UserDynamicQueryRepositoryImpl]
 */
interface UserDynamicQueryRepository {
    fun selectUserForPagingUsingEntityManagerNativeSyntax(page: Int, size: Int): Iterable<User>
    fun selectUserForPagingUsingEntityManagerJpaSyntax(page: Int, size: Int): Iterable<User>
}