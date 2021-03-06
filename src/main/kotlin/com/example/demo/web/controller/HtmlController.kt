package com.example.demo.web.controller

import com.example.demo.common.service.UserService
import com.example.demo.common.util.Loggable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@Controller class HtmlController: Loggable {
    @Autowired private lateinit var service: UserService

    @RequestMapping("/blog", method=[RequestMethod.GET])
    fun blog(model: Model,
             @RequestParam(value="page", defaultValue="0") page: Int,
             @RequestParam(value="size", defaultValue= "10") size: Int): String {
        model["title"] = "Blog"
        model["users"] = service.selectUserForPagingUsingEntityManagerJpa(page, size)
        return "blog"
    }
    @RequestMapping("/log", method=[RequestMethod.GET])
    fun log(model: Model): String {
        logger.debug("debug log")
        logger.info("info log")
        model["title"] = "Main"
        return "/index"
    }
}