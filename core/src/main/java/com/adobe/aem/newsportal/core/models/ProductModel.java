package com.adobe.aem.newsportal.core.models;

import com.adobe.aem.newsportal.core.Services.ProductService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;


@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class ProductModel {

    @OSGiService
    private ProductService productService;

    List<Map<String,Object>> productslist;
    @PostConstruct
    public void init() throws Exception {
        if(productService!=null){
            productslist= productService.getProducts();
        }
    }
    public List<Map<String, Object>> getProductslist() {
        return productslist;
    }
}