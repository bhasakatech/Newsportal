package com.adobe.aem.newsportal.core.models;

 
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
// import java.util.Iterator;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
 public class UserCardModel {

    @ValueMapValue
    private String userCardPath;

    @SlingObject
    private ResourceResolver resourceResolver;

    public String getUserCardPath() {
        return userCardPath;
    }

    public ResourceResolver getResourceResolver() {
        return resourceResolver;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    private String productTitle;
    private String productPrice;
    private String productDescription;


    @PostConstruct
    protected void init() {
        if (resourceResolver != null && userCardPath != null) {
            Resource resource = resourceResolver.getResource(userCardPath + "/jcr:content");
            if (resource != null) {

               Resource componentResource =  getComponentResource("newsportal/components/productdetails", resource);
               if (componentResource != null) {
                  ValueMap props = componentResource.getValueMap();
                  if(props!=null){
                      productTitle =props.get("productTitle",String.class);
                      productDescription=props.get("productDescription",String.class);
                      productPrice=props.get("productPrice",String.class);
                  }
               }
            }
        }
    }

    public Resource getComponentResource(String resourceType, Resource rootResource)
    {
        if (rootResource == null) {
            return null;
        }

        if (rootResource.isResourceType(resourceType)) {
            return rootResource;
        }

        for (Resource child : rootResource.getChildren()) {
            Resource found = getComponentResource(resourceType, child);
            if (found != null) {

                return found;
            }
        }

        return null;
    }

}

