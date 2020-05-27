package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    CarRepository carRepository;

    @RequestMapping("/")
    public String listCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "listCars";
    }

    @GetMapping("/add")
    public String addCar(Model model) {
        model.addAttribute("car", new Car());
        return "addCar";
    }

    @PostMapping("/add")
    public String checkCar(@Valid Car car, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addCar";
        } else {
            carRepository.save(car);
            return "redirect:/";
        }
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("car", carRepository.findById(id).get());
        return "addCar";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        carRepository.deleteById(id);
        return "redirect:/";
    }
}
