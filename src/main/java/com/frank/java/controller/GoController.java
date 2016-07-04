package com.frank.java.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/25.
 */
@Controller
public class GoController implements EnvironmentAware {
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
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ModelAndView getDetails()
    {
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("go.jsp");
        modelAndView.addObject("msg","I can from getDetails");
        looger.info("hehaha");
        looger.info(environment.getDefaultProfiles());
        return modelAndView;
    }
    @RequestMapping(value = "/submit", method = RequestMethod. GET)
    public String submit(RedirectAttributes attr) throws IOException {
        ((FlashMap)((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getAttribute(DispatcherServlet.OUTPUT_FLASH_MAP_ATTRIBUTE)).put("name", "张三丰");
        attr.addFlashAttribute("ordersId", "xxx");
        return "redirect:showorders";
    }

    @RequestMapping(value = "/showorders", method = RequestMethod.GET)
    public String showOrders(HttpServletRequest request, Model model) throws IOException {
        System.out.println(request.getSession().getAttribute("ordersId"));
        FlashMap flashMap =(FlashMap)((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getAttribute(DispatcherServlet.OUTPUT_FLASH_MAP_ATTRIBUTE);
        System.out.println(flashMap.toString());
        System.out.println(request.getAttribute("ordersId"));
        RequestContextUtils.getInputFlashMap(request).get("name");
        return "frankman.jsp";
    }

    private Environment environment=null;
    public void setEnvironment(Environment environment)
    {
        this.environment=environment;
    }
}
