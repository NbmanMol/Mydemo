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
        userService.createOrUpdateUser(new User("ЯНиче", "НеПонял", "@Грустно.com"));
        userService.createOrUpdateUser(new User("ЯНиче", "НеПонял", "@Грустно.com"));
    }

    @GetMapping()
    public String printUserTable(Model model) {
        model.addAttribute("ListUser", userService.getUserList());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("User", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("User") User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String updateUser(Model model, @RequestParam Integer id) {
        model.addAttribute("user", userService.getUserForId(id));
        return "update";
    }

//    @PatchMapping("/update")
//    public String saveUpdates(@ModelAttribute User updatedUser,@RequestParam Integer id) {
//        userService.createOrUpdateUser(updatedUser);
//        User existingUser = userService.getUserForId(id);
//        existingUser.setFirstName(updatedUser.getFirstName());
//        existingUser.setLastName(updatedUser.getLastName());
//        existingUser.setEmail(updatedUser.getEmail());
//        userService.updateUser(updatedUser);
//        return "redirect:/users";
//    }

    @DeleteMapping()
    public String removeUser(@RequestParam Integer id) {
            userService.deleteUser(userService.getUserForId(id));
        return "redirect:/users";
    }
}