package com.rm.app.refrigerator_management_app.domain.recipe;

import lombok.*;

import javax.persistence.*;

@Getter // get메소드를 자동으로 생성
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="MEMO") // JPA 어노테이션(테이블과 링크될 클래스를 나타낸다.)
public class Recipe{

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String food1;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String food2;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String valid;

    @Builder // 생성자에 포함된 필드만 빌더에 포함(생성자와 같은 기능) -> 생성자를 통해 최종값을 채우고 DB에 삽입
    public Recipe(String name, String food1, String food2, String valid) {
        this.name = name;
        this.food1 = food1;
        this.food2 = food2;
        this.valid = valid;
    }

}
