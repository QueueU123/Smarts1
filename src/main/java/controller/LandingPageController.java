package controller;

import entity.User;
import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LandingPageController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String showLoginPage() {
        return "landingPage";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isEmpty()) {
            return "redirect:/invalidUsername"; // Redirect if username is incorrect
        }

        User user = userOpt.get();
        if (!user.getPassword().equals(password)) {
            return "redirect:/invalidPassword"; // Redirect if password is incorrect
        }

        String role = user.getRole();

        // Redirect based on role
        if ("admin".equalsIgnoreCase(role)) {
            return "redirect:/homepageAdmin";
        } else if ("main contractor".equalsIgnoreCase(role)) {
            return "redirect:/homepageGencon";
        } else if ("staff".equalsIgnoreCase(role)) {
            return "redirect:/homepageExestaff";
        } else {
            return "redirect:/invalidRole";
        }
    }

    @GetMapping("/invalidUsername")
    public String showInvalidUsernamePage() {
        return "invalidUsername"; // redirection
    }

    @GetMapping("/invalidPassword")
    public String showInvalidPasswordPage() {
        return "invalidPassword"; // redirection
    }

    @GetMapping("/invalidRole")
    public String showInvalidRolePage() {
        return "invalidRole"; // redirection
    }
}