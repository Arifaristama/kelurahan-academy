package org.arif2.kelurahanacademy.controller.kelurahan.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class Home {
    @GetMapping()
    public ModelAndView index() {
    ModelAndView mav = new ModelAndView("dasboard/home");
    return mav;
    }
}
