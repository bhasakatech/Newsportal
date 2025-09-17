// package com.adobe.aem.newsportal.core.Services;

// import io.wcm.testing.mock.aem.junit5.AemContext;
// import io.wcm.testing.mock.aem.junit5.AemContextExtension;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.junit.jupiter.MockitoExtension;

// import static org.junit.jupiter.api.Assertions.*;
// @ExtendWith({AemContextExtension.class, MockitoExtension.class})


// class ArticleServiceTest {
// AemContext context =new AemContext();
//     @Mock
//     ArticleServiceConfiguration config;

//     ArticleService articleService =new ArticleService();
//     @BeforeEach
//     void  init(){
//         Mockito.when(config.articleApi()).thenReturn("http://gorest.co.in/public/v2/posts");
//         Mockito.when(config.enable()).thenReturn(true);
//     }

//     @Test
//     void  testArticleServiceLifeCycleMethod(){
// articleService.deactivate(config);
// assertEquals("http://gorest.co.in/public/v2/posts",articleService);
//     }
// }