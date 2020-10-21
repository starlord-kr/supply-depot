package com.starlord.demo.controller;

import com.starlord.demo.jpa.inheritance.case1.Case1SubItem1;
import com.starlord.demo.jpa.inheritance.case1.Case1SubItem2;
import com.starlord.demo.jpa.inheritance.case1.Case1SuperItem;
import com.starlord.demo.jpa.inheritance.case2.Case2SubItem1;
import com.starlord.demo.jpa.inheritance.case2.Case2SubItem2;
import com.starlord.demo.jpa.inheritance.case2.Case2SuperItem;
import com.starlord.demo.service.InheritanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/jpa/inheritances")
public class InheritanceController {

    private final InheritanceService inheritanceService;

    @GetMapping("/case1/super/{name}")
    public Case1SuperItem getCase1SuperItem(@PathVariable("name") String name) {
        log.info("- getCase1SuperItem");
        return inheritanceService.getCase1SuperItem(name);
    }

    @GetMapping("/case1/sub1/{name}")
    public Case1SubItem1 getCase1SubItem1(@PathVariable("name") String name) {
        log.info("- getCase1SubItem1");
        return inheritanceService.getCase1SubItem1(name);
    }

    @GetMapping("/case1/sub2/{name}")
    public Case1SubItem2 getCase1SubItem2(@PathVariable("name") String name) {
        log.info("- getCase1SubItem2");
        return inheritanceService.getCase1SubItem2(name);
    }

    @GetMapping("/case2/super/{name}")
    public Case2SuperItem getCase2SuperItem(@PathVariable("name") String name) {
        log.info("- getCase2SuperItem");
        return inheritanceService.getCase2SuperItem(name);
    }

    @GetMapping("/case2/sub1/{name}")
    public Case2SubItem1 getCase2SubItem1(@PathVariable("name") String name) {
        log.info("- getCase2SubItem1");
        return inheritanceService.getCase2SubItem1(name);
    }

    @GetMapping("/case2/sub2/{name}")
    public Case2SubItem2 getCase2SubItem2(@PathVariable("name") String name) {
        log.info("- getCase2SubItem2");
        return inheritanceService.getCase2SubItem2(name);
    }

}
