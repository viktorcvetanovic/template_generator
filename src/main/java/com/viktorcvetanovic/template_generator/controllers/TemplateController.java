package com.viktorcvetanovic.template_generator.controllers;

import annotations.Controller;
import annotations.RequestHandler;
import annotations.RequirePath;
import enums.http.HttpMethod;
import wrappers.TemplateResponse;

@Controller(path = "/template")
public class TemplateController {
    TemplateResponse templateResponse = new TemplateResponse();

    @RequestHandler(path = "/portfolio-1", method = HttpMethod.GET)
    public String getPortfolio1(@RequirePath(name = "name") String name) {
        return templateResponse.ok(name, "soon.html");
    }
}
