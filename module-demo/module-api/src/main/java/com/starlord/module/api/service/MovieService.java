package com.starlord.module.api.service;

import com.starlord.module.common.review.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class MovieService {

    private final MovieReviewRepository movieReviewRepository;
    private final MovieItem1Repository movieItem1Repository;
    private final MovieItem2Repository movieItem2Repository;

    public MovieService(MovieReviewRepository movieReviewRepository,
                        MovieItem1Repository movieItem1Repository,
                        MovieItem2Repository movieItem2Repository) {

        this.movieReviewRepository = movieReviewRepository;
        this.movieItem1Repository = movieItem1Repository;
        this.movieItem2Repository = movieItem2Repository;
    }

    @Transactional
    public MovieReview saveMovieReview() {

//        MovieItem1 test = new MovieItem1();
//        test.setId(1L);
//        test.setName("starlord");
//        test.setEmail("slowstarter.dev@gmail.com");
//        test.setItemName("MovieItem1");

        TestTarget testTarget1 = TestTarget.builder().targetName("testTarget1").build();

        MovieItem1 item1 = MovieItem1.builder().name("starlord1").email("slowstarter.dev@gmail.com").build();
        item1.setItemName("MovieItem1");
        movieItem1Repository.save(item1);
        log.info("- item1: {}", item1);

        MovieItem2 item2 = MovieItem2.builder().name("starlord2").email("slowstarter.dev@gmail.com").build();
        item2.setItemName("MovieItem2");
        movieItem2Repository.save(item2);
        log.info("- item2: {}", item2);

//        return movieItem1Repository.getOne(item1.getId());
        return item1;
    }

    public MovieReview findMovieReview(String name) {

        return movieReviewRepository.findByName(name);
    }

    @Transactional
    public MovieReview updateMovieReview(String name) {

        MovieReview movieReview = movieReviewRepository.findByName(name);
        movieReview.setEmail("update.dev@gmail.com");

        return movieReview;
    }

}
