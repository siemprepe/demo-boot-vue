package com.siemprepe.demo.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
data class User(
        @Id val login: String,
        val firstname: String,
        val lastname: String,
        val password: String,
        val description: String? = null)