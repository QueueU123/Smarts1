package controller;

import entity.Project;
import entity.User;
import org.springframework.web.bind.annotation.*;
import repository.ProjectRepository;
import repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;


@Controller
public class  UserAdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/userAdmin/getUsers")
    @ResponseBody // Returns JSON data
    public List<User> getAllUsers() {
        return userRepository.findAll(); //Fetch all users from PostgreSQL
    }


    @PostMapping("/userAdmin/addUser") //Matches JS fetch call
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return userRepository.save(user); //Saves to "Accounts" table
    }

    @PutMapping("/userAdmin/updateUser/{user_id}") // Updates an existing user
    @ResponseBody
    public User updateUser(@PathVariable int user_id, @RequestBody User updatedUser) {
        Optional<User> existingUser = userRepository.findById(user_id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setRole(updatedUser.getRole());
            user.setPermissions(updatedUser.getPermissions());
            user.setProject(updatedUser.getProject());
            user.setStatus(updatedUser.getStatus());
            return userRepository.save(user); // Updates record in PostgreSQL
        }
        return null; // Handle error if user is not found
    }

    @GetMapping("/userAdmin")
    public String userAdminPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "userAdmin"; // sure "userAdmin.html" exists
    }
}