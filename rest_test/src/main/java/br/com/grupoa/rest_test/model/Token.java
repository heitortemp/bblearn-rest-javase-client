package br.com.grupoa.rest_test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {

	@JsonProperty("accessToken")
	private String accessToken;
	@JsonProperty("tokenType")
	private String tokenType;
	@JsonProperty("expiresIn")
	private String expiresIn;

	public Token() {
	}

	public String getToken() {
		return accessToken;
	}

	public void setToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getType() {
		return tokenType;
	}

	public void setType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getExpiry() {
		return expiresIn;
	}

	public void setExpiry(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	@Override
	public String toString() {
		return "Token{" +
				"accessToken=" + accessToken + '\'' +
				", tokenType=" + tokenType + '\'' +
				", expiresIn=" + expiresIn +
				'}';
	}
}
