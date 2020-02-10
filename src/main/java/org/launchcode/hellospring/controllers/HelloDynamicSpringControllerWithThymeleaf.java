package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("dynamic") // now all below URL routes will begin with "/dynamic"
@Controller
public class HelloDynamicSpringControllerWithThymeleaf {

    // Responds to /dynamic/hello1
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})  //<<<<<That's the chosen one...
    public String helloDynamic(@RequestParam String coder, Model model) {  // model is class that passes data between controller and view (confusing, as not same as "M" in MVP)
        String theGreeting = "Hello, Model Class " + coder + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello1";    // Sends controller to template named "hello1"
    }

    // Responds to /dynamic/hello/LaunchCode
    @GetMapping("hello/{coder}")  // This didn't work for me here...
    public String HelloWithPathVariable(@PathVariable String coder, Model model){
        String theOtherGreeting = "Hello, GetMapping Model Class " + coder + "!!";
        model.addAttribute("greeting", theOtherGreeting);
        return "hello1";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form2";
    }


    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> theNames = new ArrayList<>();
        theNames.add("LaunchCode");
        theNames.add("Java");
        theNames.add("YOUR FAVORITE!");
        model.addAttribute("names", theNames);
        return "hello-list";
    }

}
