package cz.duzi.recipeapp.services;

import cz.duzi.recipeapp.commands.RecipeCommand;
import cz.duzi.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long id);
}
