package com.example.demo

import com.example.demo.common.entity.User
import com.example.demo.common.repository.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RepositoriesTests(@Autowired val entityManager: TestEntityManager,
                        @Autowired val repository: UserRepository) {
    @Test fun `When findById then return User`() {
        val kotlin = User(104, "Kotlin", "8", "JetBrains")
//        entityManager.persist(kotlin)
//        entityManager.flush()

        val found = repository.findById(kotlin.id)
        assertThat(found.get()).isEqualTo(kotlin)
    }
}