package com.siemprepe.demo.controller

import com.siemprepe.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController {

    @Autowired
    lateinit var userService: UserService

    @PostMapping("/api/checkuser")
    fun postCheckUser(@RequestParam("username") username: String,
                  @RequestParam("password") password: String): Boolean{
        return if (userService.checkUser(username,password) != null) true else false
    }
}