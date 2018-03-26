package me.chenjiayang.controller;

import com.alibaba.fastjson.JSONObject;
import me.chenjiayang.dto.Gallery;
import me.chenjiayang.entity.Photograph;
import me.chenjiayang.service.GalleryService;
import me.chenjiayang.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * create by chenjiayang on 2018/3/26
 */

@Controller
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @RequestMapping(value = "/gallery",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index(){
        return new ModelAndView("gallery");
    }

    @RequestMapping(value = "/addPhotograph",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addPhotograph(@RequestBody Photograph photograph){
        JSONObject result = new JSONObject();
        try {
            galleryService.addPhotograph(photograph);
            result.put("status", Constant.SUCCESS.getStatusCode());
        } catch (Exception e) {
            result.put("status", Constant.SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    @RequestMapping(value = "/getGallery",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getGallery(){
        JSONObject result = new JSONObject();
        Gallery gallery = new Gallery();
        try {
            gallery = galleryService.findGallery();
            result.put("status", Constant.SUCCESS.getStatusCode());
        } catch (Exception e) {
            result.put("status", Constant.SERVER_ERROR.getStatusCode());
        }
        result.put("gallery", gallery);
        return result;
    }
}
