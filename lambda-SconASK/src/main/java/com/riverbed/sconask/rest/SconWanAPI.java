package com.riverbed.sconask.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

import com.riverbed.sconask.beans.SconObject;
import com.riverbed.sconask.beans.SconWan;
import com.riverbed.sconask.util.StringModifier;

public class SconWanAPI implements SconObjectAPI {

	public SconWanAPI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SconObject convertFromJson(JsonObject jsonObj) {
		SconObject sconObj = null;
		if(jsonObj==null) return null;
				
		JsonValue tempValue;
		String id = jsonObj.getString("id");
		id = StringModifier.removeBrackets(id);
		
		String name = jsonObj.getString("name");
		String[] uplinks = new String[0];
		if(!jsonObj.isNull("uplinks")) uplinks = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("uplinks"));
		
		String[] networks = new String[0];
		if(!jsonObj.isNull("nets"))
		 networks = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("nets"));
		
		String longName="";
		tempValue = jsonObj.get("longname");
		if(tempValue!=null) longName = tempValue.toString();
		
		String internet = "true";
		internet = jsonObj.get("internet").toString();
		
		String sitelink = "true";
		sitelink = jsonObj.get("sitelink").toString();
		
		String breakout = "true";
		breakout = jsonObj.get("breakout").toString();
		
		String[] breakout_sites = new String[0];
		if(!jsonObj.isNull("breakout_sites"))
			breakout_sites = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("breakout_sites"));
		
		sconObj = new SconWan(id, name, uplinks, networks, longName, internet, sitelink, breakout, breakout_sites);
		return sconObj;
	}

	@Override
	public JsonObject buildSconJsonObject(SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SconObject getByName(String baseUrl, String objectName,String orgID) {
		objectName = objectName.toLowerCase();
		//find the object on SteelConnect
		List<SconObject> sconObjectList = getAll(baseUrl, orgID);
		
		if(sconObjectList!=null){			
			SconObject obj=null;
			String tempName="";
			for (int i=0;i<sconObjectList.size();i++){
				obj = sconObjectList.get(i);
				
				if(obj!=null){
					tempName = obj.getName();
					tempName = tempName.toLowerCase();
					if(objectName.equals(tempName)) return obj;	
				}
			}
		}
		return null;
	}

	@Override
	public SconObject get(String baseUrl, String objId,String orgID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SconObject> getAll(String baseUrl, String orgID) {
List<SconObject> objectList = new ArrayList<SconObject>();
		
		String url = baseUrl + API_PREFIX +"org/"+orgID+"/wans";
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
	public SconObject create(String baseUrl, String orgID, SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SconObject update(String baseUrl, String orgID, SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SconObject delete(String baseUrl, String orgID, SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
