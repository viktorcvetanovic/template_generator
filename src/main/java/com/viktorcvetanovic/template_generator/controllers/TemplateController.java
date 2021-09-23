package com.viktorcvetanovic.template_generator.controllers;

import annotations.Controller;
import annotations.RequestHandler;
import annotations.RequireJson;
import annotations.RequirePath;
import com.viktorcvetanovic.template_generator.data.PortfolioData;
import enums.http.HttpMethod;
import wrappers.TemplateResponse;

@Controller(path = "/template")
public class TemplateController {
    TemplateResponse templateResponse = new TemplateResponse();

    @RequestHandler(path = "/portfolio-1", method = HttpMethod.GET)
    public String getPortfolio1(@RequirePath(name = "name") String name) {
        templateResponse.setData("name", name);
        return templateResponse.ok("soon.html");
    }

    @RequestHandler(path = "/portfolio-2", method = HttpMethod.GET)
    public String getPortfolio2(@RequirePath(name = "name") String name) {
        templateResponse.setData("proba", name);
        return templateResponse.ok("proba.html");
    }

    @RequestHandler(path = "/portfolio-3", method = HttpMethod.POST)
    public String getPortfolio3(@RequireJson PortfolioData portfolioData) {
        System.out.println(portfolioData);
        templateResponse.setData("proba", portfolioData.getFirstName() + portfolioData.getLastName());
        return templateResponse.ok("proba.html");
    }


    @RequestHandler(path = "/home", method = HttpMethod.GET)
    public String getHomePage() {
        return templateResponse.ok("home.html");
    }
}
