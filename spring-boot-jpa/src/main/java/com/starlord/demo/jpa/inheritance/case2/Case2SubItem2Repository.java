package com.starlord.demo.jpa.inheritance.case2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Case2SubItem2Repository extends JpaRepository<Case2SubItem2, Long> {

    Case2SubItem2 findByName(String name);

}
