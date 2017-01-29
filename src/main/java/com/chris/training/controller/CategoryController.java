package com.chris.training.controller;

import com.chris.training.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    //@RequestMapping(value = "/categories", method = {RequestMethod.POST})
    @GetMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryRepository.getAllCategories());
        return "/categories";
    }

    @GetMapping("/category/{id}")
    public String categoryDetails(@PathVariable int id, ModelMap modelMap) {
        modelMap.put("category", categoryRepository.findById(id));
        return "category";
    }


}
