package me.chenjiayang.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * create by chenjiayang on 2018/3/20
 */

@Controller
public class DefaultController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index(){
        return new ModelAndView("index");
    }

}
