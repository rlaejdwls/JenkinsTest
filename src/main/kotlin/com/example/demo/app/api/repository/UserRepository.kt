package com.example.demo.app.api.repository

import com.example.demo.app.api.entity.TestUser
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository interface UserRepository: CrudRepository<TestUser, Int>