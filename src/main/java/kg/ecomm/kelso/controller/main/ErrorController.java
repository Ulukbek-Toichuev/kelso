package kg.ecomm.kelso.controller.main;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ErrorController {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @GetMapping("/error/403")
    public String error403(){
        return "redirect:/";
    }

}
