package kg.ecomm.kelso.entity.book;

import kg.ecomm.kelso.entity.book.Book;

import javax.persistence.*;

@Entity
@Table(name = "photos")
public class Photo implements TestInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long photo_id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book bookId;

    @Column(name = "photo_url", nullable = false)
    private String photoUrl;

    public Photo(){
    }

    public Photo(long photo_id, Book bookId, String photoUrl) {
        this.photo_id = photo_id;
        this.bookId = bookId;
        this.photoUrl = photoUrl;
    }

    public long getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(long photo_id) {
        this.photo_id = photo_id;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}