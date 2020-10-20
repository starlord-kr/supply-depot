package com.starlord.demo.jpa.inheritance.case1;

import com.starlord.demo.jpa.inheritance.CommonDateEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity(name = "CASE1_SUPER_ITEM")
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "ITEM_TYPE")
public class Case1SuperItem extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "CREATE_DATE_TIME")
//    private LocalDateTime createDateTime;
//
//    @Column(name = "UPDATE_DATE_TIME")
//    private LocalDateTime updateDateTime;

}
