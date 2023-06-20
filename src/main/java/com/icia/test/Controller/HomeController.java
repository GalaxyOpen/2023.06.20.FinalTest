package com.icia.test.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private String index(){
        return "/index";
    }
}
