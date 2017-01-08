package com.riverbed.sconask.rest;

import java.util.List;

import javax.json.JsonObject;

import com.riverbed.sconask.beans.SconObject;

public interface SconObjectAPI {
	
	//it is used to build the URL and concatenated with baseUrl. To be modified when new API are released. 
	public static final String API_PREFIX = "/api/scm.config/1.0/";
	
	public SconObject convertFromJson (JsonObject jsonObj);
	
	public JsonObject buildSconJsonObject(SconObject obj);
	
	public SconObject getByName(String baseUrl,String objectName,String orgID);
	
	public SconObject get(String baseUrl,String objId,String orgID);
	
	public List<SconObject> getAll(String baseUrl, String orgID);
	
	public SconObject create(String baseUrl,String orgID,SconObject obj);
	
	public SconObject update(String baseUrl,String orgID,SconObject obj);
	
	public SconObject delete(String baseUrl,String orgID,SconObject obj);

	

}
