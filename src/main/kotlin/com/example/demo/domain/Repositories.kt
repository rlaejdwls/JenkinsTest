package com.example.demo.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository interface UserRepository: CrudRepository<TestUser, Int>