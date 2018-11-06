package com.example.demo.common.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity /*@Table(name="test_user")*/data class User(@Id val id: Int, val name: String, val age: String, val nationality: String)