// package com.adobe.aem.newsportal.core.models;

// import io.wcm.testing.mock.aem.junit5.AemContext;
// import io.wcm.testing.mock.aem.junit5.AemContextExtension;
// import org.apache.sling.api.resource.Resource;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;

// import java.util.HashMap;
// import java.util.Map;

// import static org.junit.jupiter.api.Assertions.*;

// @ExtendWith(AemContextExtension.class)
// class ProductCardModelTest {

//     private final AemContext context = new AemContext();
//     private ProductCardModel productCardModel;

//     @BeforeEach
//     void init() {
//         context.addModelsForClasses(ProductCardModel.class);

//         Map<String, Object> pageProps = new HashMap<>();
//         pageProps.put("jcr:title", "Shoes");
//         pageProps.put("jcr:description", "Shoes are out of stock");


//         context.create().page("/content/products/shoes");

//         Resource jcrContent = context.resourceResolver().getResource("/content/products/shoes/jcr:content");
//         context.create().resource(jcrContent.getPath(), pageProps);


//         Map<String, Object> props = new HashMap<>();
//         props.put("productTitle", "mass");
//         props.put("description", "wejdowiwewe");
//         props.put("productPrice", "30");
//         props.put("genderSelect", "female");
//         props.put("productPath", "/content/products/shoes");

//         Resource resource = context.create().resource("/content/newsportal/components/productCard",props);

//         productCardModel = resource.adaptTo(ProductCardModel.class);
//     }

//     @Test
//     void testProductCardModel() {
//         assertNotNull(productCardModel);


//         assertEquals("mass", productCardModel.getProductTitle());
//         assertEquals("wejdowiwewe", productCardModel.getDescription());
//         assertEquals("30", productCardModel.getProductPrice());
//         assertEquals("female", productCardModel.getGenderSelect());
//         assertEquals("/content/products/shoes", productCardModel.getProductPath());


//         assertEquals("Shoes", productCardModel.getPageTitle());
//         assertEquals("Shoes are out of stock", productCardModel.getPageDescription());
//     }
// }
