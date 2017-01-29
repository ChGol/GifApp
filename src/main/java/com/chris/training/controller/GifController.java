package com.chris.training.controller;

import com.chris.training.model.Gif;
import com.chris.training.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/")
    public String listGifs(ModelMap modelMap){
        modelMap.addAttribute("gifs", gifRepository.getAllGifs());
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

    @GetMapping("/favorites")
    public String favorites(ModelMap modelMap){
        modelMap.addAttribute("gifs", gifRepository.getFavorites());
        return "favorites";
    }

    @GetMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        modelMap.put("gif", gifRepository.findByName(name));
        return "gif-details";
    }

}
