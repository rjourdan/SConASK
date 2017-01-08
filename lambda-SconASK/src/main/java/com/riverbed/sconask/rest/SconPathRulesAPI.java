package com.riverbed.sconask.rest;

import java.io.IOException;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import com.riverbed.sconask.beans.SconObject;
import com.riverbed.sconask.beans.SconPathRules;
import com.riverbed.sconask.util.StringModifier;

public class SconPathRulesAPI implements SconObjectAPI {

	public SconPathRulesAPI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SconObject convertFromJson(JsonObject jsonObj) {
		SconObject sconObj = null;
		if(jsonObj==null) return null;
				
		JsonValue tempValue;
		String id = jsonObj.getString("id");
		id = StringModifier.removeBrackets(id);
		
		String uid = jsonObj.getString("uid");
		
		String dsttype="";
		tempValue = jsonObj.get("dsttype");
		if(tempValue!=null) dsttype = tempValue.toString();
		
		String srctype="";
		tempValue = jsonObj.get("srctype");
		if(tempValue!=null) srctype = tempValue.toString();
		
		String qos="";
		tempValue = jsonObj.get("qos");
		if(tempValue!=null) qos = tempValue.toString();
		
		String marking="";
		tempValue = jsonObj.get("marking");
		if(tempValue!=null) marking = tempValue.toString();
		
		String[] zones = new String[0];
		if(!jsonObj.isNull("zones"))
		 zones = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("zones"));
		
		String[] sites = new String[0];
		if(!jsonObj.isNull("sites"))
		 sites = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("sites"));
		
		String[] path_preference = new String[0];
		if(!jsonObj.isNull("path_preference"))
			path_preference = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("path_preference"));
		
		boolean active = false;
		String activeString = jsonObj.get("active").toString();
		if(activeString.equals("1")) active = true;
		
		String dscp="";
		tempValue = jsonObj.get("dcsp");
		if(tempValue!=null) dscp = tempValue.toString();
		
		String[] apps = new String[0];
		if(!jsonObj.isNull("apps"))
		 apps = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("apps"));
		
		String[] devices = new String[0];
		if(!jsonObj.isNull("devices"))
			devices = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("devices"));
		
		String tags="";
		tempValue = jsonObj.get("tags");
		if(tempValue!=null) tags = tempValue.toString();
		
		String[] users = new String[0];
		if(!jsonObj.isNull("users"))
			users = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("users"));

		String sapps="";
		tempValue = jsonObj.get("sapps");
		if(tempValue!=null) sapps = tempValue.toString();
		
		sconObj = new SconPathRules(id, dsttype, srctype, qos, marking, zones, uid, sites, path_preference, active, dscp, apps, devices, tags, users,sapps);
		return sconObj;
	}

	
	
	@Override
	public JsonObject buildSconJsonObject(SconObject obj) {
		JsonObject json = null;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		SconPathRules pathRule = (SconPathRules) obj;
		
		JsonArrayBuilder zonesBuilder = Json.createArrayBuilder();
		if(pathRule.getZones()!=null){
			for (String zone : pathRule.getZones()){
				zonesBuilder.add(zone);
			}
		}
			
		JsonArrayBuilder sitesBuilder = Json.createArrayBuilder();
		if(pathRule.getSites()!=null){
			for (String site : pathRule.getSites()){
				if(site!=null) sitesBuilder.add(site);
			}
		}
		
		JsonArrayBuilder pathPreferenceBuilder = Json.createArrayBuilder();
		if(pathRule.getPath_preference()!=null){
			for (String path : pathRule.getPath_preference()){
				if(path!=null) pathPreferenceBuilder.add(path);
			}
		}
		
		JsonArrayBuilder appsBuilder = Json.createArrayBuilder();
		if(pathRule.getApps()!=null){
			for (String app : pathRule.getApps()){
				if(app!=null) appsBuilder.add(app);
			}
		}
		
		JsonArrayBuilder devicesBuilder = Json.createArrayBuilder();
		if(pathRule.getDevices()!=null){
			for (String device : pathRule.getDevices()){
				if(device!=null) devicesBuilder.add(device);
			}
		}
		
		JsonArrayBuilder usersBuilder = Json.createArrayBuilder();
		if(pathRule.getUsers()!=null){
			for (String user : pathRule.getUsers()){
				if(user!=null) usersBuilder.add(user);
			}
		}
		
		String active = "0";
		if(pathRule.isActive()) active = "1";
		
		jsonBuilder
		.add("path_preference", pathPreferenceBuilder)
		.add("dsttype",pathRule.getDsttype())
		.add("srctype", pathRule.getSrctype())
		.add("qos",pathRule.getQos())
		.add("marking", pathRule.getMarking())
		.add("zones", zonesBuilder)
		//.add("uid", pathRule.getUid())
		.add("active", active)
		.add("sites", sitesBuilder)
		.add("apps", appsBuilder)
		.add("dscp", pathRule.getDscp())
		.add("devices", devicesBuilder)
		.add("tags", pathRule.getTags())
		.add("sapps", pathRule.getSapps())
		.add("users", usersBuilder);
		
		json = jsonBuilder.build();
		
		return json;
	}

	
	
	@Override
	public SconObject get(String baseUrl, String objId,String orgID) {
		SconObject result = null;
		String url = baseUrl + API_PREFIX+"path_rule/"+objId;
		
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
	public SconObject create(String baseUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		
		JsonObject jsonObj = null;
		String link = baseUrl+API_PREFIX +"org/"+orgID+"/path_rules";
		
		jsonObj = buildSconJsonObject(obj);
		try {
			jsonObj = SconJsonOperations.PostData(link, jsonObj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("jsonObj "+jsonObj.toString()+"\n");
		JsonValue tempValue = jsonObj.get("id");
		
		if(tempValue!=null){
			String id = StringModifier.removeBrackets(tempValue.toString());
			obj.setId(id);
		}                   
		else return null;
		
		return obj;
	}

	
	
	@Override
	public SconObject update(String baseUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		JsonObject jsonObj = null;
		String link = baseUrl+API_PREFIX+"path_rule/"+obj.getId();
		
		jsonObj = buildSconJsonObject(obj);
		
		try {
			jsonObj = SconJsonOperations.PutData(link, jsonObj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("put jsonObj "+jsonObj.toString()+"\n");
		JsonValue tempValue = jsonObj.get("id");
		if(tempValue!=null){
			String id = StringModifier.removeBrackets(tempValue.toString());
			obj.setId(id);
		}
		                   
		else return null;
		
		return obj;
	}

	@Override
	public SconObject delete(String baseUrl, String orgID, SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SconObject getByName(String baseUrl, String objectName,String orgID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SconObject> getAll(String baseUrl, String orgID) {
		// TODO Auto-generated method stub
		return null;
	}

}
