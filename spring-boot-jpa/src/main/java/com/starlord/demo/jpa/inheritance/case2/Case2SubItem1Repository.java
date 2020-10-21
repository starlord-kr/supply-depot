package com.starlord.demo.jpa.inheritance.case2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Case2SubItem1Repository extends JpaRepository<Case2SubItem1, Long> {

    Case2SubItem1 findByName(String name);

}
