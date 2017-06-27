package com.sky.aop.web.controller;

import com.sky.aop.aspectj.AspectJService;
import com.sky.aop.service.User;
import com.sky.aop.service.product.ProductService;
import com.sky.aop.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gantianxing on 2017/6/23.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AspectJService aspectJService;

    @RequestMapping(value="add")
    public String addUser(Model model) {
        model.addAttribute(new User());
        return "/user/UserForm";
    }

    @RequestMapping(value="save")
    public String saveUser(@ModelAttribute User user, BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println("Code:" + fieldError.getCode()
                    + ", field:" + fieldError.getField());
            return "/user/UserForm";
        }

        // save product here
//        userService.add(user,1);
       // productService.add(1);
        aspectJService.run();
        model.addAttribute("user", user);
        return "/user/UserInfo";
    }
}
