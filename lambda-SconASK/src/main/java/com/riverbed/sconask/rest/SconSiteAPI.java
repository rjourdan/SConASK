package com.riverbed.sconask.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

import com.riverbed.sconask.beans.SconObject;
import com.riverbed.sconask.beans.SconSite;
import com.riverbed.sconask.util.StringModifier;

public class SconSiteAPI implements SconObjectAPI {

	public SconSiteAPI() {
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
		
		String longName="";
		tempValue = jsonObj.get("longname");
		if(tempValue!=null) longName = tempValue.toString();
		
		String address = "";
		tempValue = jsonObj.get("street_address");
		if(!jsonObj.isNull("street_address")) address = jsonObj.getString("street_address");
		String city = jsonObj.getString("city");
		String countryCode = jsonObj.getString("country");
		
		String[] uplinks = new String[0];
		if(!jsonObj.isNull("uplinks")) uplinks = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("uplinks"));
		
		String timezone = jsonObj.getString("timezone");
		
		String[] networks = new String[0];
		if(!jsonObj.isNull("networks"))
		 networks = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("networks"));
		
		int size = 0;
		if(!jsonObj.isNull("size")) size = Integer.parseInt(jsonObj.getString("size"));
		sconObj = new SconSite(id, name, longName, address, city, countryCode, uplinks, timezone, networks, size);
		return sconObj;
	}

	@Override
	public JsonObject buildSconJsonObject(SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SconObject getByName(String baseUrl, String objectName, String orgID) {
		System.out.println("sitename to be found:["+objectName+"]\n");
		//find the object on SteelConnect
		List<SconObject> sconObjectList = getAll(baseUrl, orgID);
		
		if(sconObjectList!=null){			
			SconObject obj=null;
			for (int i=0;i<sconObjectList.size();i++){
				obj = sconObjectList.get(i);
				
				if(obj!=null){
					System.out.println("sitename=["+obj.getName()+"]\n");
					if(objectName.equals(obj.getName())) return obj;	
				}
			}
		}
		return null;
	}

	@Override
	public SconObject get(String baseUrl, String objId, String orgID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SconObject> getAll(String baseUrl, String orgID) {
		List<SconObject> objectList = new ArrayList<SconObject>();
		
		String url = baseUrl + API_PREFIX +"org/"+orgID+"/sites";
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
