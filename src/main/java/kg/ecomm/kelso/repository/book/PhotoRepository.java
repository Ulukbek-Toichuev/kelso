package kg.ecomm.kelso.repository.book;

import kg.ecomm.kelso.entity.book.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}