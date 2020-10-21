package com.starlord.demo.jpa.inheritance.case2;

import com.starlord.demo.jpa.users.Member;
import com.starlord.demo.jpa.users.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
//@IdClass(Case2SuperItemId.class)
@Entity
@Table(name = "CASE2_SUPER_ITEM")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ITEM_TYPE")
public class Case2SuperItem {

    public Case2SuperItem(String name, Member member) {

        this.name = name;
        this.member = member;
        this.createDateTime = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    private Student student;

    @Column(name = "CREATE_DATE_TIME")
    private LocalDateTime createDateTime;

    @Column(name = "UPDATE_DATE_TIME")
    private LocalDateTime updateDateTime;

}
