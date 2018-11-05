package com.example.demo.config.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.HashMap
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletResponse
import java.io.PrintWriter
import java.io.StringWriter



@Component
@Aspect class RESTAspect {
    private val logger = LoggerFactory.getLogger(RESTAspect::class.java)

    @Around("execution(* com.example.*.web.controller.*.*(..))")
    fun doWebAround(joinPoint: ProceedingJoinPoint): Any? {
        var result: Any? = null
        try {
            result = joinPoint.proceed()
        } catch(t: Throwable) {
            val exception = StringWriter()
            t.printStackTrace(PrintWriter(exception, true))
            logger.error(exception.buffer.toString())
        }
        return result
    }
    @Around("execution(* com.example.*.app.api.controller.*.*(..))")
    fun doAppApiAround(joinPoint: ProceedingJoinPoint): Any? {
        var result: Any? = null
        try {
            result = joinPoint.proceed()
        } catch(t: Throwable) {
            val exception = StringWriter()
            t.printStackTrace(PrintWriter(exception, true))
            logger.error(exception.buffer.toString())

            val response = (RequestContextHolder
                    .currentRequestAttributes() as ServletRequestAttributes).response
            response!!.status = 500

            val error = HashMap<String, String>()
            error["error"] = "failed"
            error["message"] = exception.buffer.toString()
            result = error
        }
        return result
    }
}