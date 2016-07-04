package com.frank.java.controlleradvice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

/**
 * Created by Administrator on 2016/6/28.]
 * ControllerAdvice 会在每个处理器调用之前调用ControllerAdvice中的方法
 * 从Spring mvc 4.0 以后，添加了value,basePackages,basePackageClasses,assignaleTypes和annotations.
 * 其中，Value是basePackages的别名，表示配置基包，basePackagesClasses是basePackages类型安全替代品，它会自动
 * 扫描配置类所在包下面的所有类，如设置com.excelib.controller.GoController 后会扫描com.excelib.controller包中的
 * 所有的泪，
 * assignaleTypes和annotation分别指定具体的类和类所包含的注解
 */
@ControllerAdvice

public class TestAdvice {

    @ModelAttribute
    public void setTime(Model model)
    {
        model.addAttribute("time",new Date());
        System.out.println(new Date());
    }
}
