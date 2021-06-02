package com.rm.app.refrigerator_management_app.service.recipe;

import com.rm.app.refrigerator_management_app.domain.recipe.Recipe;
import com.rm.app.refrigerator_management_app.domain.recipe.RecipeRepository;
import com.rm.app.refrigerator_management_app.web.dto.RecipeListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;


    public RecipeListResponseDto findById(Long id) { // db 데이터를 변경하지 않으므로 Transactional 어노테이션을 사용하지 않음
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        return new RecipeListResponseDto(recipe);
    }
}
