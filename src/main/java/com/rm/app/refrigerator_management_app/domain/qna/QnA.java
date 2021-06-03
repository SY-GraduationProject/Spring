package com.rm.app.refrigerator_management_app.domain.qna;

import lombok.*;

import javax.persistence.*;

@Getter // get메소드를 자동으로 생성
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="QNA") // JPA 어노테이션(테이블과 링크될 클래스를 나타낸다.)
public class QnA{

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String question;

    @Column(columnDefinition = "TEXT")
    private String answer;

    @Builder // 생성자에 포함된 필드만 빌더에 포함(생성자와 같은 기능) -> 생성자를 통해 최종값을 채우고 DB에 삽입
    public QnA(String name, String question, String answer) {
        this.name = name;
        this.question = question;
        this.answer = answer;
    }

}
