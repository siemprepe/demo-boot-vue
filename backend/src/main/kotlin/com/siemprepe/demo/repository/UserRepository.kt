package com.siemprepe.demo.repository

import com.siemprepe.demo.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String>{
    fun findByLogin(login: String): List<User>
}