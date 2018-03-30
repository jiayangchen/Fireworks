package me.chenjiayang.controller;

import com.alibaba.fastjson.JSONObject;
import me.chenjiayang.dao.ConfigurationDao;
import me.chenjiayang.entity.Activity;
import me.chenjiayang.entity.Blog;
import me.chenjiayang.entity.Configuration;
import me.chenjiayang.service.ActivityService;
import me.chenjiayang.service.BlogService;
import me.chenjiayang.utils.Constant;
import me.chenjiayang.utils.FileUtils;
import me.chenjiayang.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * create by chenjiayang on 2018/3/22
 */

@Controller
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ConfigurationDao configurationDao;

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView admin (){
        return new ModelAndView("admin");
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView login (){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/getConfiguration", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Configuration getConfiguration() {
        return configurationDao.getConfiguration();
    }

    @RequestMapping(value = "/updateConfig", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Boolean updateConfig(@RequestBody Configuration config) {
        try {
            configurationDao.update(config);
            return true;
        } catch (Exception e) {
            logger.error("updateConfig",e);
            return false;
        }
    }

    @RequestMapping(value = "/addActivity", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JSONObject addActivity (@RequestBody Activity activity) {
        JSONObject result = new JSONObject();
        try {
            if(!StringUtils.isEmpty(activity.getContent())) {
                activityService.addActivity(activity);
                result.put("status", Constant.SUCCESS.getStatusCode());
            } else {
                result.put("status", Constant.SERVER_ERROR.getStatusCode());
                result.put("message", "empty content");
            }
        } catch (Exception e) {
            result.put("status", Constant.SERVER_ERROR.getStatusCode());
            result.put("message", e.getMessage());
            logger.error("addActivity", Constant.SERVER_ERROR.getName() + " " + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value="/addBlog", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addBlog(@RequestBody Blog blog) {
        JSONObject result = new JSONObject();
        try {
            Blog isBlogExist = blogService.findBlogByName(blog.getBlogName());
            if(isBlogExist == null) {
                blogService.addBlog(blog);
            } else {
                blogService.updateBlog(blog);
            }
            result.put("status", Constant.SUCCESS.getStatusCode());
        } catch (Exception e) {
            logger.error("addBlog", e);
            result.put("status", Constant.SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    @RequestMapping(value="/uploadMarkdown", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        JSONObject result = new JSONObject();
        if (!file.isEmpty()) {
            String storePath = "/Users/chenjiayang/Documents/jiayangchen/fireworks/src/main/webapp/assets/md";
            String fileName = file.getOriginalFilename();
            File filepath = new File(storePath, fileName);
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            try {
                file.transferTo(new File(storePath + File.separator + fileName));
                result.put("status", Constant.SUCCESS.getStatusCode());
            } catch (Exception e) {
                logger.error("uploadMarkdown", e.getMessage());
                result.put("status", Constant.SERVER_ERROR.getStatusCode());
                result.put("errorMsg", e.getMessage());
            }
        } else {
            result.put("status", Constant.SERVER_ERROR.getStatusCode());
            result.put("errorMsg", "empty file");
        }
        return result;
    }
}
