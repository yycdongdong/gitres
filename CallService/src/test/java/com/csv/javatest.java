package com.csv;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.csv.bean.Rk;
import lombok.SneakyThrows;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class javatest {

    public static RestHighLevelClient restHighLevelClient;

    @SneakyThrows
    @Test
    public void TestEs(){
        GetRequest getRequest=new GetRequest("rk",String.valueOf(1));
        GetResponse getResponse=restHighLevelClient.get(getRequest,RequestOptions.DEFAULT);
        System.out.println(getResponse.getSource());
    }

    @Test
    public void testES(){
        BulkRequest request=new BulkRequest();
        try {
            for (int i=6;i<=10;i++)
            {
                Rk rk = new Rk();
                rk.setSno(Long.valueOf("203111"+i+"01"));
                rk.setSname("Fujian University"+String.valueOf(i));
                rk.setSchool("泉州师范学院"+String.valueOf(i));
                request.add(new IndexRequest("rk").id(String.valueOf(i-4)).source(JSON.toJSONString(rk), XContentType.JSON));
            }

            restHighLevelClient.bulk(request, RequestOptions.DEFAULT);

            System.out.println("rk");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void qsq() throws IOException {
        SearchRequest searchRequest=new SearchRequest("rk");
        QueryStringQueryBuilder queryStringQueryBuilder =QueryBuilders.queryStringQuery("Fujian泉州6");
        searchRequest.source().query(queryStringQueryBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(search);
    }
    @Test
    public void EsTest() throws IOException {
        SearchRequest searchRequest=new SearchRequest("rk");
        searchRequest.source().from(2);
        searchRequest.source().size(2);

        //RangeQueryBuilder sno = QueryBuilders.rangeQuery("sno");
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("school", "泉州");
        //sno.gte(203111061L);
        //sno.lte(203111961L);

        searchRequest.source().query(matchQueryBuilder);
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("school").requireFieldMatch(false);
        searchRequest.source().highlighter(highlightBuilder);
        SearchResponse searchResponse=restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);
        SearchHit[] hits1 = searchResponse.getHits().getHits();
        System.out.println("searchResponse");
        System.out.println(searchResponse);
        for(SearchHit hit:hits1){
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField school = highlightFields.get("school");
            System.out.println("getFragments");
            Text[] fragments = school.getFragments();
            System.out.println(fragments[0].toString());
            Rk jsonObject = (Rk) JSON.parseObject(hit.getSourceAsString(),Rk.class);
            System.out.println("getSchool");
            System.out.println(jsonObject.getSchool());
            System.out.println("jsonObject.toString");
            System.out.println(jsonObject.toString());

        }
    }
    @BeforeEach
    public void setUpEs(){
        restHighLevelClient=new RestHighLevelClient(RestClient.builder(HttpHost.create("192.168.80.131:9200")));
    }
    @AfterEach
    public void shutDownEs(){
        try {
            restHighLevelClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("bye");
    }
}
