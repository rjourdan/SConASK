package com.riverbed.sconask.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

import com.riverbed.sconask.beans.SconAP;
import com.riverbed.sconask.beans.SconBroadcast;
import com.riverbed.sconask.beans.SconNetwork;
import com.riverbed.sconask.beans.SconNode;
import com.riverbed.sconask.beans.SconObject;
import com.riverbed.sconask.beans.SconPort;
import com.riverbed.sconask.beans.SconSite;
import com.riverbed.sconask.beans.SconSsid;
import com.riverbed.sconask.beans.SconSwitch;
import com.riverbed.sconask.beans.SconUplink;
import com.riverbed.sconask.beans.SconWan;
import com.riverbed.sconask.beans.SconZone;
import com.riverbed.sconask.util.StringModifier;

public class SconObjectCallApi {
	
	public static final String BROADCAST = "broadcast";
	public static final String NETWORK = "network";
	public static final String NODE = "node";
	public static final String PORT = "port";
	public static final String SITE = "site";
	public static final String SSID = "ssid";
	public static final String UPLINK = "uplink";
	public static final String WAN = "wan";
	public static final String ZONE = "zone";
	public static final String SWITCH = "switch";
	public static final String ACCESSPOINT = "ap";
	
	//it is used to build the URL and concatenated with baseUrl. To be modified when new API are released. 
	private static final String API_PREFIX = "/api/scm.config/1.0/org/";
	
	public static String[] jsonArrayToStringArray(JsonArray array){
		String[] returnArray = new String[array.size()];
		for(int i= 0;i<array.size();i++){
			returnArray[i] = array.getJsonString(i).getString();
		}
		return returnArray;
	}
	
	/**
	 * 
	 * @param jsonObj
	 * @param type
	 * @return
	 */
	public static SconObject convertFromJson (JsonObject jsonObj,String type){
		SconObject sconObj = null;
		if(jsonObj!=null){
			//System.out.println(jsonObj.toString()+"\n");
			JsonValue tempValue;
			String id = jsonObj.getString("id");
			id = StringModifier.removeBrackets(id);
			
			if(type.equals(BROADCAST)){
				String site = jsonObj.getString("site");
				String zone = jsonObj.getString("zone");
				String ssid = jsonObj.getString("ssid");
				sconObj = new SconBroadcast(id,site, zone, ssid);
			}
			
			if(type.equals(NETWORK)){
				
			}
			
			if(type.equals(NODE)){
				
				String site = jsonObj.getString("site");
				
				String localAs = "";
				tempValue = jsonObj.get("local_as");
				if(!jsonObj.isNull("local_as")) localAs = jsonObj.getString("local_as");
				
				String model = jsonObj.getString("model");
				
				String simulated = "0";
				tempValue = jsonObj.get("simulated");
				if(!jsonObj.isNull("simulated")) simulated = jsonObj.getString("simulated");
				
				String routerId = null;
				tempValue = jsonObj.get("router_id");
				if(!jsonObj.isNull("router_id")) routerId = jsonObj.getString("router_id");
				
				String disableStp = "0";
				tempValue = jsonObj.get("disable_stp");
				if(!jsonObj.isNull("serial")) disableStp = jsonObj.getString("disable_stp");
				
				String[] uplinks = new String[0];
				if(!jsonObj.isNull("uplinks")) uplinks = jsonArrayToStringArray(jsonObj.getJsonArray("uplinks"));
				
				String[] radios = new String[0];
				if(!jsonObj.isNull("radios")) radios = jsonArrayToStringArray(jsonObj.getJsonArray("radios"));
				
				String location = "";
				tempValue = jsonObj.get("location");
				if(!jsonObj.isNull("location")) location = jsonObj.getString("location");
				
				String serial = "";
				tempValue = jsonObj.get("serial");
				if(!jsonObj.isNull("serial")) serial = jsonObj.getString("serial");
				
				String license = "";
				tempValue = jsonObj.get("license");
				if(!jsonObj.isNull("license")) license = jsonObj.getString("license");

				String inventoryVersionCC = "";
				tempValue = jsonObj.get("inventory_version_cc");
				if(!jsonObj.isNull("inventory_version_cc")) inventoryVersionCC = jsonObj.getString("inventory_version_cc");
				
				String[] ports = new String[0];
				if(!jsonObj.isNull("ports")) ports = jsonArrayToStringArray(jsonObj.getJsonArray("ports"));
				
				String sitelink = "0";
				tempValue = jsonObj.get("sitelink");
				if(!jsonObj.isNull("sitelink")) sitelink = jsonObj.getString("sitelink");
				
				sconObj = new SconNode (id, uplinks, localAs, model, radios, simulated, routerId, disableStp, location, serial, license, inventoryVersionCC, ports, site, sitelink);
			}
			if(type.equals(ACCESSPOINT)){
				
				String site = jsonObj.getString("site");
				
				String localAs = "";
				tempValue = jsonObj.get("local_as");
				if(!jsonObj.isNull("local_as")) localAs = jsonObj.getString("local_as");
				
				String model = jsonObj.getString("model");
				
				String simulated = "0";
				tempValue = jsonObj.get("simulated");
				if(!jsonObj.isNull("simulated")) simulated = jsonObj.getString("simulated");
				
				String routerId = null;
				tempValue = jsonObj.get("router_id");
				if(!jsonObj.isNull("router_id")) routerId = jsonObj.getString("router_id");
				
				String disableStp = "0";
				tempValue = jsonObj.get("disable_stp");
				if(!jsonObj.isNull("serial")) disableStp = jsonObj.getString("disable_stp");
				
				String[] uplinks = new String[0];
				if(!jsonObj.isNull("uplinks")) uplinks = jsonArrayToStringArray(jsonObj.getJsonArray("uplinks"));
				
				String[] radios = new String[0];
				if(!jsonObj.isNull("radios")) radios = jsonArrayToStringArray(jsonObj.getJsonArray("radios"));
				
				String location = "";
				tempValue = jsonObj.get("location");
				if(!jsonObj.isNull("location")) location = jsonObj.getString("location");
				
				String serial = "";
				tempValue = jsonObj.get("serial");
				if(!jsonObj.isNull("serial")) serial = jsonObj.getString("serial");
				
				String license = "";
				tempValue = jsonObj.get("license");
				if(!jsonObj.isNull("license")) license = jsonObj.getString("license");

				String inventoryVersionCC = "";
				tempValue = jsonObj.get("inventory_version_cc");
				if(!jsonObj.isNull("inventory_version_cc")) inventoryVersionCC = jsonObj.getString("inventory_version_cc");
				
				String[] ports = new String[0];
				if(!jsonObj.isNull("ports")) ports = jsonArrayToStringArray(jsonObj.getJsonArray("ports"));
				
				String sitelink = "0";
				tempValue = jsonObj.get("sitelink");
				if(!jsonObj.isNull("sitelink")) sitelink = jsonObj.getString("sitelink");
				
				sconObj = new SconAP (id, uplinks, localAs, model, radios, simulated, routerId, disableStp, location, serial, license, inventoryVersionCC, ports, site, sitelink);
			}
				if(type.equals(SWITCH)){
					
					String site = jsonObj.getString("site");
					
					String localAs = "";
					tempValue = jsonObj.get("local_as");
					if(!jsonObj.isNull("local_as")) localAs = jsonObj.getString("local_as");
					
					String model = jsonObj.getString("model");
					
					String simulated = "0";
					tempValue = jsonObj.get("simulated");
					if(!jsonObj.isNull("simulated")) simulated = jsonObj.getString("simulated");
					
					String routerId = null;
					tempValue = jsonObj.get("router_id");
					if(!jsonObj.isNull("router_id")) routerId = jsonObj.getString("router_id");
					
					String disableStp = "0";
					tempValue = jsonObj.get("disable_stp");
					if(!jsonObj.isNull("serial")) disableStp = jsonObj.getString("disable_stp");
					
					String[] uplinks = new String[0];
					if(!jsonObj.isNull("uplinks")) uplinks = jsonArrayToStringArray(jsonObj.getJsonArray("uplinks"));
					
					String[] radios = new String[0];
					if(!jsonObj.isNull("radios")) radios = jsonArrayToStringArray(jsonObj.getJsonArray("radios"));
					
					String location = "";
					tempValue = jsonObj.get("location");
					if(!jsonObj.isNull("location")) location = jsonObj.getString("location");
					
					String serial = "";
					tempValue = jsonObj.get("serial");
					if(!jsonObj.isNull("serial")) serial = jsonObj.getString("serial");
					
					String license = "";
					tempValue = jsonObj.get("license");
					if(!jsonObj.isNull("license")) license = jsonObj.getString("license");
				
					String inventoryVersionCC = "";
					tempValue = jsonObj.get("inventory_version_cc");
					if(!jsonObj.isNull("inventory_version_cc")) inventoryVersionCC = jsonObj.getString("inventory_version_cc");
					
					String[] ports = new String[0];
					if(!jsonObj.isNull("ports")) ports = jsonArrayToStringArray(jsonObj.getJsonArray("ports"));
					
					String sitelink = "0";
					tempValue = jsonObj.get("sitelink");
					if(!jsonObj.isNull("sitelink")) sitelink = jsonObj.getString("sitelink");
					
					sconObj = new SconSwitch (id, uplinks, localAs, model, radios, simulated, routerId, disableStp, location, serial, license, inventoryVersionCC, ports, site, sitelink);
				}
			if(type.equals(PORT)){
				
			}
			
			if(type.equals(SITE)){
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
				if(!jsonObj.isNull("uplinks")) uplinks = jsonArrayToStringArray(jsonObj.getJsonArray("uplinks"));
				String timezone = jsonObj.getString("timezone");
				String[] networks = new String[0];
				if(!jsonObj.isNull("networks"))
				 networks = jsonArrayToStringArray(jsonObj.getJsonArray("networks"));
				int size = 0;
				if(!jsonObj.isNull("size")) size = Integer.parseInt(jsonObj.getString("size"));
				sconObj = new SconSite(id, name, longName, address, city, countryCode, uplinks, timezone, networks, size);
			}
			
			if(type.equals(SSID)){
				String ssid = jsonObj.getString("ssid");
				String security = jsonObj.getString("security");
				String key="";
				tempValue = jsonObj.get("key");
				if(tempValue!=null) key = tempValue.toString();
			
				sconObj = new SconSsid(id,ssid, security, key);
			}
			
			if(type.equals(UPLINK)){
				String name = jsonObj.getString("name");
				
				int qos_bw_up = 0;
				tempValue = jsonObj.get("qos_bw_up");
				
				if(tempValue!=null) qos_bw_up = Integer.parseInt(tempValue.toString().substring(1, tempValue.toString().length()-1));
				
				int qos_up= 0;
				tempValue = jsonObj.get("qos_up");
				if(tempValue!=null) qos_up = Integer.parseInt(tempValue.toString().substring(1, tempValue.toString().length()-1));
				
				int qos_bw_down= 0;
				tempValue = jsonObj.get("qos_bw_down");
				if(tempValue!=null) qos_bw_down = Integer.parseInt(tempValue.toString().substring(1, tempValue.toString().length()-1));
				
				int qos_down= 0;
				tempValue = jsonObj.get("qos_down");
				if(tempValue!=null) qos_down = Integer.parseInt(tempValue.toString().substring(1, tempValue.toString().length()-1));
				
				
				String site = jsonObj.getString("site");
				
				String static_gw_v6="";
				tempValue = jsonObj.get("static_gw_v6");
				if(tempValue!=null) static_gw_v6 = tempValue.toString();
				
				String static_ip_v6="";
				tempValue = jsonObj.get("static_ip_v6");
				if(tempValue!=null) static_ip_v6 = tempValue.toString();
				
				String static_gw_v4="";
				tempValue = jsonObj.get("static_gw_v4");
				if(tempValue!=null) static_gw_v4 = tempValue.toString();
				
				String static_ip_v4="";
				tempValue = jsonObj.get("static_ip_v4");
				if(tempValue!=null) static_ip_v4 = tempValue.toString();
				
				String node ="";
				tempValue = jsonObj.get("node");
				if(tempValue!=null) node = tempValue.toString();
				
				String wan = "";
				tempValue = jsonObj.get("wan");
				if(tempValue!=null) wan = tempValue.toString();

				String port="";
				tempValue = jsonObj.get("port");
				if(tempValue!=null) port = tempValue.toString();
				
				int vlan=0;
				tempValue = jsonObj.get("vlan");
				if(!jsonObj.isNull("vlan")) vlan = Integer.parseInt(tempValue.toString());
				
				String uplinkType = "";
				uplinkType = jsonObj.get("type").toString();
				
				sconObj = new SconUplink(id, name, qos_bw_up, qos_up, qos_bw_down, qos_down, site, static_gw_v6, static_ip_v6, static_gw_v4, static_ip_v4, node, wan, port, vlan, uplinkType);
			}
			
			if(type.equals(WAN)){
				String name = jsonObj.getString("name");
				String[] uplinks = new String[0];
				if(!jsonObj.isNull("uplinks")) uplinks = jsonArrayToStringArray(jsonObj.getJsonArray("uplinks"));
				
				String[] networks = new String[0];
				if(!jsonObj.isNull("nets"))
				 networks = jsonArrayToStringArray(jsonObj.getJsonArray("nets"));
				
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
					breakout_sites = jsonArrayToStringArray(jsonObj.getJsonArray("breakout_sites"));
				
				sconObj = new SconWan(id, name, uplinks, networks, longName, internet, sitelink, breakout, breakout_sites);
			}
			
			if(type.equals(ZONE)){
				String name = jsonObj.getString("name");
				String siteID = jsonObj.getString("site");
				
				String[] networks = new String[0];
				if(!jsonObj.isNull("networks"))
				 networks = jsonArrayToStringArray(jsonObj.getJsonArray("networks"));
				
				String mgmt="";
				tempValue = jsonObj.get("mgmt");
				if(tempValue!=null) mgmt = tempValue.toString();
				
				String icmp="";
				tempValue = jsonObj.get("icmp");
				if(tempValue!=null) icmp = tempValue.toString();
				
				String guest="";
				tempValue = jsonObj.get("guest");
				if(tempValue!=null) guest = tempValue.toString();
				
				String[] breakoutPreference = new String[0];
				if(!jsonObj.isNull("breakout_preference"))
					breakoutPreference = jsonArrayToStringArray(jsonObj.getJsonArray("breakout_preference"));
				
				String[] routes = new String[0];
				if(!jsonObj.isNull("routes"))
				 routes = jsonArrayToStringArray(jsonObj.getJsonArray("routes"));
				
				String[] bcasts = new String[0];
				if(!jsonObj.isNull("bcasts"))
					bcasts = jsonArrayToStringArray(jsonObj.getJsonArray("bcasts"));
				
				String tag="";
				tempValue = jsonObj.get("tag");
				if(tempValue!=null) tag = tempValue.toString();
				
				String tags="";
				tempValue = jsonObj.get("tags");
				if(tempValue!=null) tags = tempValue.toString();
				
				
				sconObj = new SconZone(id, name, siteID, networks, mgmt, icmp, guest, breakoutPreference, routes, bcasts, tag, tags);
			}
			
		}
		return sconObj;
	}
	
	/**
	 * Create a array of SteelConnect objects text descriptions from SCM
	 @param baseUrl SCM base URL where the organization is defined, ex: https://riverbed-se03.riverbed.cc
	 * @param orgID ID of the organization to work with
	 * @param type SteelConnect objects type as defined in the static final variable (SconObjectCallApi.BROADCAST, SconObjectCallApi.NODES...
	 * @return a String array with the text description of SteelConnect objects from the list 
	 */
	public static String[] listSconObjectsText (String baseUrl,String orgID,String type) {
		
		List<SconObject> sconObjectList = listSconObjects(baseUrl, orgID, type);
		
		String[] textList = null;
		
		if(sconObjectList!=null){
			textList = new String[sconObjectList.size()];
			Iterator<SconObject> it = sconObjectList.iterator();
			SconObject obj = null;
			int i=0;
			while(it.hasNext()){
				obj = it.next();
				if(obj instanceof SconSite){
					textList[i] = ((SconSite)obj).toStringAlexa();
				}
				i++;
			}	
		}
		
		return textList;
	}
	
	/**
	 * Find a SteelConnect object based on its type and ID
	 * @param baseUrl
	 * @param orgID
	 * @param type
	 * @param objID
	 * @return
	 */
	public static SconObject findObject(String baseUrl,String orgID,String type,String objID){
		SconObject result = null;
		
		//find the object on SteelConnect
		List<SconObject> sconObjectList = listSconObjects(baseUrl, orgID, type);
		
		if(sconObjectList!=null){
			
			Iterator<SconObject> it = sconObjectList.iterator();
			
			while(it.hasNext()){
				result = it.next();
				if(result.getId().equals(objID)) return result; 
			}	
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param baseUrl SCM base URL where the organization is defined, ex: https://riverbed-se03.riverbed.cc
	 * @param orgID ID of the organization to work with
	 * @param sourceType SteelConnect objects type as defined in the static final variable (SconObjectCallApi.BROADCAST, SconObjectCallApi.NODES...) where to find the id of the target objects
	 * @param objectsType SteelConnect objects type as defined in the static final variable (SconObjectCallApi.BROADCAST, SconObjectCallApi.NODES...) we want to find
	 * @param objID
	 * @return
	 */
	public static List<SconObject> findObjects(String baseUrl,String orgID,String sourceType, String objectsType, String objID){
		List<SconObject> results = null;
		
		//find the object on SteelConnect
		List<SconObject> sconObjectList = listSconObjects(baseUrl, orgID, objectsType);
		
		if(sconObjectList!=null){
			results = new ArrayList<>();
			
			
			for(int i=0;i < sconObjectList.size();i++){
				if(objectsType.equals(SconObjectCallApi.ZONE)){
	
					SconZone zone = (SconZone)sconObjectList.get(i);
					
					if(zone != null && sourceType == SconObjectCallApi.SITE){
						
						if((zone.getSiteID()).equals(objID))  {
							System.out.println(results.add(zone));
						}
					}
				}
			}	
		}
		
		return results;
	}
	
	/**
	 * Return a list of SteelConnect objects from the organization orgID
	 * @param baseUrl SCM base URL where the organization is defined, ex: https://riverbed-se03.riverbed.cc
	 * @param orgID ID of the organization to work with
	 * @param type SteelConnect objects type as defined in the static final variable (SconObjectCallApi.BROADCAST, SconObjectCallApi.NODES...)
	 * @return an Array List containing all requested SteelConnect objects or null if none
	 */
	public static List<SconObject> listSconObjects (String baseUrl,String orgID,String type){
		List<SconObject> objectList = new ArrayList<SconObject>();
		String types = "";
		if(type==SconObjectCallApi.SWITCH) types="/"+type+"es";
		else if(type==SconObjectCallApi.ACCESSPOINT) types="/"+type;
		else types = "/"+type+"s";
		String url = baseUrl + API_PREFIX +orgID+types;
		JsonObject jsonObj = null;
		try {
			jsonObj = SconJsonOperations.GetData(url);
			if(jsonObj!=null){
				JsonArray array = jsonObj.getJsonArray("items");
				for(int i = 0 ; i < array.size() ; i++){
					objectList.add(convertFromJson(array.getJsonObject(i),type));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return objectList;
	}
	
	/**
	 * Create the object in SteelConnect organization
	 * @param baseUrl SCM base URL where the organization is defined, ex: https://riverbed-se03.riverbed.cc
	 * @param orgID ID of the organization to work with
	 * @param obj the SteelConnect object to create
	 * @return True if object is successfully created on SteelConnect or false in case of error
	 * @throws IOException 
	 */
	public static SconObject createSconObject (String baseUrl,String orgID,SconObject obj) throws IOException{
		if(obj==null) return null;
		JsonObject jsonObj = null;
		String link = baseUrl+API_PREFIX+orgID;
		//if it is a site, create a new site on steelconnect
		if(obj instanceof SconSite){
			link = link.concat("/sites");
		}
		
		if(obj instanceof SconUplink){
			link = link.concat("/uplinks");			
		}
		if(obj instanceof SconWan){
			link = link.concat("/wans");			
		}
		if(obj instanceof SconNode){
			link = link.concat("/nodes");			
		}
		if(obj instanceof SconSwitch){
			link = link.concat("/switches");			
		}
		if(obj instanceof SconZone){
			link = link.concat("/zones");			
		}
		if(obj instanceof SconPort){
			link = link.concat("/ports");			
		}
		if(obj instanceof SconNetwork){
			link = link.concat("/networks");			
		}
		if(obj instanceof SconBroadcast){
			link = link.concat("/broadcasts");			
		}
		if(obj instanceof SconSsid){
			link = link.concat("/ssids");			
		}
		jsonObj = SconJsonObjectBuilder.buildSconJsonObject(obj);
		jsonObj = SconJsonOperations.PostData(link, jsonObj);		
		System.out.println("jsonObj "+jsonObj.toString()+"\n");
		JsonValue tempValue = jsonObj.get("id");
		if(tempValue!=null){
			String id = StringModifier.removeBrackets(tempValue.toString());
			obj.setId(id);
		}
		                   
		else return null;
		
		return obj;
	}
	
	public static boolean cleanSconObject(String url,List<SconObject> objectList){
		
		
		for(int i=0;i<objectList.size();i++){
			SconObject obj =(SconObject)objectList.get(i);
			if(obj==null) return false;
			String id = obj.getId();
			String link = url.concat(id);
			System.out.println("link "+link+"\n");
			try {
				SconJsonOperations.DeleteData(link);
			} catch (IOException e) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean cleanOrg(String baseUrl,String orgID){
		List<SconObject> objectList = listSconObjects (baseUrl,orgID,SconObjectCallApi.BROADCAST);
		String url = baseUrl.concat("/api/scm.config/1.0/broadcast/");
		cleanSconObject(url,objectList);
		
		objectList = listSconObjects (baseUrl,orgID,SconObjectCallApi.SSID);
		url = baseUrl.concat("/api/scm.config/1.0/ssid/");
		cleanSconObject(url,objectList);
		
		objectList = listSconObjects (baseUrl,orgID,SconObjectCallApi.ZONE);
		url = baseUrl.concat("/api/scm.config/1.0/zone/");
		cleanSconObject(url,objectList);
		
		objectList = listSconObjects (baseUrl,orgID,SconObjectCallApi.UPLINK);
		url = baseUrl.concat("/api/scm.config/1.0/uplink/");
		cleanSconObject(url,objectList);
		
		
		objectList = listSconObjects (baseUrl,orgID,SconObjectCallApi.WAN);
		//keep internet & RouteVPN
		if(objectList!= null){
			for(int i=0;i<objectList.size();i++){
				SconWan wan = (SconWan) objectList.get(i);
				if(((wan.getName()).equals("Internet") || (wan.getName()).equals("RouteVPN"))) objectList.remove(i);
			}
		}
		url = baseUrl.concat("/api/scm.config/1.0/wan/");
		cleanSconObject(url,objectList);
		
		objectList = listSconObjects (baseUrl,orgID,SconObjectCallApi.NODE);
		url = baseUrl.concat("/api/scm.config/1.0/node/");
		cleanSconObject(url,objectList);
		
		objectList = listSconObjects (baseUrl,orgID,SconObjectCallApi.SITE);
		url = baseUrl.concat("/api/scm.config/1.0/site/");
		cleanSconObject(url,objectList);
		
		return true;
	}
	
	/**
	 * 
	 * @param baseUrl
	 * @param orgID
	 * @param siteID
	 * @param siteType
	 * @return
	 */
	public static boolean applySiteTemplate(String baseUrl,String orgID,SconSite site,String siteType){
		
		String LanID ="";
		String siteID = site.getId();
		boolean isCorpSSID= false;
		boolean isGuestSSID= false;
		
		//it there are only two WANS, create WANs: MPLS, LTE; internet & RouteVPN exist by default
		
		SconWan wanMpls = null;
		SconWan wanLte = null;
		List<SconObject> wans = listSconObjects(baseUrl,orgID,SconObjectCallApi.WAN);
		System.out.println("WAN size "+wans.size());
		if(wans.size()<3){
			try {
				wanMpls = new SconWan("MPLS", "MPLS", "0");
				wanMpls = (SconWan) createSconObject(baseUrl, orgID, wanMpls);
				
				wanLte = new SconWan("LTE", "4G", "1");
				wanLte = (SconWan) createSconObject(baseUrl, orgID, wanLte);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else{
			Iterator<SconObject> it = wans.iterator();
			while(it.hasNext()){
				SconWan tempWan = (SconWan) it.next();
				if(tempWan.getName().equals("MPLS")) wanMpls = tempWan;
				if(tempWan.getName().equals("LTE")) wanLte = tempWan;
			}
		}
		///Check whether SSIDs were created or not
		SconSsid corpSsid=null;
		SconSsid guestSsid=null;
		List<SconObject> wifis = listSconObjects(baseUrl,orgID,SconObjectCallApi.SSID);
		if(!wifis.isEmpty()){
			Iterator<SconObject> it = wifis.iterator();
			while(it.hasNext()){
				SconSsid tempSsid = (SconSsid) it.next();
				if(tempSsid.getSsid().equals("CorporateWiFi")) {
					isCorpSSID = true;
					corpSsid = tempSsid;
				}
				if(tempSsid.getSsid().equals("Guest")) {
					isGuestSSID = true;
					guestSsid = tempSsid;
				}
			}
		}
		
		//identify site's LAN zone, since the site has just been created, there is only one zone
		LanID = (getSiteZones(siteID, baseUrl, orgID))[0] ;
		
		if(siteType.equals(SconSite.BRANCH)){
			try {
						
				//create Zones 
				SconZone printers = new SconZone("Printers", "0", siteID);
				createSconObject(baseUrl,orgID,printers);
				
				SconZone guests = new SconZone("LanGuest", "1", siteID);
				createSconObject(baseUrl,orgID,guests);
				
				SconZone toip = new SconZone("ToIP", "0", siteID);
				createSconObject(baseUrl,orgID,toip);
				
				//create uplinks, there is by default an internet connection
				SconUplink mpls = new SconUplink("MPLS", siteID, wanMpls.getId());
				createSconObject(baseUrl,orgID,mpls);
				SconUplink lte = new SconUplink("LTE", siteID, wanLte.getId());
				createSconObject(baseUrl,orgID,lte);
				
				if(!isCorpSSID){
					corpSsid = new SconSsid("CorporateWiFi", SconSsid.WPA2E, "1234567890");
					corpSsid = (SconSsid) createSconObject(baseUrl,orgID,corpSsid);
				}
				
				if(!isGuestSSID){
					guestSsid = new SconSsid("Guest", SconSsid.WPA2E, "1234567890");
					guestSsid = (SconSsid) createSconObject(baseUrl,orgID,guestSsid);
				}
				SconBroadcast bcCorp = new SconBroadcast(siteID, LanID , corpSsid.getId());
				createSconObject(baseUrl,orgID,bcCorp);
				
				SconBroadcast bcGuest = new SconBroadcast(siteID, LanID , guestSsid.getId());
				createSconObject(baseUrl,orgID,bcGuest);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(siteType==SconSite.PLANT){
			try {
				
				//create Zones 
				SconZone printers = new SconZone("Printers", "0", siteID);
				createSconObject(baseUrl,orgID,printers);
				
				SconZone prod = new SconZone("Production", "0", siteID);
				createSconObject(baseUrl,orgID,prod);
				
				SconZone toip = new SconZone("ToIP", "0", siteID);
				createSconObject(baseUrl,orgID,toip);
				
				//create uplinks, there is by default an internet connection
				SconUplink mpls1 = new SconUplink("MPLS1", siteID, wanMpls.getId());
				createSconObject(baseUrl,orgID,mpls1);
				SconUplink mpls2 = new SconUplink("MPLS2", siteID, wanMpls.getId());
				createSconObject(baseUrl,orgID,mpls2);
				
				if(!isCorpSSID){
					corpSsid = new SconSsid("CorporateWiFi", SconSsid.WPA2E, "1234567890");
					corpSsid = (SconSsid) createSconObject(baseUrl,orgID,corpSsid);
				}
				
				
				SconBroadcast bcCorp = new SconBroadcast(siteID, LanID , corpSsid.getId());
				createSconObject(baseUrl,orgID,bcCorp);
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//create 2 48 ports switches + 2 gateways sdi330
			try{
				SconSwitch switch48 = new SconSwitch("", SconNode.SDI_S48, "1", siteID);
				createSconObject(baseUrl,orgID,switch48);
			} catch (IOException e) {
			// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			try{
				SconSwitch switch48 = new SconSwitch("", SconNode.SDI_S48, "1", siteID);
				createSconObject(baseUrl,orgID,switch48);
			} catch (IOException e) {
			// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			try{
				SconSwitch sdi130 = new SconSwitch("", SconNode.SDI_130, "1", siteID);
				createSconObject(baseUrl,orgID,sdi130);
			} catch (IOException e) {
			// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			try{
				SconSwitch sdi130 = new SconSwitch("", SconNode.SDI_130, "1", siteID);
				createSconObject(baseUrl,orgID,sdi130);
			} catch (IOException e) {
			// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		
		if(siteType==SconSite.HQ){
			try {
				
				//create Zones 
				SconZone printers = new SconZone("Printers", "0", siteID);
				createSconObject(baseUrl,orgID,printers);
				
				SconZone guests = new SconZone("LanGuest", "1", siteID);
				guests = (SconZone) createSconObject(baseUrl,orgID,guests);
				
				SconZone toip = new SconZone("ToIP", "0", siteID);
				createSconObject(baseUrl,orgID,toip);
				
				//create uplinks, there is by default an internet connection
				SconUplink mpls = new SconUplink("MPLS", siteID, wanMpls.getId());
				createSconObject(baseUrl,orgID,mpls);
				SconUplink lte = new SconUplink("LTE", siteID, wanLte.getId());
				createSconObject(baseUrl,orgID,lte);
				
				if(!isCorpSSID){
					corpSsid = new SconSsid("CorporateWiFi", SconSsid.WPA2E, "1234567890");
					corpSsid = (SconSsid) createSconObject(baseUrl,orgID,corpSsid);
				}
				
				if(!isGuestSSID){
					guestSsid = new SconSsid("Guest", SconSsid.WPA2E, "1234567890");
					guestSsid = (SconSsid) createSconObject(baseUrl,orgID,guestSsid);
				}
				
				SconBroadcast bcCorp = new SconBroadcast(siteID, LanID , corpSsid.getId());
				createSconObject(baseUrl,orgID,bcCorp);
				
				SconBroadcast bcGuest = new SconBroadcast(siteID, guests.getId() , guestSsid.getId());
				createSconObject(baseUrl,orgID,bcGuest);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(siteType==SconSite.BOUTIQUE){
			try {
				
				//create Zones 
				SconZone guests = new SconZone("LanGuest", "1", siteID);
				guests = (SconZone) createSconObject(baseUrl,orgID,guests);
				
				SconZone pos = new SconZone("PointofSales", "0", siteID);
				createSconObject(baseUrl,orgID,pos);
				
				//create uplinks, there is by default an internet connection
				SconUplink lte = new SconUplink("LTE", siteID, wanLte.getId());
				createSconObject(baseUrl,orgID,lte);
				
				if(!isCorpSSID){
					corpSsid = new SconSsid("CorporateWiFi", SconSsid.WPA2E, "1234567890");
					corpSsid = (SconSsid) createSconObject(baseUrl,orgID,corpSsid);
				}
				
				if(!isGuestSSID){
					guestSsid = new SconSsid("Guest", SconSsid.WPA2E, "1234567890");
					guestSsid = (SconSsid) createSconObject(baseUrl,orgID,guestSsid);
				}
				
				SconBroadcast bcCorp = new SconBroadcast(siteID, LanID , corpSsid.getId());
				createSconObject(baseUrl,orgID,bcCorp);
				
				SconBroadcast bcGuest = new SconBroadcast(siteID, guests.getId() , guestSsid.getId());
				createSconObject(baseUrl,orgID,bcGuest);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(siteType==SconSite.SHOP){
			try {
				
				//create Zones 
				SconZone guests = new SconZone("LanGuest", "1", siteID);
				guests = (SconZone) createSconObject(baseUrl,orgID,guests);
				
				SconZone printers = new SconZone("Printers", "0", siteID);
				createSconObject(baseUrl,orgID,printers);
				
				SconZone toip = new SconZone("ToIP", "0", siteID);
				createSconObject(baseUrl,orgID,toip);
				
				if(!isGuestSSID){
					guestSsid = new SconSsid("Guest", SconSsid.WPA2E, "1234567890");
					guestSsid = (SconSsid) createSconObject(baseUrl,orgID,guestSsid);
				}
				
				SconBroadcast bcGuest = new SconBroadcast(siteID, guests.getId() , guestSsid.getId());
				createSconObject(baseUrl,orgID,bcGuest);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param siteID
	 * @param baseUrl
	 * @param orgID
	 * @return
	 */
	public static String[] getSiteZones(String siteID,String baseUrl,String orgID){
		String[] results = null;
		List<SconObject> zones = findObjects(baseUrl, orgID, SconObjectCallApi.SITE, SconObjectCallApi.ZONE, siteID);
		
		if(zones!=null){
			results = new String[zones.size()];
			
			for (int i=0;i<zones.size();i++){
				results[i] = zones.get(i).getId();
			}
		
		}
		return results;
	}

}
