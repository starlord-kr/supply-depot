package com.starlord.demo.jpa.inheritance.case2;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity(name = "CASE2_SUPER_ITEM")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ITEM_TYPE")
public class Case2SuperItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATE_DATE_TIME")
    private LocalDateTime createDateTime;

    @Column(name = "UPDATE_DATE_TIME")
    private LocalDateTime updateDateTime;

}
