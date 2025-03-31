package controller;

import entity.Inventory;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.InventoryRepository;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class GeneralInventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private UserRepository userRepository;

    // Load page based on user's role
    @GetMapping("/generalInventory")
    public String loadInventoryPage(@RequestParam("username") String username, Model model) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            User currentUser = optionalUser.get();
            List<Inventory> inventoryList = inventoryRepository.findAll();
            model.addAttribute("inventory", inventoryList);

            String role = currentUser.getRole();
            if ("ADMIN".equalsIgnoreCase(role)) {
                return "inventoryAdmin";
            } else if ("EXESTAFF".equalsIgnoreCase(role)) {
                return "inventoryExestaff";
            }
        }

        return "error"; // fallback if user not found or invalid role
    }

    // REST: Get inventory as JSON
    @GetMapping("/generalInventory/getInventory")
    @ResponseBody
    public List<Inventory> getInventory() {
        return inventoryRepository.findAll();
    }

    // REST: Add inventory item
    @PostMapping("/generalInventory/addInventory")
    @ResponseBody
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
}
