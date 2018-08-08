package com.siemprepe.demo.service

import com.siemprepe.demo.domain.User
import com.siemprepe.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService{

    @Autowired
    lateinit var userRepository: UserRepository

    fun checkUser(username: String, password: String):User? {
        val user = userRepository.findByLogin(username)
        return user.firstOrNull{it.password == password}
    }
}