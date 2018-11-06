package com.example.demo.config.db

import org.hibernate.boot.model.naming.Identifier
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy

class PhysicalNamingStrategy: SpringPhysicalNamingStrategy() {
    override fun toPhysicalTableName(name: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier {
        return name?.run { Identifier("test_${(text[0] + 32) + if (text.length > 1) text.substring(1) else ""}", isQuoted) }
                ?: super.toPhysicalTableName(name, jdbcEnvironment)
    }
}