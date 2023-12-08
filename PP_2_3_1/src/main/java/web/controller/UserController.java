package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public String printUserTable(Model model) {
//        userService.createUser(new User("Admin","Neponal","kakDelatConfig@grustno.com"));
        model.addAttribute("fixedUser", userService.getUserList());
        return "users";
    }
//    @GetMapping("/id")
//    public String printUserforId(@RequestParam(value = "id", required = true) Integer id, Model model) {
//        model.addAttribute("user",userService.getUserForId(id));
//        return "users/id";
//    }
}
