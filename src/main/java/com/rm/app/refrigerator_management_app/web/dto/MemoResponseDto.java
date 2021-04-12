package com.rm.app.refrigerator_management_app.web.dto;
import com.rm.app.refrigerator_management_app.domain.memo.Memo;

import lombok.Getter;

@Getter
public class MemoResponseDto {
    private Long id;
    private String content;
    private boolean complete;

    public MemoResponseDto(Memo entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.complete = entity.getComplete();
    }
}
