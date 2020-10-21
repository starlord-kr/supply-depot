package com.starlord.demo.service;

import com.starlord.demo.jpa.inheritance.case1.*;
import com.starlord.demo.jpa.inheritance.case2.*;
import com.starlord.demo.jpa.users.Member;
import com.starlord.demo.jpa.users.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class InheritanceService {

    private final MemberRepository memberRepository;

    private final Case1SuperItemRepository case1SuperItemRepository;
    private final Case1SubItem1Repository case1SubItem1Repository;
    private final Case1SubItem2Repository case1SubItem2Repository;

    private final Case2SuperItemRepository case2SuperItemRepository;
    private final Case2SubItem1Repository case2SubItem1Repository;
    private final Case2SubItem2Repository case2SubItem2Repository;

    @Transactional
    public Case1SuperItem getCase1SuperItem(String name) {

        Case1SuperItem superItem = new Case1SuperItem();
        superItem.setName(name);
        return case1SuperItemRepository.save(superItem);
    }

    @Transactional
    public Case1SubItem1 getCase1SubItem1(String name) {

        Case1SubItem1 subItem1 =
                Case1SubItem1
                        .builder()
                        .name(name) // super 의 name으로 입력된다.
                        .createDateTime(LocalDateTime.now())
                        .build();
        return case1SubItem1Repository.save(subItem1);
    }

    @Transactional
    public Case1SubItem2 getCase1SubItem2(String name) {

        Case1SubItem2 subItem2 =
                Case1SubItem2
                        .builder()
                        .subItemName(name)
                        .build();
        return case1SubItem2Repository.save(subItem2);
    }

    @Transactional
    public Case2SuperItem getCase2SuperItem(String name) {

        Member member = memberRepository.findByName("member1");
        Case2SuperItem superItem = new Case2SuperItem(name, member);
        return case2SuperItemRepository.save(superItem);
    }

    @Transactional
    public Case2SubItem1 getCase2SubItem1(String name) {

        Member member = memberRepository.findByName("member2");
        Case2SuperItem superItem = new Case2SuperItem(name, member);
//        case2SuperItemRepository.save(superItem); // Case2SubItem1 에서,

        Case2SubItem1 subItem1 = new Case2SubItem1(name, member);
        subItem1.setCase2SuperItem(superItem);
        subItem1.setName(name);
        return case2SubItem1Repository.save(subItem1);
    }

    @Transactional
    public Case2SubItem2 getCase2SubItem2(String name) {

        Member member = memberRepository.findByName("member2");
        Case2SubItem2 subItem2 =
                Case2SubItem2
                        .builder()
                        .name(name)
                        .member(member)
                        .build();
        return case2SubItem2Repository.save(subItem2);
    }

}
