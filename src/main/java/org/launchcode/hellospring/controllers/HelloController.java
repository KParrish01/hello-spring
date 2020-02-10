package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * LaunchCode Chapter 10.1.
**/
@Controller
@ResponseBody // Can be put here if used for all
@RequestMapping("hello") // now all below URL routes will begin with "/hello" (use for organization)
public class HelloController {

    // Without argument, @GetMapping maps to /hello, but only because we have the "@RequestMapping" above
    @GetMapping()
    public String helloEmptyArgument() {
        return "Hello, Spring!";
    }

    // Handle request at path /helloOriginal
    @GetMapping("helloOriginal")
    public String hello() {
        return "Hello, Spring!";
    }

    // Handle request at path /goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handle request at path /trythis
    @PostMapping("trythis")
    public String goodbyebye() {
        return "Goodbye-Bye, Spring!";
    }

    // Handle request at path /hellogoodbye
    @RequestMapping("hellogoodbye")
    public String hellogoodbye() {
        return "Hello-Goodbye Spring!";
    }

    // Create handler that handles requests of inputtype /hello?coder=LaunchCode
//    @GetMapping("hello")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")  //<<<<<That's the chosen one...
    public String helloWithQueryParam(@RequestParam String coder) {
        return "Hello, FUNNY FUNNY " + coder + "!";
    }

    // Handler that handles requests of form /hello/LaunchCode
    @GetMapping("hello/{name}/{cat}")
    public String helloWithPathParameter(@PathVariable String name, @PathVariable String cat){
        return "Hello " + name + "!";
    }

    // Handler that handles requests of form /hello/LaunchCode
//    @GetMapping(redirect:"hello/{name}")
//    @ResponseBody
    public String helloWithPathParameter(@PathVariable String name){
        return "Hello " + name + "!";
    }

    // Handler using a form ALSO used for Thymeleaf samples in HelloSpringControllerWithThymeleaf controller file!!!!!
    @GetMapping("form")  // from video, without "/" before action = 'hello' and at end of input (didn't work at first... now it does)
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form method = get action='hello'>" +  // tells it to submit request to /hello
                "<input type = 'text' name = 'coder' >" +
                "<input type='submit' value='Greet me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }


    // Handler using a form
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "formPost")   // from test with forward slashes "/" before action = '/hello' and at end of input lines
    public String helloFormPost() {
        return "<html>" +
                 "<body>" +
                    "<form action='/hello/hello' method = 'post' >" +  // tells it to submit request to /hello
                      "<input type = 'text' name = 'coder' />" +
                      "<input type='submit' value='Greet me!' />" +
                    "</form>" +
                  "</body>" +
                "</html>";

    }

    // Exercise 10.5.
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "formPost")   // from test with forward slashes "/" before action = '/hello' and at end of input lines
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "bonjour")  //<<<<<That's also the chosen one, for the exercise...
    public String bonjourWithLanguageChoiceAndParameters(@RequestParam String language, @RequestParam String coder) {

        if (language.equals("German")){
            return "Gruess dich " + language + " " + coder + "!";
        }
        if (language.equals("French")){
            return "Bonjour " + language + " " + coder + "!";
        }
        if (language.equals("Czech")){
            return "Ahoj " + language + " " + coder + "!";
        }
        if (language.equals("Swiss")){
            return "Sali " + language + " " + coder + "!";
        }
        if (language.equals("Italian")) {
            return "Buongiorno " + language + " " + coder + "!";
//        } else {
//            return "Hello you, " + language + " " + coder + "!!!";
        }
        if (language.equals("English")) {
            return "Hello, " + coder + "!";
        } else {
            return "OOOUUUUUPS!!!";
        }
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "exercise")
//    @RequestMapping("exercise")
//    @GetMapping("exercise")
    @PostMapping("exercise")
    public static String createMessage() {
        return "<html" +
                "<head>" +
//                "<style>" +
//                "body {background-color: powderblue}" +
//                "select {color: fuchsia}" +
//                "/style" +
                "</head>" +
                    "<body>" +
                        "<form action='/hello/bonjour' method = 'post' >" +  // tells it to submit request to /hello
                            "<input type = 'text' name = 'coder' />" +
//                            "<input type = 'text' name = 'language' />" +
                //                "<label>Choose Language:" +
                                    "<select name = 'language'>" +
                                            "<option value='English'>English</option>" +
                                            "<option value='French'>French</option>" +
                                            "<option value='Czech'>Czech</option>" +
                                            "<option>German</option>" +
                                            "<option value='Italian'>Italian</option>" +
                                            "<option value='Swiss'>Swiss</option>" +
                                    "<select>" +
                //                "<label />" +
                            "<input type='submit' value='Greet me!' />" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

}
