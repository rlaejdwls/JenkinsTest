package com.example.demo

import com.samskivert.mustache.Mustache
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages= ["com.example.demo"])
class DemoApplication {
    @Bean fun mustacheCompiler(loader: Mustache.TemplateLoader?): Mustache.Compiler =
            Mustache.compiler().escapeHTML(false).withLoader(loader)
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
