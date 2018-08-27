package pl.marekprocek.emailsend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.marekprocek.emailsend.service.Email;

@Controller
public class EmailController {


    private Email email;

    public EmailController(Email email) {
        this.email = email;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/send")
    public String send(@RequestParam String to,
                       @RequestParam String title,
                       @RequestParam String content){
        System.out.println(to + " " + title + " " + content);
        email.send(to,title,content);
        return "send";
    }


}
