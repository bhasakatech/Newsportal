package com.adobe.aem.newsportal.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables={Resource.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ArticleDetailsItemModel {
    @ValueMapValue
    private String articleTitle;

    @ValueMapValue
    private String articlePath;

     public String getArticlePath() {
         return articlePath;
     }

     public String getArticleTitle() {
         return articleTitle;
     }


}
