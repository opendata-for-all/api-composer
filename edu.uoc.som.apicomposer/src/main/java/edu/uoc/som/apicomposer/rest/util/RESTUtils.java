package edu.uoc.som.apicomposer.rest.util;

import java.util.Map;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

import core.Parameter;
import edu.uoc.som.apicomposer.rest.model.APIRequest;

public class RESTUtils {

	public static HttpResponse<String> sendHTTPRequest(APIRequest apiRequest) throws UnirestException {
		
		HttpRequest rest = null;
		HttpMethod method = OpenAPIUtils.getOperationMethod(apiRequest.getOperation());
		switch (method) {
		case GET:
			rest = Unirest.get(apiRequest.getSchema().getLiteral()+"://"+OpenAPIUtils.getOpearationPath(apiRequest.getOperation()))
					.header("Accept", "application/json").header("Content-type", "application/json");
			addParameters(apiRequest, rest);
			break;

		default:
			break;
		}
		
		return rest.asString();

	}

	private static void addParameters(APIRequest apiRequest, HttpRequest rest) {
		for (Map.Entry<Parameter, String> parameter : apiRequest.getParameters().entrySet()) {
			switch (parameter.getKey().getLocation()) {
			case QUERY:
				rest.queryString(parameter.getKey().getName(), parameter.getValue());
			case HEADER:
				rest.header(parameter.getKey().getName(), parameter.getValue());
			case PATH:
				rest.routeParam(parameter.getKey().getName(), parameter.getValue());
			case BODY:
				((HttpRequestWithBody) rest).body(parameter.getValue());
			default:
				break;
			}

		}
	}
}
