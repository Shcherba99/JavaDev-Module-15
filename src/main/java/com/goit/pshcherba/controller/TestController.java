package com.goit.pshcherba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * A controller class responsible for handling HTTP requests for the "/test" endpoint.
 * This class is annotated with {@link Controller} to indicate that it is a Spring MVC controller.
 */
@Controller
public class TestController {

    /**
     * Handles GET requests to the "/test" endpoint.
     * <p>
     * This method returns a {@link ModelAndView} object with the view name set to "test"
     * and a message added as a model attribute.
     * </p>
     *
     * @return a {@link ModelAndView} object containing the view name "test" and the message "Hello, World".
     */
    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("msg", "Hello, World");
        return modelAndView;
    }
}
