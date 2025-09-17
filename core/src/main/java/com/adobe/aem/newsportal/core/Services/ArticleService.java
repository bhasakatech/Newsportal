// package com.adobe.aem.newsportal.core.Services;

// import org.osgi.service.component.annotations.Activate;
// import org.osgi.service.component.annotations.Component;
// import org.osgi.service.component.annotations.Deactivate;
// import org.osgi.service.component.annotations.Modified;
// import org.osgi.service.metatype.annotations.Designate;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;



// @Component(service=ArticleService.class)
// @Designate(ocd=ArticleServiceConfiguration.class)
// public class ArticleService {
//     private static final Logger LOG = LoggerFactory.getLogger(ArticleService.class);


//     @Activate
//     public void init(ArticleServiceConfiguration config) {
//          LOG.info("Inside activate method.");
//     }
//     @Deactivate
//     public void deactivate(ArticleServiceConfiguration config) {
//         LOG.info("Inside deactivate method.");

//     }

//     @Modified
//     public void update(ArticleServiceConfiguration config) {
//         LOG.info("Updated config : {}", config.articleApi());
//         LOG.info("Inside update method.");
//     }

//     public String getArticles() {
//    //  http://gorest.co.in/public/v2/posts
//         return "Articles from Rest API.";
//     }
// }


