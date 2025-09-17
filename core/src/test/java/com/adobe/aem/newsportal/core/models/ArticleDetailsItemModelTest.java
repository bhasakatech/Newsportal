package com.adobe.aem.newsportal.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(AemContextExtension.class)
class ArticleDetailsItemModelTest {
    AemContext Context = new AemContext();
    ArticleDetailsItemModel articleDetailsItemModel;

    @BeforeEach
    void init(){
        Context.addModelsForClasses(ArticleDetailsItemModel.class);
        Map<String,Object> props= new HashMap<>();
        props.put("articlePath","/apps/newsportal/components/articleDetail");
        props.put("articleTitle","jailer");

        Resource resource= Context.create().resource("/newsportal/components/articledetail",props);
        articleDetailsItemModel=resource.adaptTo(ArticleDetailsItemModel.class);
    }
@Test
    void  articleDetailsItemMode1(){
        assertEquals("/apps/newsportal/components/articleDetail",articleDetailsItemModel.getArticlePath());
        assertEquals("jailer",articleDetailsItemModel.getArticleTitle());
}



}