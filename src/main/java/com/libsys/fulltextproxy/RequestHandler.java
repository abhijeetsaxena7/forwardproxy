package com.libsys.fulltextproxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RequestHandler {
	
	@RequestMapping(value = "/proxy", produces = {MediaType.TEXT_HTML_VALUE})
	public ResponseEntity<String> requestHandler(@RequestParam String fullTextString) {
		
		RestTemplate restTemp = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> responseMediaTypes = new ArrayList<>();
		responseMediaTypes.add(MediaType.TEXT_HTML);
		
		headers.setAccept(responseMediaTypes);
		headers.add("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36");
		
		HttpEntity<String> entity  = new HttpEntity<>(headers);
		
		return restTemp.exchange(fullTextString,HttpMethod.GET,entity,String.class);
	}
}
