package guru.springframework.spring5webapp.repository;

import guru.springframework.spring5webapp.domin.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
