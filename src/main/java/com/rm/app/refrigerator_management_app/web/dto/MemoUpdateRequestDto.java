package com.rm.app.refrigerator_management_app.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemoUpdateRequestDto {
    private String content;
    private boolean complete;

    @Builder
    public MemoUpdateRequestDto(String content, boolean complete) { // 테스트할 때 쓰는 듯?
        this.content = content;
        this.complete = complete;
    }
}
