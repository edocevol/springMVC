package com.frank.java.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Created by Administrator on 2016/6/28.
 */
@Controller
@RequestMapping(value = {"/session"})
@SessionAttributes(value = {"book","description"},types = {Double.class})
public class SessionController {
    private final Log logger = LogFactory.getLog(SessionController.class);
    @RequestMapping(value = {"/index"})
    public String index(Model model)
    {
        model.addAttribute("book","金刚经");
        model.addAttribute("description","这是一本很好的很有收藏价值的佛经");
        model.addAttribute("price",new Double("99.89"));
        return "redirect:get";
    }
    @RequestMapping(value = {"/get"})
    public String getSessionAttributes(@ModelAttribute String book, @ModelAttribute String description,
                                       ModelMap modelMap, SessionStatus sessionStatus)
    {
        logger.info("====================getSessionAttributes====================");
        logger.info("The name of current book: "+book);
        logger.info("The description of current book:" +description);
        logger.info("The details of current book:{'book':'"+modelMap.get("book")+"','decription':'"+modelMap.get("description")+"','price':"+modelMap.get("price")+"}");
        return "redirect:complete";
    }
    @RequestMapping(value = {"/complete"})
    public String afterComplete(ModelMap modelMap)
    {
        logger.info("====================afterComplete====================");
        logger.info("The details of current book:{'book':'"+modelMap.get("book")+"','decription':'"+modelMap.get("description")+"','price':"+modelMap.get("price")+"}");
        return "index";
    }
}
