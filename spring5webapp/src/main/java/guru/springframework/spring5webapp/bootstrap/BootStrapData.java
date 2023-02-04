package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domin.Author;
import guru.springframework.spring5webapp.domin.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book book1 = new Book("Dare", "raga7");
        Book book2 = new Book("To", "Hsys");

        Author author1 = new Author("Martin", "Joseph");
        Author author2 = new Author("Henry", "Joseph");

        book1.getAuthors().add(author1);
        author1.getBooks().add(book1);

        bookRepository.save(book1);
        authorRepository.save(author1);

        book2.getAuthors().add(author2);
        author2.getBooks().add(book2);


        bookRepository.save(book2);
        authorRepository.save(author2);

        System.out.println("Bookstrap data added");
        System.out.println("Record count "+ bookRepository.count());

    }
}
