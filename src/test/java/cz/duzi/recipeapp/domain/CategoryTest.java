package cz.duzi.recipeapp.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    private static Category category;

    @BeforeAll
    private static void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        Long idValue = 4l;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipes() {
    }
}