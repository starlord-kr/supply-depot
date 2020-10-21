package com.starlord.demo.jpa.inheritance.case1;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "CASE1_SUB_ITEM2")
@DiscriminatorValue("CASE1_SUB_ITEM2")
public class Case1SubItem2 extends Case1SuperItem {

    @Builder
    public Case1SubItem2(String subItemName, LocalDateTime createDateTime) {
        this.subItemName = subItemName;
        this.subItemCreateDateTime = createDateTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String subItemName;

    @Column(name = "CREATE_DATE_TIME")
    private LocalDateTime subItemCreateDateTime;

    @Column(name = "UPDATE_DATE_TIME")
    private LocalDateTime subItemUpdateDateTime;

}
