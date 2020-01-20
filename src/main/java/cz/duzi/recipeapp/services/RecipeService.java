package cz.duzi.recipeapp.services;

import cz.duzi.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
