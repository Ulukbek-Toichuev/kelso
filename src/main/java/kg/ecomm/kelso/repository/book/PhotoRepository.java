package kg.ecomm.kelso.repository.book;

import kg.ecomm.kelso.entity.book.Metadata;
import kg.ecomm.kelso.entity.book.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query("SELECT p FROM Photo p WHERE p.bookId.book_id=:id")
    List<Photo> findPhotosByBookId(@Param("id") long id);

}