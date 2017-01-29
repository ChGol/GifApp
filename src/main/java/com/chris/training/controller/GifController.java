package com.chris.training.controller;

import com.chris.training.model.Gif;
import com.chris.training.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/")
    public String listGifs() {
        return "home";
    }

    @GetMapping("/gif")
    public String gifDetails(ModelMap modelMap){
        // co sie ma dziac - akcaj, zmienna z kontrollera do widoku
        Gif gif = gifRepository.findByName("android-explosion");
        // model map to hash mapa
        modelMap.addAttribute("gif", gif);
        return "gif-details";
    }

}
