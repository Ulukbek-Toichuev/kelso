package kg.ecomm.kelso.controller.admin;


import kg.ecomm.kelso.entity.book.*;
import kg.ecomm.kelso.service.book.BookService;
import kg.ecomm.kelso.service.user.JpaUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final BookService<TestInterface> bookService;
    private final JpaUserDetailsService jpaUserDetailsService;

    public AdminController(BookService<TestInterface> bookService, JpaUserDetailsService jpaUserDetailsService) {
        this.bookService = bookService;
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public String getMainAdminPage(Model model){
        logger.info(Book.class.getSimpleName());

        model.addAttribute("users", jpaUserDetailsService.getAllUsers());
        model.addAttribute("authors", bookService.getAllAuthors());
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("categories", bookService.getAllCategories());
        model.addAttribute("booksCategory", bookService.getAllBooksCategories());
        model.addAttribute("photos", bookService.getAllPhotos());

        return "admin_space/index";
    }

    @GetMapping("/add")
    public String addNewEntities(Model model){

        model.addAttribute("authors", bookService.getAllAuthors());
        model.addAttribute("categories", bookService.getAllCategories());
        model.addAttribute("books", bookService.getAllBooks());

        model.addAttribute("author", new Author());
        model.addAttribute("book", new Book());
        model.addAttribute("category", new Category());
        model.addAttribute("booksCategory", new BooksCategory());
        model.addAttribute("metadata", new Metadata());
        model.addAttribute("photo", new Photo());

        return "admin_space/entities";
    }

    @PostMapping("/save-author")
    public String saveAuthor(@ModelAttribute("author") Author author){
        bookService.save(author);
        return "redirect:/admin/add";
    }

    @PostMapping("/save-book")
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        return "redirect:/admin/add";
    }

    @PostMapping("/save-category")
    public String saveCategory(@ModelAttribute("category") Category category){
        bookService.save(category);
        return "redirect:/admin/add";
    }

    @PostMapping("/save-book-category")
    public String saveBooksCategory(@ModelAttribute("booksCategory") BooksCategory booksCategory){
        bookService.save(booksCategory);
        return "redirect:/admin/add";
    }

    @PostMapping("/save-metadata")
    public String saveMetadata(@ModelAttribute("metadata") Metadata metadata){
        logger.info(metadata.toString());
        bookService.save(metadata);
        return "redirect:/admin/add";
    }

    @PostMapping("/save-photo")
    public String savePhoto(@ModelAttribute("photo") Photo photo){
        bookService.save(photo);
        return "redirect:/admin/add";
    }

    @GetMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable("id") long id){

        bookService.deleteBook(id);

        return "redirect:/";
    }

    @GetMapping("/delete-author/{id}")
    public String deleteAuthor(@PathVariable("id") long id){

        bookService.deleteAuthor(id);

        return "redirect:/admin";
    }

    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable("id") long id){

        bookService.deleteCategory(id);

        return "redirect:/admin";
    }

    @GetMapping("/delete-book-category/{id}")
    public String deleteBooksCategory(@PathVariable("id") long id){

        bookService.deleteBooksCategory(id);

        return "redirect:/admin";
    }

    @GetMapping("/delete-metadata/{id}")
    public String deleteMetadata(@PathVariable("id") long id){

        bookService.deleteMetadata(id);

        return "redirect:/admin";
    }

    @GetMapping("/delete-photo/{id}")
    public String deletePhoto(@PathVariable("id") long id){

        bookService.deletePhoto(id);

        return "redirect:/admin";
    }

    @GetMapping("/update-book/{id}")
    public String updateBookPage(@PathVariable("id") long id, Model model){
        model.addAttribute("book", bookService.getBookById(id));
        return "admin_space/update/book";
    }

    @PostMapping("/update-book")
    public String updateBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        return "redirect:/admin";
    }

    @GetMapping("/update-metadata/{id}")
    public String updateMetadataPage(@PathVariable("id") long id, Model model){
        model.addAttribute("metadata", bookService.getMetadataById(id));
        return "admin_space/update/metadata";
    }

    @PostMapping("/update-metadata")
    public String updateMetadata(@ModelAttribute("metadata") Metadata metadata){
        bookService.save(metadata);
        return "redirect:/admin";
    }

    @GetMapping("/update-category/{id}")
    public String updateCategoryPage(@PathVariable("id") long id, Model model){
        model.addAttribute("category", bookService.getCategoryById(id));
        return "admin_space/update/category";
    }

    @PostMapping("/update-category")
    public String updateCategory(@ModelAttribute("category") Category category){
        bookService.save(category);
        return "redirect:/admin";
    }

    @GetMapping("/update-photo/{id}")
    public String updatePhotoPage(@PathVariable("id") long id, Model model){
        model.addAttribute("photo", bookService.getPhotoById(id));
        return "admin_space/update/photo";
    }

    @PostMapping("/update-photo")
    public String updatePhoto(@ModelAttribute("photo") Photo photo){
        bookService.save(photo);
        return "redirect:/admin";
    }

    @GetMapping("/update-author/{id}")
    public String updateAuthorPage(@PathVariable("id") long id, Model model){
        model.addAttribute("author", bookService.getAuthorById(id));
        return "admin_space/update/author";
    }

    @PostMapping("/update-author")
    public String updateAuthor(@ModelAttribute("author") Author author){
        bookService.save(author);
        return "redirect:/admin";
    }


}
