package com.springboot.ranga.controller;

import com.springboot.ranga.config.CurrencyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyConfiguration configuration;

    /***
     *
     * This is an example of how configuration properties are configured automatically with SB from properties file to where needed.
     * And how profile helps in differentiating the different environments - just use hype( - ) and profile name with the property file name.
     *
     *
     * @return
     */
    @GetMapping("/currency-configuration")
    public CurrencyConfiguration fetchAllCourse() {
        return configuration;
    }
}
