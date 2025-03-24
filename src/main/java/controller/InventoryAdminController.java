package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InventoryAdminController {
    @GetMapping("inventoryAdmin")
    public String AdminInventory() {
        return "inventoryAdmin";
    }
}
