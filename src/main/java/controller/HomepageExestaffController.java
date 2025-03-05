package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageExestaffController {
    @GetMapping("homepageExestaff")
    public String HomepageExestaff(){
        return "homepageExestaff";
    }
}
