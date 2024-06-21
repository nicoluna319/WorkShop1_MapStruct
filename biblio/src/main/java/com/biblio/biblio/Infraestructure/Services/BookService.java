package com.biblio.biblio.Infraestructure.Services;
import com.biblio.biblio.Api.Dto.Request.BookRequest;
import com.biblio.biblio.Api.Dto.Response.BookResponse;
import com.biblio.biblio.Api.Dto.Response.UserResponse;
import com.biblio.biblio.Domain.Entity.Book;
import com.biblio.biblio.Domain.Entity.User;
import com.biblio.biblio.Domain.Repository.BookRepository;
import com.biblio.biblio.Infraestructure.IBookService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class BookService implements IBookService {

    private BookRepository bookRepository;
    private ModelMapper modelMapper;


    @Override
    public BookResponse create(BookRequest request) {
        Book book = modelMapper.map(request, Book.class);
        Book savedBook = bookRepository.save(book);
        return modelMapper.map(savedBook, BookResponse.class);
    }

    @Override
    public Page<BookResponse> getAll() {
        List<Book> books = bookRepository.findAll();
        List<BookResponse> bookResponse = books.stream()
                .map(book -> modelMapper.map(book, BookResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<>(bookResponse);
    }


    @Override
    public BookResponse get(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado con ID: " + id));
        return modelMapper.map(book, BookResponse.class);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookResponse update(BookRequest request, Long id) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado con ID: " + id));
        modelMapper.map(request, existingBook);
        Book updatedBook = bookRepository.save(existingBook);
        return modelMapper.map(updatedBook, BookResponse.class);
    }
}
