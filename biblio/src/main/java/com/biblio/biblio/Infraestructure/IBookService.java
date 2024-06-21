package com.biblio.biblio.Infraestructure;

import com.biblio.biblio.Api.Dto.Request.BookRequest;

import com.biblio.biblio.Api.Dto.Response.BookResponse;

public interface IBookService extends CrudService<BookRequest, BookResponse, Long> {
}
