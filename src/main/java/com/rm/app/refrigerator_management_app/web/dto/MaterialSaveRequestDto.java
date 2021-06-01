package com.rm.app.refrigerator_management_app.web.dto;

import com.rm.app.refrigerator_management_app.domain.material.Material;
import com.rm.app.refrigerator_management_app.domain.memo.Memo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MaterialSaveRequestDto {
    private boolean egg;
    private boolean onion;
    private boolean orange;
    private boolean cabbage;
    private boolean cucumber;

    @Builder
    public MaterialSaveRequestDto(boolean egg, boolean onion, boolean orange, boolean cabbage, boolean cucumber) { // 테스트할 때 쓰는 듯?
        this.egg = egg;
        this.onion = onion;
        this.orange = orange;
        this.cabbage = cabbage;
        this.cucumber = cucumber;
    }

    public Material toEntity() {
        return Material.builder()
                .egg(egg)
                .onion(onion)
                .orange(orange)
                .cabbage(cabbage)
                .cucumber(cucumber)
                .build();
    }
}
