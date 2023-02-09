package kg.ecomm.kelso.entity.book;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category implements TestInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long category_id;

    @Column(name = "category_name", unique = true, nullable = false)
    private String category_name;

    public Category() {
    }

    public Category(Long category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "category_id=" + category_id +", category_name=" + category_name;
    }
}
