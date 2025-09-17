package com.adobe.aem.newsportal.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.naming.spi.Resolver;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component(service = Servlet.class)
@SlingServletPaths("/bin/newsportal/popular-article")
public class PopularArticleServlet extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        ResourceResolver Resolver = request.getResourceResolver();
        Resource popularArticles = Resolver.getResource("/content/newsportal/popular-article");

        ValueMap props = popularArticles.getValueMap();
        String resourceType = props.get("sling:resourceType", String.class);
        String type = props.get("type", String.class);
        String limit = props.get("limit", String.class);

        JsonObjectBuilder nodeProps = Json.createObjectBuilder();
        nodeProps.add("resourcetype", resourceType);
        nodeProps.add("type", type);
        nodeProps.add("limit", limit);

        response.getWriter().write(nodeProps.build().toString());
    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        ResourceResolver Resolver = request.getResourceResolver();
        Resource user = Resolver.getResource("/content/newsportal/user");

        String userId = request.getParameter("userId");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        if (user != null) {
            Map<String, Object> userProps = new HashMap<>();
            userProps.put("userId", email);
            userProps.put("email", email);
            userProps.put("firstName", firstName);
            userProps.put("lastName", lastName);
            userProps.put("password", password);
            Resolver.create(user, userId, userProps);
            Resolver.commit();
        }
        response.getWriter().write("message from doPost method");
    }

    @Override
    protected void doPut(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        ResourceResolver Resolver = request.getResourceResolver();


        String userId = request.getParameter("userId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");


        Resource userIdResource = Resolver.getResource("/content/newsportal/user/"+userId);

        if(userIdResource!=null) {
    ModifiableValueMap mprop = userIdResource.adaptTo(ModifiableValueMap.class);
    if (firstName != null) {
        mprop.put("firstName", firstName);
    }
    if (lastName != null) {
        mprop.put("lastName", lastName);
    }
    mprop.remove("password");
    Resolver.commit();
    }
   else {
    response.getWriter().write("userId doesnt exist");
    }
        response.getWriter().write("user has been successfully updated");
    }

//    @Override
//    protected void doDelete(  SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
//
//        ResourceResolver Resolver = request.getResourceResolver();
//        String userId = request.getParameter("userId");
//        Resource userIdResource = request.getResource("/content/newsportal/user"+userId);
//         Resolver.delete(userIdResource);
//         Resolver.commit();
//
//
//        response.getWriter().write("message from doDelete method");
//    }
}