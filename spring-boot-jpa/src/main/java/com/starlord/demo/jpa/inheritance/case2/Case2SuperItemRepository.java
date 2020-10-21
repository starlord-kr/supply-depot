package com.starlord.demo.jpa.inheritance.case2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Case2SuperItemRepository extends JpaRepository<Case2SuperItem, Long> {

    Case2SuperItem findByName(String name);

}
