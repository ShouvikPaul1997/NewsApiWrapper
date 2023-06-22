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
//        String result = restTemplate.getForObject(url, String.class);
//        return  ResponseEntity.ok().body(result);

        String str ="{\"status\":\"ok\",\"totalResults\":70,\"articles\":[{\"source\":{\"id\":null,\"name\":\"Ak4tsay1.com\"}," +
                "\"author\":\"Adesh Kothari\",\"title\":\"India vs West Indies 2023: Confirmed Test Squad and Players List - AK4TSay1" +
                " Cricalytics\",\"description\":\"Cheteshwar Pujara expected to be dropped as we look at the confirmed best " +
                "Test squad and players list for India vs West Indies 2023.  After a\",\"url\":\"" +
                "https://www.ak4tsay1.com/india-vs-west-indies-2023-confirmed-test-squad-and-players-list/\",\"" +
                "urlToImage\":\"https://www.ak4tsay1.com/wp-content/uploads/2023/06/india-vs-west-indies-" +
                "confirmed-predicted-test-squad-2023.jpg\",\"publishedAt\":\"2023-06-21T16:18:33Z\",\"conten" +
                "t\":\"Cheteshwar Pujara expected to be dropped as we look at the confirmed best Test squad an" +
                "d players list for India vs West Indies 2023. \\r\\nAfter a disappointing end to the second" +
                " edition of the World Tes… [+5357 chars]\"},{\"source\":{\"id\":null,\"name\":\"NDTV News\"},\"" +
                "author\":\"Press Trust of India\",\"title\":\"Pakistan Board's Incoming Chairman Rejects Asia Cup 'Hybrid Model' - NDTV Sports\",\"description\":\"The likely new chairman of PCB Zaka Ashraf has rejected his predecessor Najam Sethi's much-publicised \\\"hybrid model\\\" for the upcoming Asia Cup\",\"url\":\"https://sports.ndtv.com/cricket/pakistan-boards-incoming-chairman-rejects-asia-cup-hybrid-model-4141181\",\"urlToImage\":\"https://c.ndtvimg.com/2023-06/lk6icvag_zaka-ashraf-806_625x300_21_June_23.jpg\",\"publishedAt\":\"2023-06-21T16:00:50Z\",\"content\":\"The likely new chairman of Pakistan Cricket Board (PCB) Zaka Ashraf has rejected his predecessor Najam Sethi's much-publicised \\\"hybrid model\\\" for the upcoming Asia Cup, which is slated to be held in … [+3621 chars]\"},{\"source\":{\"id\":null,\"name\":\"NDTV News\"},\"author\":\"NDTV Sports Desk\",\"title\":\"India vs Pakistan Live, SAFF Championship 2023: Sunil Chhetri Scores Hat-Trick As India Go 3-0 Up vs Pakistan | Football News - NDTV Sports\",\"description\":\"IND vs PAK SAFF Championship 2023 Highlights: A hattrick from captain Sunil Chhetri guided India to a thumping 4-0 win over Pakistan in their opening Group A match of the South Asian Football Federation (SAFF) Championship on Wednesday\",\"url\":\"https://sports.ndtv.com/football/india-vs-pakistan-saff-championship-2023-match-live-score-updates-4140531\",\"urlToImage\":\"https://c.ndtvimg.com/2023-06/eo604hdo_sunil-chhetri_625x300_21_June_23.jpg\",\"publishedAt\":\"2023-06-21T15:39:09Z\",\"content\":\"IND vs PAK, SAFF Championship 2023, Highlights: A hattrick from captain Sunil Chhetri guided India to a thumping 4-0 win over Pakistan in their opening Group A match of the South Asian Football Feder… [+288 chars]\"},{\"source\":{\"id\":null,\"name\":\"Insidesport.in\"},\"author\":\"Sreehari Menon\",\"title\":\"IND vs WI to be Rescheduled? WI stars in schedule conflict as WC Qualifiers threaten 1st Test - InsideSport\",\"description\":\"IND vs WI 1st Test could be rescheduled as the West Indies are involved in the World Cup 2023 Qualifiers in Zimbabwe until July 9\",\"url\":\"https://www.insidesport.in/ind-vs-wi-to-be-rescheduled-wi-stars-in-schedule-conflict-as-wc-qualifiers-threaten-1st-test/\",\"urlToImage\":\"https://www.insidesport.in/wp-content/uploads/2023/06/194c2533-01b9-47e7-856d-3198a54ce2bd.jpg\",\"publishedAt\":\"2023-06-21T15:19:52Z\",\"content\":\"The India tour of West Indies is in a scheduling conflict. Rohit Sharmas side are set to face the hosts in the…The India tour of West Indies is in a scheduling conflict. Rohit Sharmas side are set to… [+1296 chars]\"},{\"source\":{\"id\":null,\"name\":\"Cricketworldcup.com\"},\"author\":\"ICC\",\"title\":\"CWC Qualifier Day 4: Scotland down Ireland in a thriller; Oman grow in confidence with second consecutive win - ICC Women's World Cup\",\"description\":\"Group B action of the ICC Men's Cricket World Cup Qualifier 2023 saw wins for Scotland and Oman.\",\"url\":\"https://www.cricketworldcup.com/news/3546754\",\"urlToImage\":\"https://resources.pulse.icc-cricket.com/ICC/photo/2023/06/21/a2fe3ff3-643b-4b82-9665-b4f7d9561c4a/GettyImages-1500343176.jpg\",\"publishedAt\":\"2023-06-21T15:11:15Z\",\"content\":\"Group B action of the ICC Men's Cricket World Cup Qualifier 2023 saw wins for Scotland and Oman.\\r\\nMichael Leask's stunning knock of 91* helped Scotland down Ireland in their Group B encounter at Bula… [+7915 chars]\"}]}";

        JSONObject json = new JSONObject(str);
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
