package com.example.yeop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestfulController {
	private final String src_url = "https://dapi.kakao.com/v3/search/book";
	
	@Value("${booksearchapi.header.authorization}")
	private String auth_key;
	
    private Logger logger = LoggerFactory.getLogger(RestfulController.class);
    
    @Autowired
    RestTemplate restTemplate;
    
    @RequestMapping(value="/home/search", method = RequestMethod.GET)
    public String search(@RequestParam(value="query") String query,
    						@RequestParam(value="page") String page,
    						@RequestParam(value="size") String size) {
    							
    	String request_url = src_url + "?query=" + query + "&page=" + page + "&size=" + size;
    	logger.info("request url : {}", request_url);
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Authorization", "KakaoAK " + auth_key);
    	
    	HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
    	
    	ResponseEntity<String> response = restTemplate.exchange(
    		    request_url, HttpMethod.GET, entity, String.class);
    			
        logger.info(response.getBody());
        
        return response.getBody();
    }
    
    
}
