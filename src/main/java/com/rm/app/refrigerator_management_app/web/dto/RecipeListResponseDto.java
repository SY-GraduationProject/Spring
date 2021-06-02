package com.rm.app.refrigerator_management_app.web.dto;

import com.rm.app.refrigerator_management_app.domain.recipe.Recipe;
import lombok.Getter;

@Getter
public class RecipeListResponseDto {
    private Long id;
    private String name;
    private String food;
    private String material;
    private String seq;
    private String link;

    public RecipeListResponseDto(Recipe entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.food = entity.getFood();
        this.material = entity.getMaterial();
        this.seq = entity.getSeq();
        this.link = entity.getLink();
    }
}
