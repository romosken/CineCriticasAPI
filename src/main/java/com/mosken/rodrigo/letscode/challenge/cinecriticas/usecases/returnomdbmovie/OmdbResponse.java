package com.mosken.rodrigo.letscode.challenge.cinecriticas.usecases.returnomdbmovie;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class OmdbResponse {


    private String title;
    private String year;
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String poster;
    private List<RatingResponse> ratings;
    private String metascore;
    private String imdbRating;
    private String imdbVotes;
    private String imdbID;
    private String type;
    private String dvd;
    private String boxOffice;
    private String production;
    private String website;
    private String response;

    @Data
    @Builder
    public static class RatingResponse {

        private String source;
        private String value;

    }

}
