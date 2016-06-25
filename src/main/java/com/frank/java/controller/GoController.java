package com.frank.java.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/6/25.
 */
@Controller
public class GoController {
    private final Log looger = LogFactory.getLog(GoController.class);
    @RequestMapping(value = "/",method = RequestMethod.HEAD)
    public String head()
    {
        return "go.jsp";
    }

    @RequestMapping(value = {"/index","/"},method = {RequestMethod.GET})
    public String index(Model model)
    {
        looger.info("======================processed by index=======================");
        //返回msg参数
        model.addAttribute("msg","gogo");
        return "go.jsp";
    }
}
