package com.chris.training.repository;

import com.chris.training.model.Gif;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class GifRepository {

    private static List<Gif> All_GIFS = Arrays.asList(
            new Gif("android-explosion", "michalos", false, 1),
            new Gif("cowboy-coder", "Chris", true, 1),
            new Gif("ben-and-mike", "Chris", false, 2),
            new Gif("book-dominos", "Magda", false, 2),
            new Gif("compiler-bot", "Magda", false, 3),
            new Gif("infinite-andrew", "Magda", true, 3));

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

    public List<Gif> findByCategoryId(int categoryId) {

        List<Gif> gifs = new ArrayList<>();
        for (Gif gif : All_GIFS) {
            if (gif.getCategoryId() == categoryId) {
                gifs.add(gif);
            }
        }
        return gifs;
    }
}
