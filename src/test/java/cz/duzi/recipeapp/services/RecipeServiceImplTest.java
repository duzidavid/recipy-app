package cz.duzi.recipeapp.services;

import cz.duzi.recipeapp.converters.RecipeCommandToRecipe;
import cz.duzi.recipeapp.converters.RecipeToRecipeCommand;
import cz.duzi.recipeapp.domain.Recipe;
import cz.duzi.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeService recipeService;
    RecipeCommandToRecipe recipeCommandToRecipe;
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);

    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);

        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void findById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> optionalRecipe = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);

        Recipe returnedRecipe = recipeService.findById(1L);

        assertNotNull("NOT NULL", returnedRecipe);
        verify(recipeRepository,times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test(expected = RuntimeException.class)
    public void findByIdNoId() {
        recipeService.findById(12L);
    }

    @Test
    public void deleteById() {
        //given, when
        recipeService.deleteById(2L);
        //then
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }
}