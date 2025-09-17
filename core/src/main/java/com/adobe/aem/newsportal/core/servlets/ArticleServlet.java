package com.adobe.aem.newsportal.core.servlets;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
//@SlingServletPaths("/bin/newsportal/article")
@SlingServletResourceTypes(

        resourceTypes = "/content/newsportal/articles"
//        extensions = {"json"},
//        selectors = {"recent"},
//        methods = {"GET"}

)
public class ArticleServlet extends SlingAllMethodsServlet {
    @Override
    protected void doGet( SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("message from doGet method..");
    }

    @Override
    protected void doPost(  SlingHttpServletRequest request,  SlingHttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("message from doPost method..");
    }
}
