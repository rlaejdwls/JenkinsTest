package com.example.demo.app.api.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity /*@Table(name="test_user")*/data class TestUser(@Id val id: Int, val name: String, val age: String, val nationality: String)