package com.rectivespring.movie_service.controller;

import com.rectivespring.movie_service.client.MoviesInfoRestClient;
import com.rectivespring.movie_service.client.ReviewsRestClient;
import com.rectivespring.movie_service.domain.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/movies")
public class MoviesController {

    private MoviesInfoRestClient moviesInfoRestClient;
    private ReviewsRestClient reviewsRestClient;

    public MoviesController(MoviesInfoRestClient moviesInfoRestClient, ReviewsRestClient reviewsRestClient) {
        this.moviesInfoRestClient = moviesInfoRestClient;
        this.reviewsRestClient = reviewsRestClient;
    }

    @GetMapping("/{id}")
    public Mono<Movie> retrieveMovieById(@PathVariable(name = "id") String movieId){

        return moviesInfoRestClient.retrieveMovieInfo(movieId)
            .flatMap(movieInfo -> {
                var reviewListMono = reviewsRestClient.retrieveReviews(movieId)
                    .collectList();

                return reviewListMono.map(reviews -> new Movie(movieInfo, reviews));
            });
    }
}
