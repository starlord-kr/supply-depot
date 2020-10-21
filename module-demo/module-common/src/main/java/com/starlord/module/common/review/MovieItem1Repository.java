package com.starlord.module.common.review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieItem1Repository extends JpaRepository<MovieItem1, Long> {

    MovieItem1 findByName(String name);

}

