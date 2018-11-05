package com.example.demo.app.api.controller

import com.example.demo.app.api.service.UserService
import com.example.demo.common.util.Loggable
import com.example.demo.config.model.RESTResult
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody


@RequestMapping("/app/api")
@Controller class UserController: Loggable {
    @Autowired private lateinit var service: UserService

    @RequestMapping(path= ["/user/{user_id}"], method= [RequestMethod.GET])
    @ResponseBody fun select(@PathVariable("user_id") userId: Int): Map<String, Any> {
        return RESTResult.set("result", service.selectUser(userId))
    }
    @RequestMapping("/log")
    @ResponseBody fun log(): String {
        logger.debug("debug log")
        logger.info("info log")
        return "Log Test"
    }
}