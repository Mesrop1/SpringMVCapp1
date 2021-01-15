package com.mes.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    //creating some methods using GET method
    // @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request){   //put some params in url,WAY 1 HttpServletRequest,
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//
//        System.out.println("Name " + name + " " + "Surname " + surname);
//        //we need return htm page
//        return "first/hello";
//    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false)String name,
                            @RequestParam(value = "surname",required = false)String surname, Model model){            //Way2 @REQUESTPARAMS

        model.addAttribute("message","hello " + name + " " + surname);
        //System.out.println("Name " + name + " " + "Surname " + surname);
        //we need return htm page
        return "first/hello";
    }

    @GetMapping("/goodby")
    public String goodbyPage(){
        //we need return html page
        return "first/goodby";
    }

    //lets make Calculyator lesson 20

    @GetMapping("/calculyator")
    public String calculyator(@RequestParam("a")int a,
                              @RequestParam("b")int b,@RequestParam("action") String action,Model model){

        double result;
        switch (action){
            case "multiplication" :
                result = a * b;
            break;
            case "division" :
                result = a / b;
            break;
            case "subtraction" :
                result = a - b;
            break;
            case "addition" :
                result = a + (double)b;
            break;
            default:
                result = 0;
            break;
        }

        //and via model send parameters to View
        model.addAttribute("result" ,result);
        return "first/calculyator";
    }
}
