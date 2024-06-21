package com.biblio.biblio.Api.Dto.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;
    @JsonProperty("publicationYear")
    private int publicationYear;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("isbn")
    private String isbn;
}
