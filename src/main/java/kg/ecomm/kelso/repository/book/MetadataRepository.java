package kg.ecomm.kelso.repository.book;

import kg.ecomm.kelso.entity.book.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetadataRepository extends JpaRepository<Metadata, Long> {
}