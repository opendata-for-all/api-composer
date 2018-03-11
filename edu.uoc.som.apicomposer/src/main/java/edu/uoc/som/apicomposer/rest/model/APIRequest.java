package edu.uoc.som.apicomposer.rest.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

import core.Operation;
import core.Parameter;
import core.SchemeType;
import edu.uoc.som.apicomposer.rest.util.OpenAPIUtils;

public class APIRequest {
	static final Logger logger = LogManager.getLogger();
	private Operation operation;
	private org.eclipse.uml2.uml.Class globalClass;
	private org.eclipse.uml2.uml.Class interClass;
	private Map<Parameter, String> parameters;
	private String innerPath = null;
	private boolean runtime;
	private Map<String,String> runtimeVariables;
	private SchemeType scheme;
	private HttpRequest request;
	private double responseType;
	
	private HttpResponse<String> response;
	private JsonElement responseAsJson;
	
	public APIRequest() {
		parameters = new HashMap<Parameter, String>();
		runtimeVariables = new HashMap<String, String>();
		scheme= SchemeType.HTTP;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public Map<Parameter, String> getParameters() {
		return parameters;
	}
	public void setParameters(Map<Parameter, String> parameters) {
		this.parameters = parameters;
	}

	public SchemeType getSchema() {
		return scheme;
	}
	public void setSchema(SchemeType schema) {
		this.scheme = schema;
	}
	
	
	
	public  HttpResponse<String> send() throws UnirestException {
		
		HttpMethod method = OpenAPIUtils.getOperationMethod(operation);
		switch (method) {
		case GET:
			request = Unirest.get(scheme.getLiteral()+"://"+OpenAPIUtils.getOpearationPath(operation))
					.header("Accept", "application/json").header("Content-type", "application/json");
			addParameters(request);
			break;

		default:
			break;
		}
		
		long start = System.currentTimeMillis();
		response = request.asString();
		long end = System.currentTimeMillis();
		responseType =  (end - start) ;
		addLog(response.getStatus() + " " +
		request.getUrl() + " "
 + responseType);
		JsonParser parser = new JsonParser();
		responseAsJson = parser.parse(response.getBody());
		return response;

	}
	private  void addParameters(HttpRequest rest) {
		for (Map.Entry<Parameter, String> parameter : parameters.entrySet()) {
			switch (parameter.getKey().getLocation()) {
			case QUERY:
				rest.queryString(parameter.getKey().getName(), parameter.getValue()); break;
			case HEADER:
				rest.header(parameter.getKey().getName(), parameter.getValue()); break;
			case PATH:
				rest.routeParam(parameter.getKey().getName(), parameter.getValue()); break;
			case BODY:
				((HttpRequestWithBody) rest).body(parameter.getValue()); break;
			default:
				break;
			}

		}
	}
	public HttpResponse<String> getResponse() {
		return response;
	}
	public void setResponse(HttpResponse<String> response) {
		this.response = response;
	}
	public JsonElement getResponseAsJson() {
		return responseAsJson;
	}
	public void setResponseAsJson(JsonElement responseAsJson) {
		this.responseAsJson = responseAsJson;
	}
	public HttpRequest getRequest() {
		return request;
	}
	public void setRequest(HttpRequest request) {
		this.request = request;
	}
	public double getResponseType() {
		return responseType;
	}
	public void setResponseType(double responseType) {
		this.responseType = responseType;
	}
	public org.eclipse.uml2.uml.Class getGlobalClass() {
		return globalClass;
	}
	public void setGlobalClass(org.eclipse.uml2.uml.Class globalClass) {
		this.globalClass = globalClass;
	}
	public org.eclipse.uml2.uml.Class getInterClass() {
		return interClass;
	}
	public void setInterClass(org.eclipse.uml2.uml.Class interClass) {
		this.interClass = interClass;
	}
	public String getInnerPath() {
		return innerPath;
	}
	public void setInnerPath(String innerPath) {
		this.innerPath = innerPath;
	}
	public boolean isRuntime() {
		return runtime;
	}
	public void setRuntime(boolean runtime) {
		this.runtime = runtime;
	}
	public Map<String,String> getRuntimeVariables() {
		return runtimeVariables;
	}
	public void setRuntimeVariables(Map<String,String> runtimeVariables) {
		this.runtimeVariables = runtimeVariables;
	}

	
	private void addLog(String message) {
		ThreadContext.put("TRACECALL", "default");
	    logger.info(message);
	    ThreadContext.remove("TRACECALL");
	}
	

}
