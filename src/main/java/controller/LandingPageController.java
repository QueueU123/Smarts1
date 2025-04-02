package controller;

import entity.User;
import jakarta.servlet.http.HttpSession;
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
                            @RequestParam String password,
                            HttpSession session) {
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isEmpty()) {
            return "redirect:/invalidUsername"; // Redirect if username is incorrect
        }

        User user = userOpt.get();

        if (!user.getPassword().equals(password)) {
            return "redirect:/invalidPassword"; // Redirect if password is incorrect
        }

        // ✅ Store everything needed
        session.setAttribute("authenticatedUser", user);  // for CAPTCHA (if still used)
        session.setAttribute("username", user.getUsername()); // ✅ Needed by getCurrentUser
        session.setAttribute("role", user.getRole()); // ✅ For conditional redirect or display

        // Redirect to CAPTCHA verification page
        return "redirect:/captcha";
    }

    @GetMapping("/projectManagementAdmin")
    public String projectManagementAdminPage() {
        return "projectManagementAdmin"; // redirection
    }

    @GetMapping("/invalidUsername")
    public String showInvalidUsernamePage() {
        return "invalidUsername"; // redirection
    }

    @GetMapping("/invalidPassword")
    public String showInvalidPasswordPage() {
        return "invalidPassword"; // redirection
    }

    @GetMapping("/confirmLogout")
    public String ConfirmLogout(){
            return "confirmLogout";
        }
}