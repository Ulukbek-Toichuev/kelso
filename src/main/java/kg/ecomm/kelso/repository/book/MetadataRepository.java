package kg.ecomm.kelso.repository.book;

import kg.ecomm.kelso.entity.book.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MetadataRepository extends JpaRepository<Metadata, Long> {
    @Query("SELECT m FROM Metadata m WHERE m.bookId.book_id=:id")
    Metadata findMetadataByBookId(@Param("id") long id);
}