package kg.ecomm.kelso.repository.book;

import kg.ecomm.kelso.entity.book.BooksCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BooksCategoryRepository extends JpaRepository<BooksCategory, Long> {
}