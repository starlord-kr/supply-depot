package com.starlord.module.common.review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {

    MovieReview findByName(String name);

}

