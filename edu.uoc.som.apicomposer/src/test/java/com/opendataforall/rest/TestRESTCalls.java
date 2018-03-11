package com.opendataforall.rest;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestRESTCalls {

	@Test
	public void testRESTRequest () throws UnirestException {
		
		HttpResponse<JsonNode> response = Unirest.get("http://httpbin.org/get").asJson();
		assertTrue(response.getBody().getObject().get("url").equals("http://httpbin.org/get"));
	}
}
