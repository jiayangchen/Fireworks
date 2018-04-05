package me.chenjiayang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * create by chenjiayang on 2018/4/5
 */

@Controller
public class LifeController {
    @RequestMapping(value = "/life",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView life(){
        return new ModelAndView("life");
    }
}
