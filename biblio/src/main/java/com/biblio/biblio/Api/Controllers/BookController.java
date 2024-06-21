package com.biblio.biblio.Api.Controllers;
import com.biblio.biblio.Api.Dto.Request.BookRequest;
import com.biblio.biblio.Api.Dto.Response.BookResponse;
import com.biblio.biblio.Infraestructure.IBookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/books")
public class BookController {
    @Autowired
    private final IBookService iBookService;

    public BookController(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(@Valid @RequestBody BookRequest requestDTO) {
        BookResponse responseDTO = iBookService.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> get(@PathVariable Long id) {
        BookResponse book = iBookService.get(id);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody BookRequest requestDTO
    ) {
        BookResponse updatedBook = iBookService.update(requestDTO, id);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        iBookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
