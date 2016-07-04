package com.frank.java.controller;

import com.frank.java.model.Student;
import com.frank.java.service.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Administrator on 2016/6/28.
 */
@Controller
@RequestMapping(value = "/valid")
public class ValidatorController {
    @Autowired
    private StudentValidator studentValidator;
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder)
    {
        webDataBinder.addValidators(studentValidator);
    }
    @RequestMapping(value = {"/index","/",""},method = RequestMethod.GET)
    public String index(ModelMap modelMap)
    {
        modelMap.addAttribute("student",new Student());
        return "student.jsp";
    }
    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public String signup(@Validated Student student, BindingResult br, RedirectAttributes ra)
    {
        ra.addFlashAttribute("student",student);
        return "student.jsp";
    }
}
