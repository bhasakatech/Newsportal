// package com.adobe.aem.newsportal.core.Services;

// import org.osgi.service.component.annotations.*;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// @Component
// public class PressReleaseService {

//     private static final Logger LOG = LoggerFactory.getLogger(PressReleaseService.class);
//     @Reference
//     ArticleService articleservices;

//     @Activate
//     public void activate() {
//         ArticleService articleservices= new ArticleService();
//         articleservices.getArticles();
//         LOG.info(articleservices.getArticles());
//         LOG.info("inside activate method");

//     }
//     @Deactivate
//     public void deactivate(){

//         LOG.info("inside deactivate method");

//     }
//     @Modified
//     public void update(){
//         LOG.info("inside upadate method");

//     }


// }

