package com.biblio.biblio.Domain.Repository;

import com.biblio.biblio.Domain.Entity.Book;
import com.biblio.biblio.Infraestructure.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
