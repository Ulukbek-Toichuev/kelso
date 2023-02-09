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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BookService<TestInterface> bookService;
    @Autowired
    private JpaUserDetailsService jpaUserDetailsService;

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public String getMainAdminPage(Model model){

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
        return "redirect:/";
    }

    @PostMapping("/save-book")
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        return "redirect:/";
    }

    @PostMapping("/save-category")
    public String saveCategory(@ModelAttribute("category") Category category){
        logger.info(category.toString());
        bookService.save(category);
        return "redirect:/";
    }

    @PostMapping("/save-book-category")
    public String saveBooksCategory(@ModelAttribute("booksCategory") BooksCategory booksCategory){
        bookService.save(booksCategory);
        return "redirect:/";
    }

    @PostMapping("/save-metadata")
    public String saveMetadata(@ModelAttribute("metadata") Metadata metadata){
        logger.info(metadata.toString());
        bookService.save(metadata);
        return "redirect:/";
    }

    @PostMapping("/save-photo")
    public String savePhoto(@ModelAttribute("photo") Photo photo){
        bookService.save(photo);
        return "redirect:/";
    }

}
