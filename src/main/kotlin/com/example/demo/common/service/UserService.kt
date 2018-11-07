package com.example.demo.common.service

import com.example.demo.common.entity.User
import com.example.demo.common.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service class UserService {
    @Autowired private lateinit var repository: UserRepository

    fun selectUser(id: Int): User = repository.findById(id).get()
    fun selectUserList(ids: List<Int>): MutableIterable<User> = repository.findAllById(ids)
    fun selectUserForPagingUsingBinding(page: Int, size: Int): Page<User> = repository.findAll(PageRequest.of(page, size, Sort.by("id")))
    fun selectUserForPagingUsingQuery(page: Int, size: Int): Iterable<User> = repository.selectUserForPaging(page * size, size)
    fun selectUserForPagingUsingEntityManagerNative(page: Int, size: Int): Iterable<User> = repository.selectUserForPagingUsingEntityManagerNativeSyntax(page, size)
    fun selectUserForPagingUsingEntityManagerJpa(page: Int, size: Int): Iterable<User> = repository.selectUserForPagingUsingEntityManagerJpaSyntax(page, size)
}