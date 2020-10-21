package com.starlord.module.common.movie;

import com.starlord.module.common.review.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private MovieReviewRepository movieReviewRepository;
    @Autowired
    private MovieItem1Repository movieItem1Repository;
    @Autowired
    private MovieItem2Repository movieItem2Repository;

    @Test
    public void add() {
        movieItem1Repository.saveAndFlush(MovieItem1.builder().name("starlord1").email("slowstarter@gmail.com").build());
        MovieItem1 movieItem1 = movieItem1Repository.findById(1l).get();
        assertThat(movieItem1.getName(), is("starlord1"));

        MovieItem2 movieItem2 = MovieItem2.builder().name("starlord2").email("slowstarter@gmail.com").build();
        movieItem2Repository.saveAndFlush(movieItem2);
        System.out.println("- movieItem2:" + movieItem2.getId());
        System.out.println("- movieItem2:" + movieItem2);

        testEntityManager.persistAndFlush(movieItem1);
        testEntityManager.persistAndFlush(movieItem2);

        MovieReview movieReview = movieReviewRepository.findByName("starlord1");
        System.out.println("- actual:" + movieReview);
        assertThat(movieReview.getName(), is("starlord1"));
    }

}