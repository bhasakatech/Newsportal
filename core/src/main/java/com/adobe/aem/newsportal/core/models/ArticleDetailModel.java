package com.adobe.aem.newsportal.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.SlingHttpServletRequest;
// import org.apache.sling.models.annotations.Optional;
// import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.*;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;


@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ArticleDetailModel {

    @ValueMapValue
    private String articleTitle;

    @ValueMapValue
//    @Required
//    @Optional
    private String articleDescription ;

    @ValueMapValue(injectionStrategy = InjectionStrategy.REQUIRED)
    private Date articleExpiry ;



    @ValueMapValue(name= "sling:resourceType")
    private String slingResourceType ;

    @ValueMapValue
    private String articleType ;

    // @OSGiService
    // ArticleService articleService;

    @SlingObject
    ResourceResolver resourceResolver;

    @ScriptVariable
    ValueMap pageProperties;


    @ChildResource
    List<ArticleDetailsItemModel> articleDetails;

    @Self
    HelloWorldModel helloWorldModel;

    public HelloWorldModel getHelloWorldModel() {
        return helloWorldModel;
    }

    public List<ArticleDetailsItemModel> getArticleDetails() {
        return articleDetails;
    }

     private boolean articleIsExpired = false;

    public boolean isArticleIsExpired() {
        return articleIsExpired;
    }

    public Date getArticleExpiry() {
        return articleExpiry;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public String getSlingResourceType() {
        return slingResourceType;
    }

    public String getArticleType() {
        return articleType;
    }
private String articles;

private String pageTitle;
private String pageDescription;

    public String getArticles() {
        return articles;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    @PostConstruct
    public void init(){
    Date today = new Date();
    if(articleExpiry != null  && articleExpiry.compareTo(today) <0){
        articleIsExpired = true;
    }
        // articles = articleService.getArticles();
        //   pageTitle = pageProperties.get("jcr:title",String.class);
        //   pageDescription = pageProperties.get("jcr:description",String.class);
}


}
