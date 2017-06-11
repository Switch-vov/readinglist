package com.switchvov.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Switch on 2017/6/11.
 */
@Controller()
public class SystemController {

    @RequestMapping("login")
    public String login() {
        return "login";
    }

}
