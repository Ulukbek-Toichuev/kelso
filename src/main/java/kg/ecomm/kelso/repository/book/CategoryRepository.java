package kg.ecomm.kelso.repository.book;

import kg.ecomm.kelso.entity.book.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}