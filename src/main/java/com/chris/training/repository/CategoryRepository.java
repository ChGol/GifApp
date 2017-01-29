package com.chris.training.repository;

import com.chris.training.model.Category;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORY = Arrays.asList(
            new Category(1, "GIFs"),
            new Category(2, "Mems"),
            new Category(3, "Technology")
    );

    public List<Category> getAllCategories() {
        return ALL_CATEGORY;
    }

    public Category findById(int id) {
        for (Category category : ALL_CATEGORY) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

}
