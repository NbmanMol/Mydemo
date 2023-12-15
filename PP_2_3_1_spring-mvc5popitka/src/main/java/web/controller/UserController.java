package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        userService.createUser(new User("ЯНиче", "НеПонял", "@Грустно.com"));
        userService.createUser(new User("ЯНиче", "НеПонял", "@Грустно.com"));
    }

    @GetMapping()
    public String printUserTable(Model model) {
        model.addAttribute("ListUser", userService.getUserList());
        return "users";
    }

    @GetMapping("/new")
    public String createNewUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String updateUser(Model model, @RequestParam Integer id) {
        model.addAttribute("user", userService.getUserForId(id));
        return "update";
    }

    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute("user") User updatedUser) {
        userService.updateUser(updatedUser);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String removeUser(@RequestParam Integer id) {
        userService.deleteUser(userService.getUserForId(id));
        return "redirect:/users";
    }
}