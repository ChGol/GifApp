package com.chris.training.controller;

import com.chris.training.model.Gif;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GifController {

    @GetMapping("/")
    public String listGifs() {
        return "home";
    }

    @GetMapping("/gif")
    public String gifDetails(ModelMap modelMap){
        // co sie ma dziac - akcaj, zmienna z kontrollera do widoku
        Gif gif = new Gif("android-explosion", "Chris", true);
        // model map to hash mapa
        modelMap.addAttribute("gif", gif);
        return "gif-details";
    }

}
