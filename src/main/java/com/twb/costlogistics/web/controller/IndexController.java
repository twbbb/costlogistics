package com.twb.costlogistics.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by code4wt on 17/8/7.
 */
@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = {"/", "index", "index.htm", "index.html", "home"})
    public String index() {
        return "list";
    }

    @RequestMapping(value = "404")
    public String notFound() {
        return "404";
    }

}
