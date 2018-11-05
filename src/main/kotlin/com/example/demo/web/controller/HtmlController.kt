package com.example.demo.web.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import java.lang.RuntimeException

@Controller class HtmlController {
    @GetMapping("/blog") fun blog(model: Model): String {
        model["title"] = "Blog"
        return "blog"
    }
}