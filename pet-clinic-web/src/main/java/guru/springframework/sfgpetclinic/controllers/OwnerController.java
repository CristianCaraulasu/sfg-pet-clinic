package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"","/","index"})
    public String listOwners(Model model){

        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){return  "notimplemented";}

    @PostConstruct
    public void constructed() {
        System.out.println("I was constructed! OwnerController");
    }
}
