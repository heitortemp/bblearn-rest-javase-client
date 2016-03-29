package br.com.grupoa.rest_test.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class RestRequest {

	private static final HttpClient client = HttpClientBuilder.create().build();

	public String readObject(String sUri, String accessToken) throws URISyntaxException, ClientProtocolException, IOException {

		URI uri = null;
		uri = new URI(RestConstants.HOSTNAME + sUri);

		System.out.println("Get request to URL: " + uri);

		HttpGet getRequest = new HttpGet(uri);
		getRequest.addHeader("accept", "application/json");
		getRequest.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

		HttpResponse response = client.execute(getRequest);

		if(response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		return org.apache.commons.io.IOUtils.toString(br);
	}
	public String storeObject(String sUri, String accessToken, String body) throws URISyntaxException, ClientProtocolException, IOException {

		URI uri = null;
		uri = new URI(RestConstants.HOSTNAME + sUri);

		System.out.println("Post request to URL: " + uri);

		HttpPost postRequest = new HttpPost(uri);
		postRequest.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		postRequest.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON));

		HttpResponse response = client.execute(postRequest);

		if (response.getStatusLine().getStatusCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(
				new InputStreamReader((response.getEntity().getContent())));

		return org.apache.commons.io.IOUtils.toString(br);
	}
	
	public String putObject(String sUri, String accessToken, String body) throws URISyntaxException, ClientProtocolException, IOException {

		URI uri = null;
		uri = new URI(RestConstants.HOSTNAME + sUri);

		System.out.println("Put request to URL: " + uri);

		HttpPut putRequest = new HttpPut(uri);
		putRequest.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		putRequest.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON));

		HttpResponse response = client.execute(putRequest);

		if (response.getStatusLine().getStatusCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(
				new InputStreamReader((response.getEntity().getContent())));

		return org.apache.commons.io.IOUtils.toString(br);
	}
	
	public String update(String sUri, String accessToken, String body) throws URISyntaxException, ClientProtocolException, IOException {

		URI uri = null;
		uri = new URI(RestConstants.HOSTNAME + sUri);

		System.out.println("Patch request to URL: " + uri);

		HttpPatch updateRequest = new HttpPatch(uri);
		updateRequest.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		updateRequest.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON));

		HttpResponse response = client.execute(updateRequest);

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(
				new InputStreamReader((response.getEntity().getContent())));

		return org.apache.commons.io.IOUtils.toString(br);
	}
	public String delete(String sUri, String accessToken) throws URISyntaxException, ClientProtocolException, IOException {

		URI uri = null;
		uri = new URI(RestConstants.HOSTNAME + sUri);

		System.out.println("Delete request to URL: " + uri);

		HttpDelete deleteRequest = new HttpDelete(uri);
		deleteRequest.addHeader("accept", "application/json");
		deleteRequest.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

		HttpResponse response = client.execute(deleteRequest);

		if(response.getStatusLine().getStatusCode() != 204) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}
		
		return "deleted";
	}
}
