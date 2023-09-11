package StepsDefinition;

import static org.testng.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJOPayloads.createRepoPOJO;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.TestDataBuilder;
import resources.Utility.RestFrameworkLogger;
import resources.Utility.utils;

public class postCreatRepo extends utils {
	// Step 1 : After Creating Runner,Definition, Feature File
	// Step 2 : Create Object of POJO Class
	// Step 3 : Create ObjectMapper object
	// Step 4 : RequestSpecification object and pass payload in body
	// Step 5 : Add Content type and Token then call post URL;
	
	ObjectMapper objectMapper;
	
	JsonPath jsonpath;
	RequestSpecification requestSpecification;
	Response response;
	TestDataBuilder data =new TestDataBuilder();
	public static String payLoad;
	
	
	@Given("Starting Test Case {string}")
	public void starting_test_case(String testCaseName) {
	    // Write code here that turns the phrase above into concrete actions
		RestFrameworkLogger.initLogger();
	    RestFrameworkLogger.startTestCase(testCaseName);
	}
	@Then("EndingTestCase")
	public void ending_test_case() {
	    // Write code here that turns the phrase above into concrete actions
	    RestFrameworkLogger.endestCase();
	}
	
	/*
	 * @Given("Create Repo Payload name <name> and description <description>")
	 * public void create_repo_payload_name_and_description(String name, String
	 * description) throws JsonProcessingException { // Write code here that turns
	 * the phrase above into concrete actions
	 * 
	 * objectMapper = new ObjectMapper(); payLoad =
	 * objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.
	 * createRepo(name,description)); }
	 */
	
	
	@Given("Create Repo Payload name {string} and description {string}")
	public void create_repo_payload_name_and_description(String name, String description) throws JsonProcessingException {
	    // Write code here that turns the phrase above into concrete actions

		objectMapper = new ObjectMapper();
		 payLoad = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.createRepo(name,description));
	}
	
	
	
	/*
	 * @Given("Create Repo Payload") public void create_repo_payload() throws
	 * JsonProcessingException { // Write code here that turns the phrase above into
	 * concrete actions
	 * 
	 * objectMapper = new ObjectMapper(); payLoad =
	 * objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.
	 * createRepo());
	 * 
	 * }
	 */

	@When("User Calls Create API {string} for Post API Call")
	public void user_calls_for_cart_create(String resourcePath) {
	response = postRequest(resourcePath, payLoad);
	System.out.println(response.getBody().asString());
		

	}

	@Then("API Method call successful with status code {int}")
	public void api_method_call_successful_with_status_code(Integer statusCode) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(statusCode, response.getStatusCode());
		RestFrameworkLogger.info("Status Code Varification is Done........");
		
		
	}
	
	
	
	
	/*
	 * @Then("Verify Repository name is <name>") public void
	 * verify_repository_name_is_name(String name) { // Write code here that turns
	 * the phrase above into concrete actions jsonpath = new
	 * JsonPath(response.getBody().asString()); String keyValue =
	 * jsonpath.get("name"); assertEquals(name, keyValue);
	 * RestFrameworkLogger.info("Actual Repo Name is - " + keyValue);
	 * RestFrameworkLogger.info("Expected Repo Name is - " + name); }
	 * 
	 * 
	 * @Then("Verify Repository description is <description>") public void
	 * verify_repository_description_is_description(String description) { // Write
	 * code here that turns the phrase above into concrete actions jsonpath = new
	 * JsonPath(response.getBody().asString()); String keyValue =
	 * jsonpath.get("name"); assertEquals(description, keyValue);
	 * RestFrameworkLogger.info("Actual Repo Name is - " + keyValue);
	 * RestFrameworkLogger.info("Expected Repo Name is - " + description); }
	 */
	
	@Then("Verify Repository name is {string}")
	public void verify_repository_name_is_name(String name) {
	    // Write code here that turns the phrase above into concrete actions
		jsonpath = new JsonPath(response.getBody().asString());
		String keyValue = jsonpath.get("name");
		assertEquals(name, keyValue);
		RestFrameworkLogger.info("Actual Repo Name is - " + keyValue);
		RestFrameworkLogger.info("Expected Repo Name is - " + name);
	}
	
	
	@Then("Verify Repository description is {string}")
	public void verify_repository_description_is_description(String description) {
	    // Write code here that turns the phrase above into concrete actions
		jsonpath = new JsonPath(response.getBody().asString());
		String keyValue = jsonpath.get("description");
		assertEquals(description, keyValue);
		RestFrameworkLogger.info("Actual Repo Name is - " + keyValue);
		RestFrameworkLogger.info("Expected Repo Name is - " + description);
	}
	
	/*
	 * @Then("Verify Repository {string} is {string[]}") public void
	 * verify_repository_is_description(String description) { // Write code here
	 * that turns the phrase above into concrete actions jsonpath = new
	 * JsonPath(response.getBody().asString()); String keyValue =
	 * jsonpath.get("description"); assertEquals(description, keyValue);
	 * RestFrameworkLogger.info("Actual Repo Name is - " + keyValue);
	 * RestFrameworkLogger.info("Expected Repo Name is - " + description); }
	 */

	/*
	 * @Then("Verify Repository {string} is {string}") public void
	 * verify_created(String responseKey, String repoName) { // Write code here that
	 * turns the phrase above into concrete actions jsonpath = new
	 * JsonPath(response.getBody().asString()); String keyValue =
	 * jsonpath.get(responseKey); assertEquals(repoName, keyValue);
	 * RestFrameworkLogger.info("Actual Repo Name is - " + keyValue);
	 * RestFrameworkLogger.info("Expected Repo Name is - " + repoName);
	 * 
	 * }
	 */
	
	@When("User Calls Delete API {string} for Post API Call")
	public void user_calls_delete_api_for_post_api_call(String resourcePath) {
	    // Write code here that turns the phrase above into concrete actions
	RestFrameworkLogger.info("Delete function reponame - "+data.getRepoName());
		response = deleteRequest(resourcePath,data.getRepoName());
		
		
		
	}

}
