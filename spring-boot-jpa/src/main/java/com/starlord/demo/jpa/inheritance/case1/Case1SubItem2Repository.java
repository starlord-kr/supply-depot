package com.starlord.demo.jpa.inheritance.case1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Case1SubItem2Repository extends JpaRepository<Case1SubItem2, Long> {

    Case1SubItem2 findByName(String name);

}
