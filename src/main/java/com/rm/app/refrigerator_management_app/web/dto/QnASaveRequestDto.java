package com.rm.app.refrigerator_management_app.web.dto;

import com.rm.app.refrigerator_management_app.domain.qna.QnA;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QnASaveRequestDto {
    private String name;
    private String question;
    private String answer;

    @Builder
    public QnASaveRequestDto(String name, String question, String answer) { // 테스트할 때 쓰는 듯?
        this.name = name;
        this.question = question;
        this.answer = answer;
    }

    public QnA toEntity() {
        return QnA.builder()
                .name(name)
                .question(question)
                .answer(answer)
                .build();
    }
}
