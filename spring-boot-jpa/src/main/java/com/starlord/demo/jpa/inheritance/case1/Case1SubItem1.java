package com.starlord.demo.jpa.inheritance.case1;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "CASE1_SUB_ITEM1")
@DiscriminatorValue("CASE1_SUB_ITEM1")
public class Case1SubItem1 extends Case1SuperItem {

    @Builder
    public Case1SubItem1(String name, LocalDateTime createDateTime) {
        super(name);
        this.name = name;
        this.createDateTime = createDateTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name; // super-class의 name과 동일하여 override, 상위속성으로 설정가능하다. (하위클래스의 속성으로 생성되지 않는다)

    @Column(name = "CREATE_DATE_TIME")
    private LocalDateTime createDateTime;

    @Column(name = "UPDATE_DATE_TIME")
    private LocalDateTime updateDateTime;

}
