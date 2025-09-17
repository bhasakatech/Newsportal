// package com.adobe.aem.newsportal.core.servlets;

// // import com.adobe.aem.newsportal.core.Services.ArticlesService;
// //import com.fasterxml.jackson.databind.ObjectMapper;
// // import com.google.gson.Gson;
// import org.apache.sling.api.SlingHttpServletRequest;
// import org.apache.sling.api.SlingHttpServletResponse;
// import org.apache.sling.api.servlets.SlingAllMethodsServlet;
// import org.apache.sling.servlets.annotations.SlingServletPaths;
// import org.osgi.service.component.annotations.Component;
// // import org.osgi.service.component.annotations.Reference;


// import javax.servlet.Servlet;
// import javax.servlet.ServletException;
// import java.io.IOException;
// import java.util.List;
// import java.util.Map;


// @Component(service = Servlet.class)
// @SlingServletPaths("/bin/newsportal/articles")
// public class ArticlesServlet extends SlingAllMethodsServlet {

//     // @Reference
//     // private ArticlesService articlesService;


//     @Override
//     protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
//             throws ServletException, IOException {

//         response.setContentType("application/json");
//         // try {
//         //     List<Map<String, Object>> articlesList = articlesService.getArticles();

//             // Gson gson = new Gson();
//             // String json = gson.toJson(articlesList);
//             // response.getWriter().write(json);

//     //     } catch (Exception e) {
//     //         response.getWriter().write("{\"error\":\"Failed to fetch articles\"}");
//     //     }
//     // }
// }
// }

