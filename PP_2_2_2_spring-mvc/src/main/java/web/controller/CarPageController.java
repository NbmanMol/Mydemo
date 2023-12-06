package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImp;

@Controller
public class CarPageController {
    @Autowired
    CarService carService;
    @GetMapping("/cars")
    public String printCarTable(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null || count >= 5) {
            model.addAttribute("fixedCar", carService.getCarList());
        } else {
            model.addAttribute("fixedCar", carService.getFixedCarList(count));
        }
        return "cars";
    }
}
