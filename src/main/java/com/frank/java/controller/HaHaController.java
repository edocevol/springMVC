package com.frank.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/6/28.
 */
@Controller
@RequestMapping(value = "/haha")
public class HaHaController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody public String index(HttpServletRequest request, Model model)
    {
        model.addAttribute("msg","gogogoo");
        return "go.jsp";
    }
}
