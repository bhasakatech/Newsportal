package com.adobe.aem.newsportal.core.Services;

import com.day.cq.commons.Externalizer;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = LocalisationService.class)
public class LocalisationService {

    @Reference
    private Externalizer externalizer;



    public String getAuthorUrl(ResourceResolver resolver, String path) {
        return externalizer.authorLink(resolver, path);
    }


    public String getPublishUrl(ResourceResolver resolver, String path) {
        return externalizer.publishLink(resolver, path);
    }
}



