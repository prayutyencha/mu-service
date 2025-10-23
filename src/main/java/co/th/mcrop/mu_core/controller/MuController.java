package co.th.mcrop.mu_core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/mu")
public class MuController {

    @GetMapping("/v1/number")
    public String getMu(@PathVariable Integer number){
        return number.toString()+"TEST";
    }
    
}
