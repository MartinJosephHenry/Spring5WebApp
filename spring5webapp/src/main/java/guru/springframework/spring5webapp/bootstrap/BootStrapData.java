package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domin.Author;
import guru.springframework.spring5webapp.domin.Book;
import guru.springframework.spring5webapp.domin.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book book1 = new Book("Dare", "raga7");
        Book book2 = new Book("To", "Hsys");

        Author author1 = new Author("Martin", "Joseph");
        Author author2 = new Author("Henry", "Joseph");

        Publisher publisher1 = new Publisher("DC", "Kochi", "EKM","Kerala", "670511");

        book1.getAuthors().add(author1);
        author1.getBooks().add(book1);
        publisher1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);



        book2.getAuthors().add(author2);
        author2.getBooks().add(book2);
        publisher1.getBooks().add(book2);


        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher1);


        System.out.println("Bookstrap data added");
        System.out.println("Record count "+ bookRepository.count());
        System.out.println("Record count "+ publisherRepository.count());

    }
}
