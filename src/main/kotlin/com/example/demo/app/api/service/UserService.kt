package com.example.demo.app.api.service

import com.example.demo.app.api.entity.TestUser
import com.example.demo.app.api.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service class UserService {
    @Autowired private lateinit var repository: UserRepository

    fun selectUser(id: Int): TestUser = repository.findById(id).get()
}