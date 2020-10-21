package com.starlord.module.common.review;

import com.starlord.module.common.review.MovieItem2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieItem2Repository extends JpaRepository<MovieItem2, Long> {

    MovieItem2 findByName(String name);

}

