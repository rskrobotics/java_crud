package com.example.krud.Controller;

import com.example.krud.Models.User;
import com.example.krud.Repo.UserRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiControllers {

    private final UserRepo userRepo;

    public ApiControllers(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String getPage(){
        return "WELCOME";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping(value="/save")
    public String saveUser(@RequestBody User user){
        System.out.println("I got a user: " + user);
        userRepo.save(user);
        return "Saved!";
    }
}
