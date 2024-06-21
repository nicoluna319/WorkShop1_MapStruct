package com.biblio.biblio.Api.Dto.Request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class BookRequest {
    @NotBlank(message = "El título no puede estar en blanco")
    private String title;

    @NotBlank(message = "El autor no puede estar en blanco")
    private String author;

    @Min(value = 1000, message = "El año de publicación debe ser mayor o igual a 1000")
    private int publicationYear;

    @NotBlank(message = "El género no puede estar en blanco")
    private String genre;

    private String isbn;
}
