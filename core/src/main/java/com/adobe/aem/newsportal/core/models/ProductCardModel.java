package com.adobe.aem.newsportal.core.models;

import javax.annotation.PostConstruct;
 

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
// import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;



@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProductCardModel {

    @ValueMapValue
    private String productTitle;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String productPrice;

    @ValueMapValue
    private String genderSelect;

    @ValueMapValue
    private String productPath;



    @SlingObject
     private  ResourceResolver resourceResolver ;

    private String pageDescription;
    private String pageTitle;






    public ResourceResolver getResourceResolver() {

        return resourceResolver;
    }

    @PostConstruct
    protected void init() {
        if (resourceResolver != null && productPath != null) {
            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
            if (pageManager != null) {
                Page other = pageManager.getPage(productPath);
                if (other != null) {
                    ValueMap props = other.getProperties();
                    pageTitle = props.get("jcr:title", String.class);
                    pageDescription = props.get("jcr:description", String.class);

                }
            }
        }
    }




    public String getProductTitle() {
        return productTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getGenderSelect() {
        return genderSelect;
    }

    public String getProductPath() {
        return productPath;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getPageDescription() {
        return pageDescription;
    }


}


