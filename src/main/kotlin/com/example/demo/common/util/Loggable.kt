package com.example.demo.common.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface Loggable {
    val logger: Logger
        get() = LoggerFactory.getLogger(this::class.java)
}
