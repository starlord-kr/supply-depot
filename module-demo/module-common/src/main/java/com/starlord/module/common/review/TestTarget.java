package com.starlord.module.common.review;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "TEST_TARGET")
public class TestTarget {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String targetName;

}
