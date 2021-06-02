package com.rm.app.refrigerator_management_app.domain.recipe;

import lombok.*;

import javax.persistence.*;

@Getter // get메소드를 자동으로 생성
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="RECIPE") // JPA 어노테이션(테이블과 링크될 클래스를 나타낸다.)
public class Recipe{

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String food;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String material;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String seq;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String link;

    @Builder // 생성자에 포함된 필드만 빌더에 포함(생성자와 같은 기능) -> 생성자를 통해 최종값을 채우고 DB에 삽입
    public Recipe(String name, String food, String material, String seq, String link) {
        this.name = name;
        this.food = food;
        this.material = material;
        this.seq = seq;
        this.link = link;
    }

}
