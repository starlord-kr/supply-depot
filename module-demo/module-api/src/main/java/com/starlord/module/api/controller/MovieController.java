package com.starlord.module.api.controller;

import com.starlord.module.api.service.MovieService;
import com.starlord.module.api.service.StudentService;
import com.starlord.module.common.review.MovieReview;
import com.starlord.module.common.student.Student;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/movie")
public class MovieController {

    private static Logger LOG = LoggerFactory.getLogger(MovieController.class);

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/save")
    public MovieReview save() {
        log.info("-- save");
        return movieService.saveMovieReview();
    }

    @GetMapping("/{name}")
    public MovieReview findMovieReview(@PathVariable("name") String name) {
        log.info("-- findMovieReview");
        return movieService.findMovieReview(name);
    }

    @PutMapping("/{name}")
    public MovieReview updateMovieReview(@PathVariable("name") String name) {
        return movieService.updateMovieReview(name);
    }
}
