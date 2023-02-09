package kg.ecomm.kelso.controller.main;


import kg.ecomm.kelso.entity.book.Book;
import kg.ecomm.kelso.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable("id") long id, Model model){

        Book book = bookService.getBookById(id);


        model.addAttribute("book", book);



        return "main/book";
    }
}
