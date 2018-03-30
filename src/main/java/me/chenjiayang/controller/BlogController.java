package me.chenjiayang.controller;

import com.alibaba.fastjson.JSONObject;
import me.chenjiayang.dto.Archive;
import me.chenjiayang.entity.Activity;
import me.chenjiayang.entity.Blog;
import me.chenjiayang.service.ActivityService;
import me.chenjiayang.service.BlogService;
import me.chenjiayang.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * create by chenjiayang on 2018/3/23
 */

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/blog/{blogFileName}",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView blog(@PathVariable("blogFileName") String blogFileName){
        Blog blog = blogService.findBlogByName(FileUtils.buildCompleteBlogName(blogFileName));
        blog.setViewCount(blog.getViewCount() + 1);
        blogService.updateBlog(blog);
        return new ModelAndView("blog");
    }

    @RequestMapping(value = "/favouriteBlog",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject favouriteBlog(@RequestBody Blog blog){
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

    @RequestMapping(value = "/listAllBlog",method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> listAllBlog() {
        return blogService.findAll();
    }

    @RequestMapping(value = "/findTotalPageNumber",method = RequestMethod.GET)
    @ResponseBody
    public Integer findTotalPageNumber(@RequestParam("capacity") int capacity) {
        int size =  blogService.findAll().size();
        if(size % capacity == 0) {
            return size / capacity;
        } else {
            return (size / capacity) + 1;
        }
    }

    @RequestMapping(value = "/listAllActivity",method = RequestMethod.GET)
    @ResponseBody
    public List<Activity> listAllActivity() {
        return activityService.findAll();
    }

    @RequestMapping(value = "/listDate",method = RequestMethod.GET)
    @ResponseBody
    public Set<Archive> listDate() {
        return blogService.findArchives();
    }

    @RequestMapping(value = "/listBlogTitle",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> listBlogTitle(@RequestParam("page") int page,
                                             @RequestParam("capacity") int capacity){
        Map<String, Object> result = new HashMap<>();
        List<Blog> blogList = blogService.listBlogTitle(page,capacity);
        result.put("blogList", blogList);
        return result;
    }

    @RequestMapping(value = "/listBlogTitleByDate",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> listBlogTitle(@RequestParam("month") String month,
                                             @RequestParam("page") int page) throws ParseException {
        Map<String, Object> result = new HashMap<>();
        result.put("blogList", blogService.listBlogTitleByDate(month, page));
        return result;
    }

    @RequestMapping(value = "/findBlogByName",method = RequestMethod.GET)
    @ResponseBody
    public Blog listBlogTitle(@RequestParam("blogName") String blogName){
        return blogService.findBlogByName(blogName);
    }
}
