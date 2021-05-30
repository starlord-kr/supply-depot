package com.starlord.demo.jpa.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByName(String name);

    Page<Member> findAllByReviewer(Admin reviewer, Pageable pageable);

    Member findFirstMemberByIdBeforeAndReviewer(Long id, Admin reviewer);

    Member findFirstMemberByIdAfterAndReviewer(Long id, Admin reviewer);

//    Page<Member> findAllByReviewer(Admin reviewer, Pageable pageable);
}

