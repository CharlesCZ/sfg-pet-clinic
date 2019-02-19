package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


    @RequestMapping({"", "/", "index.html", "index"})
    public String index() {

        return "index";
    }

    @RequestMapping("/oups")
    public String oupsHandler(){


        return "notImplemented";
    }


}
