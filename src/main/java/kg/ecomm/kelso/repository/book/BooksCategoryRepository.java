package kg.ecomm.kelso.repository.book;

import kg.ecomm.kelso.entity.book.BooksCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksCategoryRepository extends JpaRepository<BooksCategory, Long> {
}