package com.riverbed.sconask.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import com.riverbed.sconask.beans.SconApp;
import com.riverbed.sconask.beans.SconObject;
import com.riverbed.sconask.util.StringModifier;

public class SconAppAPI implements SconObjectAPI {

	public SconAppAPI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SconObject convertFromJson(JsonObject jsonObj) {
		SconObject sconObj = null;
		if(jsonObj==null) return null;
				
		JsonValue tempValue;
		String id = jsonObj.getString("id");
		id = StringModifier.removeBrackets(id);
		
		String desc="";
		tempValue = jsonObj.get("desc");
		if(tempValue!=null) desc = tempValue.toString();
		
		String dgrp="";
		tempValue = jsonObj.get("dgrp");
		if(tempValue!=null) dgrp = tempValue.toString();
		
		String name="";
		tempValue = jsonObj.get("name");
		if(tempValue!=null) name = tempValue.toString();
		name = StringModifier.removeBrackets(name);
		
		sconObj = new SconApp(id, desc, dgrp,name);
		return sconObj;
	}

	@Override
	public JsonObject buildSconJsonObject(SconObject obj) {
		JsonObject json = null;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		SconApp app = (SconApp)obj;
		
		jsonBuilder
		.add("desc", app.getDesc())
		.add("dgrp", app.getDgrp());
		
		json = jsonBuilder.build();
		
		return json;
	}

	@Override
	public List<SconObject> getAll(String baseUrl, String orgID) {
		List<SconObject> objectList = new ArrayList<SconObject>();
		
		String url = baseUrl + API_PREFIX +"apps";
		JsonObject jsonObj = null;
		try {
			jsonObj = SconJsonOperations.GetData(url);
			if(jsonObj!=null){
				JsonArray array = jsonObj.getJsonArray("items");
				for(int i = 0 ; i < array.size() ; i++){
					objectList.add(convertFromJson(array.getJsonObject(i)));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return objectList;
	}

	@Override
	public SconObject get(String baseUrl, String objId,String orgID) {
		SconObject result = null;
		String url = baseUrl + API_PREFIX+"app/"+objId;
		
		JsonObject jsonObj = null;
		try {
			jsonObj = SconJsonOperations.GetData(url);
			if(jsonObj!=null){
				result = convertFromJson(jsonObj);
				System.out.println("result "+result);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public SconObject getByName(String baseUrl, String objectName,String orgID) {
		
		//find the object on SteelConnect
		List<SconObject> sconObjectList = getAll(baseUrl, null);
		System.out.println("appName=["+objectName+"]\n");
		//if objectName is sales force, change it to Salesforce
		if(objectName.substring(0, 6).equals("sales ")) objectName="Salesforce";
		
		if(sconObjectList!=null){			
			SconObject obj=null;;
			for (int i=0;i<sconObjectList.size();i++){
				obj = sconObjectList.get(i);
				
				if(obj!=null){
					
					if(objectName.equals(obj.getName())) return obj;	
				}
			}
		}
		return null;
	}

	@Override //SteelConnect does not support Apps creation only Custom_Apps
	public SconObject create(String baseUrl, String orgID, SconObject obj) {
		return null;
	}

	@Override //SteelConnect does not support Apps update only Custom_Apps
	public SconObject update(String baseUrl, String orgID, SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override //SteelConnect does not support Apps delete only Custom_Apps
	public SconObject delete(String baseUrl, String orgID, SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
