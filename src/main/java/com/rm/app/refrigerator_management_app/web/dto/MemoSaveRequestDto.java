package com.rm.app.refrigerator_management_app.web.dto;

import com.rm.app.refrigerator_management_app.domain.memo.Memo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemoSaveRequestDto {
    private String content;
    private boolean complete;

    @Builder
    public MemoSaveRequestDto(String content, boolean complete) { // 테스트할 때 쓰는 듯?
        this.content = content;
        this.complete = complete;
    }

    public Memo toEntity() {
        return Memo.builder()
                .content(content)
                .complete(complete)
                .build();
    }
}
