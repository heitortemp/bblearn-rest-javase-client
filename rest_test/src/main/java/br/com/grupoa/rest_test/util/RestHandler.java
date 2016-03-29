package br.com.grupoa.rest_test.util;


public interface RestHandler {

	String createObject(String accessToken);

	String readObject(String accessToken);

	String updateObject(String accessToken);

	String deleteObject(String accessToken);

}