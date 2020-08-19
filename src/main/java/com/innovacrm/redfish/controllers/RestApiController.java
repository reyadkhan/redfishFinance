package com.innovacrm.redfish.controllers;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@RequestMapping("/api")
public @interface RestApiController {
    @AliasFor(annotation = RestController.class)
    String value() default "";
}
