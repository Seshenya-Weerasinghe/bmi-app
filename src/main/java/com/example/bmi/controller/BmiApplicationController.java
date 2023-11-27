package com.example.bmi.controller;

import com.example.bmi.BmiBean;
import com.example.bmi.service.BmiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//author - Seshenya Weerasinghe
//date - 07.11.2023-->
//matriculation number - 1454176

@Controller
public class BmiApplicationController {
    BmiService bmiService;
    public BmiApplicationController(BmiService bmiService) {
        this.bmiService = bmiService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("bmiList", bmiService.getAllBmiData());
        return "index";
    }

    @PostMapping("/calculate")
    public String bmiCalculator(@ModelAttribute("bmiobj") BmiBean bmiBean, Model model) {
        double bmi = calculateBmiValue(bmiBean.getHeight(), bmiBean.getWeight());
        bmiBean.setBmiValue(bmi);
        bmiService.saveUser(bmiBean);
        return "redirect:/"; // Redirect back to the index page after saving.
    }

    @RequestMapping("/result")
    public String result(@RequestParam("id") long id, Model model) {
        BmiBean bmiBean = bmiService.getBmiDataById(id);
        model.addAttribute("bmiBean", bmiBean);
        return "result";
    }

    private double calculateBmiValue(double height, double weight) {
        // BMI formula: weight (kg) / (height (m) * height (m))
        return weight / (height * height);
    }

}
