package com.springboot.CustomSecurityWithDB;

import java.net.URI;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springboot.CustomSecurityWithDB.entities.Topic;


public class TopicRestClientUtil {

    public void getTopicByIdDemo() {

   	HttpHeaders headers = getHeaders();
       RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/topic/{id}";
       HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

       ResponseEntity<Topic> responseEntity = restTemplate.
    		   exchange(url,
    		   HttpMethod.GET, requestEntity, Topic.class, 51);

       Topic topic = responseEntity.getBody();
       System.out.println("Id:"+topic.getTopicId()+", Title:"+topic.getTitle()
                +", Category:"+topic.getCategory());
   }

	public void getAllTopicsDemo() {
   	HttpHeaders headers = getHeaders();
   	
       RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/topics";
       HttpEntity<String> requestEntity = new
    		   HttpEntity<String>(headers);
       ResponseEntity<Topic[]> responseEntity =
    		   restTemplate.exchange(url, HttpMethod.GET,
    		   requestEntity, Topic[].class);
      System.out.println(responseEntity.getStatusCode());
       Topic[] topics = responseEntity.getBody();
       for(Topic topic : topics) {
             System.out.println("Id:"+topic.getTopicId()+", Title:"+topic.getTitle()
                     +", Category: "+topic.getCategory());
       }
   }

   public void addTopicDemo() {
   	HttpHeaders headers = getHeaders();
       RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/topic";


	    Topic topic = new Topic();
	    topic.setTitle("RestTemplate Through Spring Boot Microservices");
	    topic.setCategory("RestTemplate");



       HttpEntity<Topic> requestEntity = new HttpEntity<Topic>(topic, headers);
       URI uri = restTemplate.postForLocation(url, requestEntity);


       System.out.println(uri.getPath());
   }

   public void updateTopicDemo() {
   	HttpHeaders headers = getHeaders();
       RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/topic";
	    Topic topic = new Topic();
	    topic.setTopicId(4);
	    topic.setTitle("Update:RestTemplate Through icroservices");
	    topic.setCategory("Update:Rest");

       HttpEntity<Topic> requestEntity = new HttpEntity<Topic>(topic, headers);
       restTemplate.put(url, requestEntity);
   }

   public void deleteTopicDemo() {
   	HttpHeaders headers = getHeaders();
       RestTemplate restTemplate = new RestTemplate();


	    String url = "http://localhost:8080/user/topic/{id}";
       HttpEntity<Topic> requestEntity = new HttpEntity<Topic>(headers);
       restTemplate.exchange(url, HttpMethod.DELETE, requestEntity,
    		   Void.class, 4);
   }

   private HttpHeaders getHeaders() {
  // String credential="naresh:naresh";
   	String credential="Gayatri:Gayatri";


   	String encodedCredential = new String
   			(Base64.encodeBase64(credential.getBytes()));
   	
   	System.out.println("encoded credentials: "+encodedCredential);
       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);
    	headers.add("Authorization", "Basic " + encodedCredential);
   	return headers;
   }


   public static void main(String args[]) {
   	TopicRestClientUtil topicRestClientUtil = new TopicRestClientUtil();

   	//topicRestClientUtil.getAllTopicsDemo();

	//topicRestClientUtil.addTopicDemo();
   	//topicRestClientUtil.updateTopicDemo();

   	//topicRestClientUtil.getTopicByIdDemo();

   	topicRestClientUtil.deleteTopicDemo();

   	topicRestClientUtil.getAllTopicsDemo();
   }
}
