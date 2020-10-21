package com.starlord.demo.jpa.inheritance.case1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Case1SubItem1Repository extends JpaRepository<Case1SubItem1, Long> {

    Case1SubItem1 findByName(String name);

}
