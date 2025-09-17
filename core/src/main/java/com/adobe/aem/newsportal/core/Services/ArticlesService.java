// package com.adobe.aem.newsportal.core.Services;

// import com.google.gson.Gson;
// import com.google.gson.reflect.TypeToken;
// import org.apache.http.client.methods.HttpGet;
// import org.apache.http.impl.client.CloseableHttpClient;
// import org.apache.http.impl.client.HttpClients;
// import org.apache.http.util.EntityUtils;
// import org.osgi.service.component.annotations.Component;

// import java.util.List;
// import java.util.Map;

// @Component(service = ArticlesService.class )
// public class ArticlesService {

//     private static final String API_URL = "https://fakestoreapi.com/products";

//     public List<Map<String, Object>> getArticles() throws Exception {

//         CloseableHttpClient httpClient = HttpClients.createDefault();

//         String json = EntityUtils.toString(httpClient.execute(new HttpGet(API_URL)).getEntity());

//         Gson gson = new Gson();
//         return gson.fromJson(json, new TypeToken<List<Map<String, Object>>>() {}.getType());
// //        ObjectMapper mapper = new ObjectMapper();
// //        return mapper.readValue(json, List.class);
//     }

// }
