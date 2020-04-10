package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Converter {
    @PostMapping("/converter")
    public String converter(@RequestParam String usd, @RequestParam String rate, Model model){
        float a=Float.parseFloat(usd);
        float b=Float.parseFloat(rate);

        float vnd=a*b;
        model.addAttribute("usd",usd);
        model.addAttribute("rate",rate);
        model.addAttribute("vnd",vnd);
        return "demo";
    }


}
