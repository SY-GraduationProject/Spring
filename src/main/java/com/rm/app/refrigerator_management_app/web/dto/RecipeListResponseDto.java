package com.rm.app.refrigerator_management_app.web.dto;

import com.rm.app.refrigerator_management_app.domain.recipe.Recipe;
import lombok.Getter;

@Getter
public class RecipeListResponseDto {
    private Long id;
    private String name;
    private String food1;
    private String food2;
    private String valid;

    public RecipeListResponseDto(Recipe entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.food1 = entity.getFood1();
        this.food2 = entity.getFood2();
        this.valid = entity.getValid();
    }
}
