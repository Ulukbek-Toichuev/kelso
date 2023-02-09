package kg.ecomm.kelso.entity.book;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author implements TestInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private long id;

    @Column(name = "author_name", unique = true, nullable = false)
    private String authorName;

    @Column(name = "about_author", nullable = false)
    private String aboutAuthor;

    public Author(){}

    public Author(String author_name, String about_author){
        this.authorName = author_name;
        this.aboutAuthor = about_author;
    }

    public long getId() {
        return id;
    }
    public String getAuthor_name() {return authorName;}
    public String getAbout_author() {
        return aboutAuthor;
    }

    public void setId(long id) {this.id = id;}
    public void setAuthor_name(String author_name) {
        this.authorName = author_name;
    }
    public void setAbout_author(String about_author) {
        this.aboutAuthor = about_author;
    }

    @Override
    public String toString() {
        return id + " " + authorName + " " + aboutAuthor;
    }
}
