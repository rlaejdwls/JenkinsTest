package com.example.demo.app.api.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {
    @RequestMapping("/hello") fun hello(@RequestParam(value = "name") name: String): String {
        return "Welcome to $name World."
    }
}