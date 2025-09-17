package com.adobe.aem.newsportal.core.models;

import com.adobe.aem.newsportal.core.Services.LocalisationService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;

public class LocalisationModel {

    @Model(
            adaptables = SlingHttpServletRequest.class,
            defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
    )
    public class LocalizationModel {

        @Self
        private SlingHttpServletRequest request;

        @OSGiService
        private LocalisationService localisationService;

        public String getAuthorDomain() {
            ResourceResolver resolver = request.getResourceResolver();
            return localisationService.getAuthorUrl(resolver,   "/content/newsportal");
        }

        public String getPublishDomain() {
            ResourceResolver resolver = request.getResourceResolver();
            return localisationService.getPublishUrl(resolver,  "/content/newsportal");
        }
    }
}
