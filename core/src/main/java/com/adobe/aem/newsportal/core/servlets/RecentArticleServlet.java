package com.adobe.aem.newsportal.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
// import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
// import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component(service = Servlet.class)
@SlingServletPaths("/newsportal/recent-article")


public class RecentArticleServlet extends SlingAllMethodsServlet {
    @Override
    protected void doGet( SlingHttpServletRequest request,  SlingHttpServletResponse response) throws ServletException, IOException {

        ResourceResolver resolver = request.getResourceResolver();
        Resource recentArticles = resolver.getResource("/content/newsportal/recent-article");

        ValueMap props =recentArticles.getValueMap();
        String resourceType = props.get("sling:resourceType",String.class);
        String type = props.get("type",String.class);
        String limit = props.get("limit",String.class);

        JsonObjectBuilder nodeProps = Json.createObjectBuilder();
        nodeProps.add("resourceType",resourceType);
        nodeProps.add("type",type);
        nodeProps.add("limit",limit);

      response.getWriter().write(nodeProps.build().toString());

    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        ResourceResolver resolver = request.getResourceResolver();
        Resource user = resolver.getResource("/content/newsportal/user");

        String userId = request.getParameter("userId");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        if(user!=null){
            Map<String,Object> userProps  = new HashMap<>();
            userProps.put("userId",userId);
            userProps.put("email",email);
            userProps.put("firstName",firstName);
            userProps.put("lastName",lastName);
            userProps.put("password",password);
            resolver.create(user,userId,userProps);
            resolver.commit();
        }




        response.getWriter().write("message from  doPost method ");
    }
}



