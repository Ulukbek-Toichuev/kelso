package kg.ecomm.kelso.entity.book;

import javax.persistence.*;

@Entity
@Table(name = "books_Category")
public class BooksCategory implements TestInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "books_category_id")
    private long books_category_id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book bookId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category categoryId;

    public BooksCategory() {
    }

    public BooksCategory(Long books_category_id, Book bookId, Category categoryId) {
        this.books_category_id = books_category_id;
        this.bookId = bookId;
        this.categoryId = categoryId;
    }

    public long getBooks_category_id() {
        return books_category_id;
    }

    public void setBooks_category_id(long books_category_id) {
        this.books_category_id = books_category_id;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }
}
