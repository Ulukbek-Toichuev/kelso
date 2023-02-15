package kg.ecomm.kelso.controller.main;


import kg.ecomm.kelso.entity.book.Author;
import kg.ecomm.kelso.entity.book.Book;
import kg.ecomm.kelso.entity.book.Metadata;
import kg.ecomm.kelso.entity.user.SecurityUser;
import kg.ecomm.kelso.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable("id") long id, Model model, Principal principal){

        Book book = bookService.getBookById(id);

        if (principal != null){
            SecurityUser user = (SecurityUser) ((Authentication) principal).getPrincipal();
            String role = user.getRole();

            model.addAttribute("role", role);
        }

        model.addAttribute("book", book);
        model.addAttribute("author", bookService.getAuthorById(book.getBook_author().getId()));
        model.addAttribute("booksCategory", bookService.getAllBooksCategories());
        model.addAttribute("photos", bookService.getAllPhotosByBookId(id));
        model.addAttribute("metadata", bookService.getMetadataByBookId(book.getBook_id()));

        return "main/book";
    }
}
