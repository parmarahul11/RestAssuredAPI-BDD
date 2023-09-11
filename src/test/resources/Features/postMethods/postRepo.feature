Feature: Validate Cart Repository and Delete Repository 


Scenario Outline: Verify Create Repo API
Given 	Starting Test Case "Verify Create Repo API"
Given 	Create Repo Payload name "API-Cucumber" and description "Cucumber RESTAssured"
When 		User Calls Create API "/user/repos" for Post API Call
Then API Method call successful with status code 201
And 		Verify Repository name is "API-Cucumber"
And 		Verify Repository description is "Cucumber RESTAssured"
And     EndingTestCase
##Examples: 	|	name					|	description	|
	##		 	|	API-Cucumber	|	Cucumber RESTAssured	|
	##				 	|	API-Cucumber1	|	Cucumber RESTAssured2|

					 	
Scenario Outline: Verify Delete Repo API
Given 	Starting Test Case "Verify Create Repo API"
Given 	Create Repo Payload name "API-Cucumber" and description "Cucumber RESTAssured"
When 		User Calls Delete API "/repos/parmarahul11/" for Post API Call
Then 		API Method call successful with status code 204
And     EndingTestCase

##Examples: 	|	name					|	description	|
	##				 	|	API-Cucumber	|	Cucumber RESTAssured	|
	##				 	|	API-Cucumber	|	Cucumber RESTAssured2	|
						
				