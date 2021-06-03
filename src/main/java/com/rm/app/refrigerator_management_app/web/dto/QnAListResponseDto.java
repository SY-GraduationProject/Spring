package com.rm.app.refrigerator_management_app.web.dto;

import com.rm.app.refrigerator_management_app.domain.material.Material;
import com.rm.app.refrigerator_management_app.domain.qna.QnA;
import lombok.Getter;

import javax.xml.soap.Text;

@Getter
public class QnAListResponseDto {
    private Long id;
    private String name;
    private String question;
    private String answer;

    public QnAListResponseDto(QnA entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.question = entity.getQuestion();
        this.answer = entity.getAnswer();
    }
}
