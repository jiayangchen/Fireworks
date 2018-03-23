package me.chenjiayang.controller;

import com.alibaba.fastjson.JSONObject;
import me.chenjiayang.utils.MyHttpHeader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by chenjiayang on 2018/3/22
 */

@Controller
public class RestfulController {

    @RequestMapping(value="/testHttp",method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JSONObject testHttp() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dad","asdfasdf");
        return jsonObject;
    }
}
