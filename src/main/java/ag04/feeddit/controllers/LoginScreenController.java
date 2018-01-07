package ag04.feeddit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginScreenController
{
    @RequestMapping("/")
    String loginScreen()
    {
        return "loginScreen";
    }
}
