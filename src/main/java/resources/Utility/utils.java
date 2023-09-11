package resources.Utility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utils {
	RequestSpecification requestSpecification;
	Response response;
	String bearer_token = "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";
	String base_URL = "https://api.github.com";

	public Response postRequest(String resourcePath,String payLoad)
	{
		RestFrameworkLogger.info("Post Request URI is - "+ base_URL);
		RestFrameworkLogger.info("Resource Path is - "+ resourcePath);
		RestFrameworkLogger.info("Request Payload is - "+ payLoad);
		requestSpecification = RestAssured.given().body(payLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer "+bearer_token);
		response =requestSpecification.post(base_URL + resourcePath);
		RestFrameworkLogger.info("Response of Post Request is - "+ response.getBody().asString());
		return response;
	}
	public Response deleteRequest(String resourcePath,String repoName)
	{	RestFrameworkLogger.info("Delete Request URI is - "+ base_URL+resourcePath+repoName);
		requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer "+bearer_token);
		response =requestSpecification.delete(base_URL + resourcePath + repoName);
		RestFrameworkLogger.info("Delete Request Response Code is - "+ response.getStatusCode());
		return response;
	}
}
