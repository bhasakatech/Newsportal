package com.adobe.aem.newsportal.core.Services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import java.util.List;
import java.util.Map;

@Component(service = ProductService.class)
@Designate(ocd= ProductServiceConfiguration.class)
public class ProductService {
    private String apiUrl;

    @Activate
    @Modified
    protected void activate(ProductServiceConfiguration config) {
        this.apiUrl = config.apiUrl();
    }

    public List<Map<String, Object>> getProducts() throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        String json = EntityUtils.toString(httpClient.execute(new HttpGet(apiUrl)).getEntity());

        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<List<Map<String, Object>>>() {}.getType());
    }
}
