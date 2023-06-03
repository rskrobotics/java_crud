package com.example.krud.Controller;

import com.example.krud.Models.User;
import com.example.krud.Repo.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> createUser(@Validated @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Crappy input!");
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        userRepo.save(user);
        return ResponseEntity.ok("User created successfully");
    }

    @PutMapping("/users/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        try {
            User existingUser = userRepo.findById(id).get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setAge(user.getAge());
            existingUser.setOccupation(user.getOccupation());
            userRepo.save(existingUser);
            return new ResponseEntity<>(existingUser, HttpStatus.OK);

        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("No such id!", HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
        try {
            User existingUser = userRepo.findById(id).get();
            userRepo.delete(existingUser);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("Nah bruh.", HttpStatus.NOT_ACCEPTABLE);
        }
    }


}
