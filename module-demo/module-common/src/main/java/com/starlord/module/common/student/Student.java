package com.starlord.module.common.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String email;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
