package kg.ecomm.kelso.entity.book;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long book_id;

    @Column(name = "book_code", unique = true, nullable = false)
    private String book_code;

    @Column(name = "book_title", nullable = false)
    private String book_title;

    @ManyToOne
    @JoinColumn(name = "book_author", nullable = false)
    private Author book_author;

    @Column(name = "book_publisher", nullable = false)
    private String book_publisher;

    @Column(name = "book_description", nullable = false)
    private String book_description;

    public Book(){}

    public Book(String book_code, String book_title,
                Author book_author, String book_publisher, String book_description){
        this.book_code = book_code;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_publisher = book_publisher;
        this.book_description = book_description;
    }

    public long getBook_id() {
        return book_id;
    }
    public String getBook_code() {
        return book_code;
    }
    public String getBook_title() {
        return book_title;
    }
    public Author getBook_author() {
        return book_author;
    }
    public String getBook_publisher() {
        return book_publisher;
    }
    public String getBook_description() {
        return book_description;
    }

    public void setBook_id(long book_id) {this.book_id = book_id;}
    public void setBook_code(String book_code) {
        this.book_code = book_code;
    }
    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }
    public void setBook_author(Author book_author) {
        this.book_author = book_author;
    }
    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }
    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    @Override
    public String toString() {
        return book_id +" "+book_code + " " + book_author + " " + book_publisher + " " + book_title + " " + book_description;
    }
}
