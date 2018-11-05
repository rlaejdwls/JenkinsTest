package com.example.demo.config.model

class RESTResult {
    companion object {
        fun set(key: String, value: Any): Map<String, Any> {
            return HashMap<String, Any>().also { it[key] = value }
        }
    }
}