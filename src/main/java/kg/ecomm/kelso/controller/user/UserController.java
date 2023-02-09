package kg.ecomm.kelso.controller.user;


import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String getUserPage(){return "user_space/index";}

    /*@PreAuthorize("hasRole('USER')")
    @GetMapping("/user/{id}")
    public String getBookById(@Param("id") long id){
        return "main/book";
    }*/
}
