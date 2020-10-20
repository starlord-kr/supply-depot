package com.starlord.demo.jpa.inheritance.case1;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity(name = "CASE1_SUB_ITEM1")
@DiscriminatorValue("CASE1_SUB_ITEM1")
public class Case1SubItem1 extends Case1SuperItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "CREATE_DATE_TIME")
    private LocalDateTime subItemCreateDateTime;

    @Column(name = "UPDATE_DATE_TIME")
    private LocalDateTime subItemUpdateDateTime;

}
