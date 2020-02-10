package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("howdy") // now all below URL routes will begin with "/howdy"
@Controller
public class HelloSpringControllerWithThymeleaf {

//    @GetMapping("hello/{coder}")  // This didn't work for me here...
//    @ResponseBody
//    public String HelloWithPathVariable(@PathVariable String coder){
//        return "Howdy, getter " + coder + "!!!";
//    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")  //<<<<<That's the chosen one...
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String coder) {
        return "Hello, human " + coder + "!";
    }

    // Same as HelloSpring "Handler using a form" but this time using Thymeleaf
//    @GetMapping("form")  // from video 11.2.3., without "/" before action = 'hello' and at end of input (didn't work at first... now it does)
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "form")
    public String helloThymeleaf() {
        return "form";
    }

    public String methodName(Model model) {

        // method code here

        String variableValue = "How's this?";
        model.addAttribute("variableName", variableValue);

        return "pathToTemplate";
    }

}
