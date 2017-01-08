package com.riverbed.sconask.test;


import java.io.IOException;
import java.net.Authenticator;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;

import com.riverbed.sconask.beans.SconApp;
import com.riverbed.sconask.beans.SconBroadcast;
import com.riverbed.sconask.beans.SconNode;
import com.riverbed.sconask.beans.SconObject;
import com.riverbed.sconask.beans.SconPathRules;
import com.riverbed.sconask.beans.SconSite;
import com.riverbed.sconask.beans.SconSsid;
import com.riverbed.sconask.beans.SconSwitch;
import com.riverbed.sconask.beans.SconZone;
import com.riverbed.sconask.rest.SconAppAPI;
import com.riverbed.sconask.rest.SconJsonOperations;
import com.riverbed.sconask.rest.SconObjectCallApi;
import com.riverbed.sconask.util.StringModifier;


public class TestSconAPI {
	    
	public static void main(String[] args){
		String sfdc = "sales force";
		System.out.println("["+sfdc.substring(0, 6)+"]");
	}
	 
	  /*
	public static void main(String[] args){
		 String url = "https://riverbed-se03.riverbed.cc";
		 String orgId = "org-Orgrvbd018-1f5a460fb82f09a9";
		 String ruleId ="prule-e3ace585e539ee63";
		//SconSite site = new SconSite("388_Greenwich_Street","388 Greenwich Street","388 Greenwich Street","New York","United States");
		try {
			SconPathRules pathRule = (SconPathRules) SconObjectCallApi.findSconObject(url, "path_rule", ruleId);
			if(pathRule == null) System.out.println("not found?");
			pathRule.setActive(true);
			pathRule = (SconPathRules) SconObjectCallApi.updateSconObject(url,orgId, pathRule);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//SconObjectCallApi.cleanOrg(url, orgId);
		 
	}*/


	

	/*
	public static void main(String[] args){
		 String url = "https://riverbed-se03.riverbed.cc";
		 String orgId = "org-Orgrvbd018-1f5a460fb82f09a9";
		List<SconObject> list = SconObjectCallApi.listSconObjects(url, orgId, SconObjectCallApi.SWITCH);
		 Iterator<SconObject> it = list.iterator();
		 while(it.hasNext()){
			 SconSwitch switchs = (SconSwitch)it.next();
			 System.out.println("switch "+ switchs+"\n");
		 }
		 list = SconObjectCallApi.listSconObjects(url, orgId, SconObjectCallApi.SITE);
		  it = list.iterator();
		 while(it.hasNext()){
			 SconSite site = (SconSite)it.next();
			 System.out.println(site+"\n");
		 }
		 //SconZone zone = new SconZone("printer", "0", "site-NCY-d04a93c2d8c4739b");
		SconNode nodes = new SconNode("gw", SconNode.SDI_1030, "0", "site-plantMunich-6b00aec8a28c1855","");
	try {
		SconObjectCallApi.createSconObject(url,orgId, nodes);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}*/
	
	 /*public static void main(String[] args){
		 String url = "https://riverbed-se03.riverbed.cc/api/scm.config/1.0/org/org-Orgrvbd018-1f5a460fb82f09a9/node/register";
		 
		//String url = "https://riverbed-se03.riverbed.cc/api/scm.config/1.0/org/org-trial8932sqYz-2b49018d23d6c2f0/sites";
		 JsonObject json= Json.createObjectBuilder()
				 .add("site","plantecho-149e17a48e5e9876")
				 //.add("serial",JsonValue.NULL)
				 .add("model", SconNode.SDI_VGW)
				//.add("simulated", "0")
				//.add("unlock",JsonValue.NULL)
					
//					.add("license",JsonValue.NULL)
//					.add("location",JsonValue.NULL)
//					.add("router_id",JsonValue.NULL)
//					.add("local_as","1")
//					.add("realm","realm")
//					.add("disable_stp",JsonValue.FALSE)
//					.add("inventory_version_cc","2.2")
//					.add("sitelink", "1")
					//.add("org", "org-Orgrvbd018-1f5a460fb82f09a9")
	    			.build();
	    	
			try {
				json = SconJsonOperations.PostData(url,json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(json!=null) System.out.println(json.toString());
	}*/
	
	/*public static void main(String[] args){
		 String url = "https://riverbed-se03.riverbed.cc/api/scm.config/1.0/org/org-Orgrvbd018-1f5a460fb82f09a9/sites";
		//String url = "https://riverbed-se03.riverbed.cc/api/scm.config/1.0/org/org-trial8932sqYz-2b49018d23d6c2f0/sites";
		 JsonObject json= Json.createObjectBuilder()
	    			.add("name", "NYC")
	    			.add("longname", "New York")
	    			//.add("org", "org-Orgrvbd018-1f5a460fb82f09a9")
	    			.add("street_address","388 Greenwich St")
	    			.add("city", "New York")
	    			.add("country", "USA")
	    			.add("timezone", "Americas/Boston")
	    			.build();
	    			
	    	
			try {
				json = SconJsonOperations.PostData(url,json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(json!=null) System.out.println(json.toString());
	    	
			String test ="";
			System.out.println("resultat "+ test.isEmpty());
	    }*/
		
	 
	 /*public static void main(String[] args){
	    	String url = "https://riverbed-se03.riverbed.cc/api/scm.config/1.0/site/site-NCY-e49f24e61458443e";
	    	JsonObject json= null;
	    	
			try {
				json = TestSconAPI.DeleteData(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(json!=null) System.out.println(json.toString());
	    	
	    }
	 */
	/*public static void main(String[] args) throws IOException {
		URL url = null;
		int status = 0;
		HttpsURLConnection conn = null;
		Authenticator.setDefault(new MyAuthenticator());
		try {
		url = new URL("https://riverbed-se03.riverbed.cc/api/scm.config/1.0/org/org-Orgrvbd018-1f5a460fb82f09a9/sites");
		//url = new URL("https://riverbed-se03.riverbed.cc/api/scm.config/1.0/site/site-Prangins-46a2858abf236914");

			conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			//conn.setRequestProperty("Accept", "application/json"); //for everything but POST
			conn.setRequestProperty("Content-Type", "application/json");
			status = conn.getResponseCode();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			status = conn.getResponseCode();
		}
		if(status == 401){
			
		}
		try (InputStream is = url.openStream();
		JsonParser parser = Json.createParser(is)) {
		while (parser.hasNext()) {
		Event e = parser.next();
		if (e == Event.KEY_NAME) {
		switch (parser.getString()) {
		case "id":
		parser.next();
		System.out.print(">>>>>"+parser.getString()+"<<<<<");
		System.out.print(": ");
		break;
		case "country":
		parser.next();
		System.out.println(parser.getString());
		System.out.println("---------");
		break;
		}
		}
		}
		}
	}
	*/
	
}

