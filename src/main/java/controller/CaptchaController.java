package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CaptchaController {
    @GetMapping("captcha")
    public String CaptchaPage(){
        return "captcha";
    }
}
