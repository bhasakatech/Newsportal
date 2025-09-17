package com.adobe.aem.newsportal.core.Services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition

public @interface ProductServiceConfiguration {
    @AttributeDefinition(
            name = "API URL",
            description = "The endpoint from which product data is fetched"
    )
    String apiUrl() ;


}
