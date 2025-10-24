package co.th.mcrop.mucore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/mu")
public class MuController {

    @GetMapping("/v1/")
    public String getMu(){
        return "TEST";
    }
    
}
