package br.com.grupoa.rest_test.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.grupoa.rest_test.model.Token;

class Authorizer {

	public Token authorize() throws URISyntaxException, ClientProtocolException, IOException {

		System.out.println("=============AUTHENTICATION===================");
		URI uri = null;
		uri = new URI(RestConstants.HOSTNAME + RestConstants.AUTH_PATH );

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(uri);
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("grant_type", "client_credentials"));
		postRequest.setEntity(new UrlEncodedFormEntity(urlParameters)); 
		postRequest.setHeader(HttpHeaders.AUTHORIZATION, getHash());

		HttpResponse response = client.execute(postRequest);
		System.out.println("Response Code : " 
				+ response.getStatusLine().getStatusCode());

		String jsonReturned = EntityUtils.toString(response.getEntity());

		System.out.println(jsonReturned);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(jsonReturned);
		Token token = new Token();
		token.setToken(root.path("access_token").asText());
		token.setType(root.path("token_type").asText());
		token.setExpiry(root.path("expires_in").asText());

		return token;

	}

	private String getHash() {

		String auth = RestConstants.KEY + ":" + RestConstants.SECRET;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);

		return authHeader;

	}
}