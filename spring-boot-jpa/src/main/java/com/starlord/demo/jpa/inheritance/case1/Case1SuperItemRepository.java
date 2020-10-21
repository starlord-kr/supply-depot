package com.starlord.demo.jpa.inheritance.case1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Case1SuperItemRepository extends JpaRepository<Case1SuperItem, Long> {

    Case1SuperItem findByName(String name);

}
