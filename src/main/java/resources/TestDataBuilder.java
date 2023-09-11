package resources;

import POJOPayloads.createRepoPOJO;
import resources.Utility.RestFrameworkLogger;

public class TestDataBuilder {
	createRepoPOJO requestPayload= new createRepoPOJO();
	public createRepoPOJO createRepo(String name,String description)
	{
		requestPayload.setName(name);
		requestPayload.setDescription(description);
	//	RestFrameworkLogger.info("create RepoName Function - "+requestPayload.getName());
		return requestPayload;
		
	}
	
	public String getRepoName()
	{
	
		return requestPayload.getName();
	}
}
