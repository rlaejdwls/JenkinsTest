package com.example.demo.web

import com.example.demo.domain.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {
    @Autowired
    lateinit var repository: UserRepository

    @RequestMapping("/hello") fun hello(@RequestParam(value = "name") name: String): String {
        val testUser = repository.findById(0).get()
        return "Welcome to $name World, ${testUser.name}"
    }
}