// package com.adobe.aem.newsportal.core.models;

// import io.wcm.testing.mock.aem.junit5.AemContext;
// import io.wcm.testing.mock.aem.junit5.AemContextExtension;
// import org.apache.sling.api.resource.Resource;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.junit.jupiter.MockitoExtension;

// import java.util.HashMap;
// import java.util.Map;

// import static org.junit.jupiter.api.Assertions.*;



// @ExtendWith({AemContextExtension.class, MockitoExtension.class})
// class ArticleDetailModelTest {

//     AemContext Context = new AemContext();

//     ArticleDetailModel articleDetailModel;
//  @BeforeEach
// void init(){
//      Context.addModelsForClasses(ArticleDetailModel.class);
//      Context.load().json("/articleDetails.json","/content");
// Resource resource=Context.currentResource("/content");
// articleDetailModel=resource.adaptTo(ArticleDetailModel.class);




// //     Map<String,Object > props=new HashMap();
// //     props.put("articleTitle","jailer");
// //     props.put("articleDesc","jailer Desc");
// //     props.put("sling:resourceType","newsportal/component/articleDetail");
// //
// //     Resource resource=Context.create().resource("/apps/newsportal/components/articledetail",props);
// //     articleDetailModel= resource.adaptTo(ArticleDetailModel.class);
//  }


//  @Test
//     void articlepropsTest(){
//      assertEquals("jailer",articleDetailModel.getArticleTitle());
//      assertEquals("jailer mash",articleDetailModel.getArticleDescription());
//  }
// }