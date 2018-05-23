package com.studies.keyrenelu.controller;

import com.studies.keyrenelu.bean.User;
import com.studies.keyrenelu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello Spring Boot";
    }

    @RequestMapping("/getUser")
    public User getUser(){
        return userRepository.findUserByUserName("刘强大");
    }

    @RequestMapping("/user/add")
    public User addUser(User user){
        return userRepository.save(user);
    }

    @RequestMapping("/user/delete")
    public List<User> deleteUser(Long id){
        userRepository.delete(id);
        return userRepository.findAll();
    }

    @RequestMapping("/user/list")
    public List<User> getUserList(){
        return userRepository.findAll();
    }
}
