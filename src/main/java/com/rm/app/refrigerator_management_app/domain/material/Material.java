package com.rm.app.refrigerator_management_app.domain.material;

import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="MATERIAL")
public class Material {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규
    private Long id;

    @Column(columnDefinition = "boolean default true")
    private Boolean egg = true;

    @Column(columnDefinition = "boolean default true")
    private Boolean onion = true;

    @Column(columnDefinition = "boolean default true")
    private Boolean orange = true;

    @Column(columnDefinition = "boolean default true")
    private Boolean cabbage = true;

    @Column(columnDefinition = "boolean default true")
    private Boolean cucumber = true;

    @Builder // 생성자에 포함된 필드만 빌더에 포함(생성자와 같은 기능) -> 생성자를 통해 최종값을 채우고 DB에 삽입
    public Material(boolean egg, boolean onion, boolean orange, boolean cabbage, boolean cucumber) {
        this.egg = egg;
        this.onion = onion;
        this.orange = orange;
        this.cabbage = cabbage;
        this.cucumber = cucumber;
    }
}
