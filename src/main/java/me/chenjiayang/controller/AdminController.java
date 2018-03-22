package me.chenjiayang.controller;

import com.alibaba.fastjson.JSONObject;
import me.chenjiayang.entity.Activity;
import me.chenjiayang.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * create by chenjiayang on 2018/3/22
 */

@Controller
public class AdminController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView admin(){
        return new ModelAndView("admin");
    }

    @RequestMapping(value = "/addActivity", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JSONObject addActivity (@RequestBody Activity activity) {
        JSONObject result = new JSONObject();
        try{
            activityService.addActivity(activity);
            result.put("status",200);
        } catch (Exception e) {
            result.put("status", 500);
            result.put("message", e.getMessage());
        }
        return result;
    }
}
