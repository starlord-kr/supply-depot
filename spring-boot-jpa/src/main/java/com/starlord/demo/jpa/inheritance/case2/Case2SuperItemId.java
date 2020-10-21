package com.starlord.demo.jpa.inheritance.case2;

import java.io.Serializable;

public class Case2SuperItemId implements Serializable {

    private Long id1;

    public Case2SuperItemId() {}

    public Case2SuperItemId(Long id1) {
        this.id1 = id1;
    }

    @Override
    public boolean equals(Object o) {

        return Boolean.TRUE;
    }

    @Override
    public int hashCode() {

        return id1.hashCode();
    }
}
