package com.frank.java.service;

import com.frank.java.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Administrator on 2016/6/28.
 */
@Component
public class StudentValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return Student.class.equals(clazz);
        //return false;
    }

    public void validate(Object target, Errors errors) {
        Student student= (Student) target;
        if(student.getName().length()<8)
        {
            errors.rejectValue("name","valid.nameLen",new Object[]{"minLength",8},"用户名不能少于{1}位");
        }
    }
}
