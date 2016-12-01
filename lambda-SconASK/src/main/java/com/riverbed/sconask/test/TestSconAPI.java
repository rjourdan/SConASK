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

import com.riverbed.sconask.beans.SconBroadcast;
import com.riverbed.sconask.beans.SconNode;
import com.riverbed.sconask.beans.SconObject;
import com.riverbed.sconask.beans.SconSite;
import com.riverbed.sconask.beans.SconSsid;
import com.riverbed.sconask.beans.SconZone;
import com.riverbed.sconask.rest.SconJsonOperations;
import com.riverbed.sconask.rest.SconObjectCallApi;


public class TestSconAPI {
	    
	/*  
	  
	public static void main(String[] args){
		 String url = "https://riverbed-se03.riverbed.cc";
		 String orgId = "org-Orgrvbd018-1f5a460fb82f09a9";
		SconSite site = new SconSite("boutik_Miami","Miami","","Miami","US");
		SconSite site2 = new SconSite("branch_SF","San Francisco","","San Francisco","US");
	try {
		site = (SconSite) SconObjectCallApi.createSconObject(url,orgId, site);
		SconObjectCallApi.applySiteTemplate(url, orgId, site, SconSite.BOUTIQUE);
		site2 = (SconSite) SconObjectCallApi.createSconObject(url,orgId, site2);
		SconObjectCallApi.applySiteTemplate(url, orgId, site2, SconSite.BRANCH);
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//SconObjectCallApi.cleanOrg(url, orgId);
		 
	}
*/

	

	
	public static void main(String[] args){
		 String url = "https://riverbed-se03.riverbed.cc";
		 String orgId = "org-Orgrvbd018-1f5a460fb82f09a9";
		List<SconObject> list = SconObjectCallApi.listSconObjects(url, orgId, SconObjectCallApi.NODE);
		 Iterator<SconObject> it = list.iterator();
		 while(it.hasNext()){
			 SconNode node = (SconNode)it.next();
			 System.out.println(node+"\n");
		 }
		 list = SconObjectCallApi.listSconObjects(url, orgId, SconObjectCallApi.ZONE);
		  it = list.iterator();
		 while(it.hasNext()){
			 SconZone zone = (SconZone)it.next();
			 System.out.println(zone+"\n");
		 }
		 SconZone zone = new SconZone("printer", "0", "site-NCY-d04a93c2d8c4739b");
		//SconNode node = new SconNode("switch", SconNode.SDI_S48, "0", "site-NCY-d04a93c2d8c4739b");
	try {
		SconObjectCallApi.createSconObject(url,orgId, zone);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	/* public static void main(String[] args){
		 //String url = "https://riverbed-se03.riverbed.cc/api/scm.config/1.0/org/org-Orgrvbd018-1f5a460fb82f09a9/switches";
		 
		//String url = "https://riverbed-se03.riverbed.cc/api/scm.config/1.0/org/org-trial8932sqYz-2b49018d23d6c2f0/sites";
		 /*JsonObject json= Json.createObjectBuilder()
				 .add("site","site-NCY-6eed898e5125f74a")
				 .add("serial",JsonValue.NULL)
				 .add("model", SconNode.SDI_330)
				.add("simulated", "1")
				//.add("unlock",JsonValue.NULL)
					
					.add("license",JsonValue.NULL)
					.add("location",JsonValue.NULL)
					.add("router_id",JsonValue.NULL)
					.add("local_as","1")
					.add("realm","realm")
					.add("disable_stp",JsonValue.FALSE)
					.add("inventory_version_cc","2.2")
					.add("sitelink", "1")
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
		 String url = "https://riverbed-se03.riverbed.cc/api/scm.config/1.0/org/org-Orgrvbd018-1f5a460fb82f09a9/nodes";
		//String url = "https://riverbed-se03.riverbed.cc/api/scm.config/1.0/org/org-trial8932sqYz-2b49018d23d6c2f0/sites";
		 JsonObject json= Json.createObjectBuilder()
				 	.add("site",node.getSite())
					.add("model", node.getModel())
					.add("simulated", JsonValue.TRUE)
					.add("serial",JsonValue.NULL)
					.build();
	    			/*add("name", "NCY")
	    			.add("longname", "Annecy")
	    			//.add("org", "org-Orgrvbd018-1f5a460fb82f09a9")
	    			.add("street address","14 chemin de l'huilerie")
	    			.add("city", "Annecy")
	    			.add("country", "France")
	    			.add("timezone", "Europe/Paris")
	    			
	    	
			try {
				json = SconJsonOperations.PostData(url,json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(json!=null) System.out.println(json.toString());
	    	
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

