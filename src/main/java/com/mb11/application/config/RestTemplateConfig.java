package com.mb11.application.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	private static String hostname = "rest.entitysport.com";
	
	private static boolean isSSLEnable = true;
	
	private static String context =  "v2";
	
	public static String apiTocken = "ec471071441bb2ac538a0ff901abd249";
	
	@Autowired
    CloseableHttpClient httpClient;
 
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
        return restTemplate;
    }
 
    @Bean
    public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setHttpClient(httpClient);
        return clientHttpRequestFactory;
    }
 
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("poolScheduler");
        scheduler.setPoolSize(10);
        return scheduler;
    }
    
    public static StringBuilder getBaseURL() {
    	StringBuilder builder = new StringBuilder();
    	if(isSSLEnable) {
    		builder.append("https://");
    	} else {
    		builder.append("http://");
    	}
    	builder.append(hostname);
    	builder.append("/"+context);
		return builder;
    	
    }
    
    
}