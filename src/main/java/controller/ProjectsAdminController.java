package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectsAdminController {
    @GetMapping("projectsAdmin")
    public String ProjectsAdmin(){
        return "projectsAdmin";
    }
}
