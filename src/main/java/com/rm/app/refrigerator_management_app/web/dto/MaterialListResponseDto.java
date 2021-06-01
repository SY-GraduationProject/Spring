package com.rm.app.refrigerator_management_app.web.dto;

import com.rm.app.refrigerator_management_app.domain.material.Material;
import lombok.Getter;

@Getter
public class MaterialListResponseDto {
    private Long id;
    private boolean egg;
    private boolean onion;
    private boolean orange;
    private boolean cabbage;
    private boolean cucumber;

    public MaterialListResponseDto(Material entity) {
        this.id = entity.getId();
        this.egg = entity.getEgg();
        this.onion = entity.getOnion();
        this.orange = entity.getOrange();
        this.cabbage = entity.getCabbage();
        this.cucumber = entity.getCucumber();
    }
}
