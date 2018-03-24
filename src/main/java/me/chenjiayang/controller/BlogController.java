package me.chenjiayang.controller;

import com.alibaba.fastjson.JSONObject;
import me.chenjiayang.entity.Blog;
import me.chenjiayang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

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
        Blog blog = blogService.findBlogByName(buildCompleteBlogName(blogFileName));
        blog.setViewCount(blog.getViewCount() + 1);
        blogService.updateBlog(blog);
        return new ModelAndView("blog");
    }

    private String buildCompleteBlogName(String blogName) {
        return blogName + ".md";
    }

    @RequestMapping(value = "/favouriteBlog",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject listBlogTitle(@RequestBody Blog blog){
        JSONObject result = new JSONObject();
        try {
            blog.setFavouriteCount(blog.getFavouriteCount() + 1);
            blogService.updateBlog(blog);
            result.put("status", 200);
        } catch(Exception e) {
            result.put("status", 500);
        }
        return result;
    }

    @RequestMapping(value = "/listBlogTitle",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> listBlogTitle(@RequestParam("page") int page){
        Map<String, Object> result = new HashMap<>();
        List<Blog> blogList = blogService.listBlogTitle(page);
        Set<String> dateList = new TreeSet<>();
        for(Blog blog : blogList) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            dateList.add(sdf.format(new Date(blog.getCreateTime().getTime())));
        }
        result.put("blogList", blogList);
        result.put("dateList", dateList);
        return result;
    }

    @RequestMapping(value = "/findBlogByName",method = RequestMethod.GET)
    @ResponseBody
    public Blog listBlogTitle(@RequestParam("blogName") String blogName){
        return blogService.findBlogByName(blogName);
    }
}
