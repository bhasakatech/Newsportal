package com.adobe.aem.newsportal.core.utils;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Map;

@Component(service = NewsportalUtils.class)
public class NewsportalUtils {

    private static final String NP_SUBSERVICE = "npsubservice";

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    public ResourceResolver getResourceResolver() {
        Map<String, Object> authInfo = new HashMap<>();
        authInfo.put(ResourceResolverFactory.SUBSERVICE, NP_SUBSERVICE);
        try {
            return resourceResolverFactory.getServiceResourceResolver(authInfo);
        } catch (LoginException e) {

        }
        return null;
    }
}