package com.example.demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/getnews")
    public ResponseEntity<Response> Test() throws JSONException {
        String url = "https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=adcc55bfeab84a9c9a5bd3a96e5e363b&page=1&pagesize=5";
        String result = restTemplate.getForObject(url, String.class);
        JSONObject json = new JSONObject(result);
        JSONArray articlesObject = json.getJSONArray("articles");
        String totalResult= json.get("totalResults").toString();
        List<Articles> articles = new ArrayList<>();
        for (int i = 0;i<articlesObject.length();i++){

            JSONObject arrayElement = articlesObject.getJSONObject(i);

            String author = !arrayElement.isNull("author")?arrayElement.getString("author"):"";
            String title =  !arrayElement.isNull("author")?arrayElement.getString("title"):"";
            String description = !arrayElement.isNull("description")?arrayElement.getString("description"):"";
            String newsUrl = arrayElement.getString("url");
            String  urlToImage = !arrayElement.isNull("urlToImage")?arrayElement.getString("urlToImage"):null;
            String publishedAt = arrayElement.getString("publishedAt");
            Articles article = Articles.builder().author(author).title(title).description(description).url(newsUrl).urlToImage(urlToImage).publishedAt(publishedAt).build();
            articles.add(article);
        }
        Response respObj = new Response(totalResult,articles);
        return ResponseEntity.ok().body(respObj);
    }
}
