package org.arif2.kelurahanacademy.controller.kelurahan;

import org.arif2.kelurahanacademy.model.service.kelurahan.KelurahanService;
import org.arif2.kelurahanacademy.response.kelurahan.KelurahanRes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/kelurahan")
public class KelurahanController {
    private final KelurahanService kelurahanService;

    public KelurahanController(KelurahanService kelurahanService) {
        this.kelurahanService = kelurahanService;

    }

    @GetMapping()
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("kelurahan/index");

        List<KelurahanRes> kelurahanResList = kelurahanService.get();
        mv.addObject("kelurahan", kelurahanResList);
        return mv;
    }

    @GetMapping("kelurahan/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView mv = new ModelAndView("kelurahan/kelurahan-detail");

        Optional<KelurahanRes> result = kelurahanService.getByid(id);
        if (result.isPresent()) {
            mv.addObject("kelurahan", result.get());
            return mv;
        }
        return new ModelAndView("redirect:/kelurahan");
    }

    @GetMapping("/kelurahan/detail/{kelurahanId}/dusun/{dusunId}")
    public ModelAndView dusun(@PathVariable("kelurahanId") String kelurahanId,
                              @PathVariable("dusunId") String dusunId) {
        ModelAndView mv = new ModelAndView("kelurahan/dusun-detail");

        Optional<KelurahanRes> result = kelurahanService.getByid(kelurahanId);
        if (result.isPresent()) {
            mv.addObject("kelurahan", result.get());
            mv.addObject("dusun", result.get());
            return mv;
        }
        return new ModelAndView("redirect:/kelurahan");
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("kelurahan/add");
        mv.addObject("kelurahan", new KelurahanRes());
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView save() {
        ModelAndView mv = new ModelAndView("kelurahan/add");
        mv.addObject("kelurahan", new KelurahanRes());
        return mv;
    }

}
