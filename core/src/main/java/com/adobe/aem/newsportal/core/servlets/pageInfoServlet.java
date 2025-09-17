package com.adobe.aem.newsportal.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Iterator;

@Component(service = Servlet.class )
@SlingServletPaths("/bin/newsportal/page-info")
public class pageInfoServlet  extends SlingAllMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        ResourceResolver resolver = request.getResourceResolver();
        PageManager pageManager = resolver.adaptTo(PageManager.class);
        Page articlePage = pageManager.getPage("/content/newsportal/us/en/articles0");

        if (articlePage != null) {
            Iterator<Page> childPage = articlePage.listChildren();
            while (childPage.hasNext()) {
                Page childPages = childPage.next();
                String pageTitle = childPages.getTitle();
                String pagePath = childPages.getPath();

                JsonObjectBuilder nodeProps = Json.createObjectBuilder();
                nodeProps.add("Title",pageTitle);
                nodeProps.add("Path",pagePath);
                response.getWriter().write(nodeProps.build().toString());

            }
        }
    }
}
