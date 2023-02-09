package kg.ecomm.kelso.entity.book;

import kg.ecomm.kelso.entity.book.Book;

import javax.persistence.*;

@Entity
@Table(name = "metadatas")
public class Metadata implements TestInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "metadata_id")
    private long metadataId;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book bookId;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "availability_count", nullable = false)
    private int availabilityCount;

    @Column(name = "page_count", nullable = false)
    private int pageCount;

    @Column(name = "reading_age", nullable = false)
    private int readingAge;

    public Metadata(){}

    public Metadata(long metadataId, Book bookId, String isbn, int price, int availabilityCount, int pageCount, int readingAge) {
        this.metadataId = metadataId;
        this.bookId = bookId;
        this.isbn = isbn;
        this.price = price;
        this.availabilityCount = availabilityCount;
        this.pageCount = pageCount;
        this.readingAge = readingAge;
    }

    public long getMetadataId() {
        return metadataId;
    }

    public void setMetadataId(long metadataId) {
        this.metadataId = metadataId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailabilityCount() {
        return availabilityCount;
    }

    public void setAvailabilityCount(int availabilityCount) {
        this.availabilityCount = availabilityCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getReadingAge() {
        return readingAge;
    }

    public void setReadingAge(int readingAge) {
        this.readingAge = readingAge;
    }

    @Override
    public String toString() {
        return "metadataId=" + metadataId + ", bookId=" +bookId.getBook_id() +", isbn='" + isbn +", price=" + price +", availabilityCount=" + availabilityCount + ", pageCount=" + pageCount +", readingAge=" + readingAge;
    }
}
