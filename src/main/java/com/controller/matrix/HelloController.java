package com.controller.matrix;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
public class HelloController {

    // http://localhost:8088/mvc01/hello/
    @RequestMapping("/")
    public String helloWorld() {
        return "Hello, World!";
    }

    // http://localhost:8088/mvc01/hello/custom/42;name=Rom4ik;key=it%20is%20key/guest
    @GetMapping("/custom/{userId}/guest")
    public String helloName(
            @PathVariable int userId,
            @MatrixVariable(pathVar = "userId") String name,
            @MatrixVariable(pathVar = "userId", defaultValue = "") String key
    ) {
        return "userId : " + userId + " . " +
                "name : " + name + " . " + "<br>" +
                "key : " + key + " . " + "<br>";
    }

}
