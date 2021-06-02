package com.rm.app.refrigerator_management_app.web;

import com.rm.app.refrigerator_management_app.service.recipe.RecipeService;
import com.rm.app.refrigerator_management_app.web.dto.RecipeListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class RecipeApiController {

    private final RecipeService recipeService;

    @GetMapping("/api/recipe/{id}")
    public RecipeListResponseDto findById (@PathVariable Long id) {
        return recipeService.findById(id);
    }
}
