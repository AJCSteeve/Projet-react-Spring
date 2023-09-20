package com.example.projetreactspringboot.controller;

import com.example.projetreactspringboot.model.User;
import com.example.projetreactspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/users")
    public List<User>getAll()
        {
        if (userRepo.findAll().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return userRepo.findAll();
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getByUsernameIsContainingIgnoreCase(@RequestParam String username)
        {
        if (userRepo.findByUsernameIsContainingIgnoreCase(username) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return userRepo.findByUsernameIsContainingIgnoreCase(username);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getById(@PathVariable Long id)
        {
        if (userRepo.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return userRepo.findById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody User user)
    {
        userRepo.save(new User(user.getUsername(), user.getEmail()));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateById(@PathVariable("id") Long id, @RequestBody User userToUpdate)
     {
        Optional<User> updateTarget = userRepo.findById(id);
        if (updateTarget.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        User updateUser = updateTarget.get();
        updateUser.setUsername(userToUpdate.getUsername());
        updateUser.setEmail(userToUpdate.getEmail());
        userRepo.save(updateUser);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userToUpdate);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deletedById(@PathVariable("id") Long id)
    {
        Optional<User> userToDelete = userRepo.findById(id);
        if (userToDelete.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
