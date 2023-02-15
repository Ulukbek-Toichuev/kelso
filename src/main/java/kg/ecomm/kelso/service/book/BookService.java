package kg.ecomm.kelso.service.book;

import kg.ecomm.kelso.controller.admin.AdminController;
import kg.ecomm.kelso.entity.book.*;
import kg.ecomm.kelso.repository.book.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService <T>{
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final MetadataRepository metadataRepository;
    private final BooksCategoryRepository booksCategoryRepository;
    private final PhotoRepository photoRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository
            , CategoryRepository categoryRepository, MetadataRepository metadataRepository
            , BooksCategoryRepository booksCategoryRepository, PhotoRepository photoRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.metadataRepository = metadataRepository;
        this.booksCategoryRepository = booksCategoryRepository;
        this.photoRepository = photoRepository;
    }

    public List<Book> getAllBooks(){return bookRepository.findAll();}
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public List<BooksCategory> getAllBooksCategories(){
        return booksCategoryRepository.findAll();
    }
    public List<Metadata> getAllMetadatas(){
        return metadataRepository.findAll();
    }
    public List<Photo> getAllPhotos(){
        return photoRepository.findAll();
    }

    public List<Photo> getAllPhotosByBookId(long id){return photoRepository.findPhotosByBookId(id);}

    public void save(T value){
        String className = value.getClass().getSimpleName();

        switch (className){
            case "Author":
                authorRepository.save((Author) value);
                break;
            case "Book":
                Book book = (Book) value;
                book.setBook_code(new BookMiddleware(bookRepository).getNewBookCode());
                bookRepository.save(book);
                break;
            case "Category":
                categoryRepository.save((Category) value);
                break;
            case "BooksCategory":
                booksCategoryRepository.save((BooksCategory) value);
                break;
            case "Metadata":
                metadataRepository.save((Metadata) value);
                break;
            case "Photo":
                photoRepository.save((Photo) value);
            default:
                break;
        }
    }

    public Author getAuthorById(long id){
        Optional<Author> authorOptional = authorRepository.findById(id);
        Author author = null;
        if (authorOptional.isPresent())
            author = authorOptional.get();
        else
            throw new RuntimeException(
                    "Book not found for id: " + id);
        return author;
    }

    public Book getBookById(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book book = null;
        if (bookOptional.isPresent())
            book = bookOptional.get();
        else
            throw new RuntimeException(
                    "Book not found for id: " + id);
        return book;
    }

    public Category getCategoryById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        Category category = null;

        if (categoryOptional.isPresent())
            category = categoryOptional.get();
        else
            throw new RuntimeException(
                    "Category not found for id: " + id);
        return category;
    }

    public BooksCategory getBooksCategoryById(Long id) {
        Optional<BooksCategory> bookCategoryOptional = booksCategoryRepository.findById(id);
        BooksCategory bookCategory = null;

        if (bookCategoryOptional.isPresent())
            bookCategory = bookCategoryOptional.get();
        else
            throw new RuntimeException(
                    "BooksCategory not found for id: " + id);
        return bookCategory;
    }

    public Metadata getMetadataById(Long id) {
        Optional<Metadata> metadataOptional = metadataRepository.findById(id);
        Metadata metadata = null;

        if (metadataOptional.isPresent())
            metadata = metadataOptional.get();
        else
            throw new RuntimeException(
                    "Category not found for id: " + id);
        return metadata;
    }

    public Photo getPhotoById(Long id) {
        Optional<Photo> metadataOptional = photoRepository.findById(id);
        Photo photo = null;

        if (metadataOptional.isPresent())
            photo = metadataOptional.get();
        else
            throw new RuntimeException(
                    "Category not found for id: " + id);
        return photo;
    }

    public Metadata getMetadataByBookId(long id){
        return metadataRepository.findMetadataByBookId(id);
    }


    public void deleteBook(long id){
        bookRepository.deleteById(id);
    }

    public void deleteAuthor(long id){
        authorRepository.deleteById(id);
    }

    public void deleteCategory(long id){
        categoryRepository.deleteById(id);
    }

    public void deleteBooksCategory(long id){
        booksCategoryRepository.deleteById(id);
    }

    public void deleteMetadata(long id){
        metadataRepository.deleteById(id);
    }

    public void deletePhoto(long id){
        photoRepository.deleteById(id);
    }

}
