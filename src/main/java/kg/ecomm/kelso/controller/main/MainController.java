package kg.ecomm.kelso.controller.main;

import kg.ecomm.kelso.entity.user.SecurityUser;
import kg.ecomm.kelso.entity.user.User;
import kg.ecomm.kelso.service.book.BookService;
import kg.ecomm.kelso.service.user.JpaUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Date;

@Controller
public class MainController {
    Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private JpaUserDetailsService  jpaUserDetailsService;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String getMainPage(Model model, Principal principal){

        if (principal != null){
            SecurityUser user = (SecurityUser) ((Authentication) principal).getPrincipal();
            String role = user.getRole();
            model.addAttribute("role", role);

        }

        model.addAttribute("authors", bookService.getAllAuthors());
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("categories", bookService.getAllCategories());
        model.addAttribute("booksCategory", bookService.getAllBooksCategories());
        model.addAttribute("photos", bookService.getAllPhotos());

        return "main/index";
    }

















    @GetMapping("/login")
    public String showLoginForm() {
        logger.info("CALLED METHOD showLoginForm()");
        return "main/login";
    }

    /*@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String getAdminPage(){return "admin";}*/

    @GetMapping("/register")
    public String getRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "main/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user,Model model){
        user.setUsersPassword(BCrypt.hashpw(user.getUsersPassword(), BCrypt.gensalt()));
        user.setUserRegisteredDate(new Date());
        jpaUserDetailsService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
