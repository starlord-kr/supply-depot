package com.starlord.demo.jpa.inheritance.case2;

import com.starlord.demo.jpa.users.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "CASE2_SUB_ITEM2")
@DiscriminatorValue("CASE2_SUB_ITEM2")
public class Case2SubItem2 extends Case2SuperItem {

    @Builder
    public Case2SubItem2(String name, Member member) {
        super(name, member);
        this.subItemName = name;
        this.subItemCreateDateTime = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CASE2_SUPER_ITEM_ID", referencedColumnName = "ID")
    private Case2SuperItem case2SuperItem;

    @Column(name = "name")
    private String subItemName;

    @Column(name = "CREATE_DATE_TIME")
    private LocalDateTime subItemCreateDateTime;

    @Column(name = "UPDATE_DATE_TIME")
    private LocalDateTime subItemUpdateDateTime;

}
