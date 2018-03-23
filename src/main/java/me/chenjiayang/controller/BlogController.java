package me.chenjiayang.controller;

import me.chenjiayang.entity.Blog;
import me.chenjiayang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by chenjiayang on 2018/3/23
 */

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/blog/{blogFileName}",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView blog(@PathVariable("blogFileName") String blogFileName){
        return new ModelAndView("blog");
    }

    @RequestMapping(value = "/listBlogTitle",method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> listBlogTitle(@RequestParam("page") int page){
        return blogService.listBlogTitle(page);
    }
}
