package kg.ecomm.kelso.repository.book;

import kg.ecomm.kelso.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b.book_code FROM Book b")
    List<String> findAllCode();

}
