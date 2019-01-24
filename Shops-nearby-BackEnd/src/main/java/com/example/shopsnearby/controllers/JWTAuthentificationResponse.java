package com.example.shopsnearby.controllers;

public class JWTAuthentificationResponse {
	    private String token;
	    private String tokenType = "Bearer ";

	    public JWTAuthentificationResponse(String accessToken) {
	        this.token = accessToken;
	    }

	    public String getToken() {
	        return token;
	    }

	    public void setToken(String accessToken) {
	        this.token = accessToken;
	    }

	    public String getTokenType() {
	        return tokenType;
	    }

	    public void setTokenType(String tokenType) {
	        this.tokenType = tokenType;
	    }
}
