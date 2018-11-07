package com.example.demo.config.db

import org.hibernate.boot.model.naming.Identifier
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy
import org.springframework.stereotype.Component

@Component class PhysicalNamingStrategy: SpringPhysicalNamingStrategy() {
    @Value("\${com.example.demo.prefix-table}")
    val tablePrefix: String? = null

    override fun toPhysicalTableName(name: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier {
        return name?.run { Identifier("${tablePrefix ?: ""}_${(text[0] + 32) + if (text.length > 1) text.substring(1) else ""}", isQuoted) }
                ?: super.toPhysicalTableName(name, jdbcEnvironment)
    }
    override fun toPhysicalColumnName(name: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier {
        return name?.run { Identifier(name.text, name.isQuoted) }
                ?: super.toPhysicalColumnName(name, jdbcEnvironment)
    }
}