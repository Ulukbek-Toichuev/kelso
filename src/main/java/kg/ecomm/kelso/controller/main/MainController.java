package kg.ecomm.kelso.controller.main;

import kg.ecomm.kelso.entity.user.SecurityUser;
import kg.ecomm.kelso.entity.user.User;
import kg.ecomm.kelso.service.book.BookService;
import kg.ecomm.kelso.service.user.JpaUserDetailsService;
import lombok.AllArgsConstructor;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Date;

@Controller
@AllArgsConstructor
public class MainController {
    private final JpaUserDetailsService  jpaUserDetailsService;

    private final BookService bookService;

    @GetMapping("/")
    public ModelAndView getMainPage(Model model, Principal principal){
        ModelAndView modelAndView = new ModelAndView();
        if (principal != null){
            SecurityUser user = (SecurityUser) ((Authentication) principal).getPrincipal();
            String role = user.getRole();

            modelAndView.addObject("role", role);
            modelAndView.setViewName("header");

        }

        modelAndView.addObject("authors", bookService.getAllAuthors());
        modelAndView.addObject("books", bookService.getAllBooks());
        modelAndView.addObject("categories", bookService.getAllCategories());
        modelAndView.addObject("booksCategory", bookService.getAllBooksCategories());
        modelAndView.addObject("photos", bookService.getAllPhotos());
        modelAndView.setViewName("main/index");

        return modelAndView;
    }

    @GetMapping("/login")
    public String showLoginForm() {
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
