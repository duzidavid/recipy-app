package cz.duzi.recipeapp.controllers;

import cz.duzi.recipeapp.commands.IngredientCommand;
import cz.duzi.recipeapp.services.IngredientService;
import cz.duzi.recipeapp.services.RecipeService;
import cz.duzi.recipeapp.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;


    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model) {

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId,
                                       @PathVariable String id, Model model) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(
                Long.valueOf(recipeId), Long.valueOf(id)));
        return "recipe/ingredient/show";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{ingredientId}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId, @PathVariable String ingredientId, Model model) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(
                Long.valueOf(recipeId), Long.valueOf(ingredientId)));

        model.addAttribute("uomList", unitOfMeasureService.listAllUoms());

        return "recipe/ingredient/ingredientform";
    }

    @PostMapping
    @RequestMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command) {
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }
}
