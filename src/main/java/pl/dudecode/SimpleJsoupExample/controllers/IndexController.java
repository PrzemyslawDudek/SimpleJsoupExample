package pl.dudecode.SimpleJsoupExample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.dudecode.SimpleJsoupExample.services.JsoupNewsService;

import java.io.IOException;

@Controller
public class IndexController {

    private final JsoupNewsService jsoupNewsService;

    @Autowired
    public IndexController(JsoupNewsService jsoupNewsService) {
        this.jsoupNewsService = jsoupNewsService;
    }

    @GetMapping("/")
    public String index(Model model) {
        try {
            model.addAttribute("news", jsoupNewsService.getFirstNewsFromTVN24());
            model.addAttribute("onetNews", jsoupNewsService.getFirstNewsFromOnet());
            model.addAttribute("wpNews", jsoupNewsService.getFirstNewsFromWP());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
