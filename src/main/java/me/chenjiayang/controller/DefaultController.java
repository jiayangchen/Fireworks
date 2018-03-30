package me.chenjiayang.controller;

import me.chenjiayang.entity.Activity;
import me.chenjiayang.service.ActivityService;
import me.chenjiayang.service.BlogService;
import me.chenjiayang.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * create by chenjiayang on 2018/3/20
 */

@Controller
public class DefaultController {

    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @Autowired
    private ActivityService activityService;
    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/aboutme",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView aboutme(){
        return new ModelAndView("aboutme");
    }

//    @RequestMapping(value = "/filterTitle",method = RequestMethod.GET)
//    @ResponseBody
//    public void filterTitle(){
//        try {
//            List<Blog> blogList = blogService.findAll();
//            List<String> titleList = new ArrayList<>();
//            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/Users/chenjiayang/Documents/jiayangchen/fireworks/src/main/webapp/assets/title.txt")), "UTF-8"));
//            String lineTxt = null;
//            while ((lineTxt = br.readLine()) != null) {
//                titleList.add(lineTxt);
//            }
//            for(int i=0; i<blogList.size(); i++) {
//                Blog blog = blogList.get(i);
//                blog.setBlogContent(titleList.get(i));
//                blogService.updateBlog(blog);
//            }
//            br.close();
//        } catch(Exception e) {
//            logger.error("filterTitle", e);
//        }
//    }

    @RequestMapping(value = "/getActivitiesByPage",method = RequestMethod.GET)
    @ResponseBody
    public List<Activity> getActivitiesByPage(@RequestParam("page") int page,
                                              @RequestParam("capacity") int capacity){
        List<Activity> result = new ArrayList<>();
        try {
            result = activityService.findActivitiesByPage(page, capacity);
        } catch (Exception e) {
            logger.error("getActivitiesByPage", Constant.SERVER_ERROR.getName() + " " + e.getMessage());
        }
        return result;
    }
}
