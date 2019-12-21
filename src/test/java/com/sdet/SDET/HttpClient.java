package com.sdet.SDET;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpClient {


	    private final CloseableHttpClient httpClient = HttpClients.createDefault();

	    public static void main(String[] args) throws Exception {

	    	HttpClient obj = new HttpClient();

	        try {
	            System.out.println("Testing 1 - Send Http GET request");
	            obj.sendGet();

	            System.out.println("Testing 2 - Send Http POST request");
	            obj.sendPost();
	        } finally {
	            obj.close();
	        }
	    }

	    private void close() throws IOException {
	        httpClient.close();
	    }

	    private void sendGet() throws Exception {

	        HttpGet request = new HttpGet("http://qainterview.merchante-solutions.com:3030/");

	        // add request headers
	        request.addHeader("custom-key", "mkyong");
	        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

	        try (CloseableHttpResponse response = httpClient.execute(request)) {

	            // Get HttpResponse Status
	            System.out.println(response.getStatusLine().toString());

	            HttpEntity entity = response.getEntity();
	            Header headers = entity.getContentType();
	            System.out.println(headers);

	            if (entity != null) {
	                // return it as a String
	                String result = EntityUtils.toString(entity);
	                System.out.println(result);
	            }
	        }
	    }

	    private void sendPost() throws Exception {

	        HttpPost post = new HttpPost("http://qainterview.merchante-solutions.com:3030/");
	        // add request parameter, form parameters
	        List<NameValuePair> urlParameters = new ArrayList<>();
	        urlParameters.add(new BasicNameValuePair("username", "Mallikarjun"));
	        urlParameters.add(new BasicNameValuePair("password", "Mallikarjun"));
	        urlParameters.add(new BasicNameValuePair("custom", "Mallikarjun"));
	        post.setEntity(new UrlEncodedFormEntity(urlParameters));
	        try (CloseableHttpClient httpClient = HttpClients.createDefault();
	             CloseableHttpResponse response = httpClient.execute(post)) {
	            System.out.println(EntityUtils.toString(response.getEntity()));
	        }

	    }

	}


