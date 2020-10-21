package com.starlord.demo.controller;

import com.starlord.demo.jpa.users.Admin;
import com.starlord.demo.jpa.users.AdminRepository;
import com.starlord.demo.jpa.users.Member;
import com.starlord.demo.jpa.users.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/jpa/")
public class MemberController {

    private final AdminRepository adminRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/members")
    public Page<Member> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

        return memberRepository.findAll(pageable);
    }

    @GetMapping("/members/byreviewer")
    public Page<Member> findAllByReviewer(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

        Optional<Admin> admin = adminRepository.findById(1L);
        return memberRepository.findAllByReviewer(admin.get(), pageable);
    }

    @GetMapping("/members/before")
    public Member findMemberByIdBeforeAndReviewer(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

        Optional<Admin> admin = adminRepository.findById(1L);
        return memberRepository.findFirstMemberByIdBeforeAndReviewer(2L, admin.get());
    }

    @GetMapping("/members/after")
    public Member findMemberByIdAfterAndReviewer(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

        Optional<Admin> admin = adminRepository.findById(1L);
        return memberRepository.findFirstMemberByIdAfterAndReviewer(2L, admin.get());
    }
}
