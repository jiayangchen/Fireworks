package me.chenjiayang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * create by chenjiayang on 2018/3/23
 */

@Controller
public class BlogController {

    @RequestMapping(value = "/blog",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView blog(){
        return new ModelAndView("blog");
    }
}
