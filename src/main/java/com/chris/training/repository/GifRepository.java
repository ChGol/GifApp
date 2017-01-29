package com.chris.training.repository;

import com.chris.training.model.Gif;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class GifRepository {

    private static List<Gif> All_GIFS = Arrays.asList(new Gif("android-explosion", "michalos", false),
            new Gif("cowboy-coder", "Chris", true),
            new Gif("ben-and-mike", "Chris", false),
            new Gif("book-dominos", "Magda", false),
            new Gif("compiler-bot", "Magda", false),
            new Gif("infinite-andrew", "Magda", true));

    public Gif findByName(String name) {
        for (Gif gif : All_GIFS) {
            if (gif.getName().equals(name))
                return gif;
            else
                return null;
        }
        return null;
    }

    public List<Gif> getAllGifs() {
        return All_GIFS;
    }

    public List<Gif> getFavorites() {
        List<Gif> favorites = new ArrayList<>();
        for (Gif gif : All_GIFS) {
            if (gif.isFavorite())
                favorites.add(gif);
        }
        return favorites;
    }
}
