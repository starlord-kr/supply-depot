package com.starlord.demo.jpa.inheritance.case2;

import com.starlord.demo.jpa.users.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CASE2_SUB_ITEM1")
@DiscriminatorValue("CASE2_SUB_ITEM1")
//@AttributeOverride(name = "ID", column = @Column(name = "SUPER_ITEM_ID"))
public class Case2SubItem1 {

//    @Builder
    public Case2SubItem1(String name, Member member) {

//        super(name, member);
        this.subItemCreateDateTime = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JoinColumns({
//            @JoinColumn(name = "SUPER_ITEM_ID", referencedColumnName = "ID")
//    })
//    @Column(name = "SUPER_ITEM_ID")
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SUPER_ITEM_ID", referencedColumnName = "ID")
    private Case2SuperItem case2SuperItem;

    @Column(name = "name")
    private String name;

    @Column(name = "CREATE_DATE_TIME")
    private LocalDateTime subItemCreateDateTime;

    @Column(name = "UPDATE_DATE_TIME")
    private LocalDateTime subItemUpdateDateTime;

}
