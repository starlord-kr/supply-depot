package com.starlord.demo.jpa.inheritance.case1;

import com.starlord.demo.jpa.inheritance.CommonDateEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CASE1_SUPER_ITEM")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ITEM_TYPE")
public class Case1SuperItem extends CommonDateEntity {

    public Case1SuperItem(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

}
