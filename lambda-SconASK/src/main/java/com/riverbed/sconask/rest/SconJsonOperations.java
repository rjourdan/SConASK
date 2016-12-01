package com.riverbed.sconask.rest;

import java.io.IOException;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.net.ssl.HttpsURLConnection;
;

public class SconJsonOperations {
	
	 
	 static class MyAuthenticator extends Authenticator {
	        public PasswordAuthentication getPasswordAuthentication() {
	        	String kuser = System.getenv("username");
	        	String kpass = System.getenv("password");
	            return (new PasswordAuthentication(kuser, kpass.toCharArray()));
	        }
	    }
	 
	 /**
	  * 
	  * @param link
	  * @param json
	  * @return
	  * @throws IOException
	  */
	 public static final JsonObject PostData (String link, JsonObject json) throws IOException{
	    	URL url = null;
	    	HttpsURLConnection conn = null;
			Authenticator.setDefault(new MyAuthenticator());
			try {
			url = new URL(link);
			
				conn = (HttpsURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setDoOutput(true);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.toString());
			}
			
			//write!!!!!!!!!!
			JsonWriter writer = Json.createWriter(conn.getOutputStream());
			writer.writeObject(json);
			writer.close();
			int status = conn.getResponseCode();
			System.out.println("status "+status+" json request:"+json.toString());
			JsonObject returnJson = Json.createReader(conn.getInputStream()).readObject();
	    	conn.disconnect();
	    	return returnJson;
	    }
	 
	   /**
	    *  
	    * @param link
	    * @return
	    * @throws IOException
	    */
	 public static final JsonObject GetData(String link) throws IOException{
	    	JsonObject json = null;
	    	URL url = null;
	    	int status;
	    	HttpsURLConnection conn = null;
			Authenticator.setDefault(new MyAuthenticator());
			try {
			url = new URL(link);
			
				conn = (HttpsURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				status = conn.getResponseCode();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				status = conn.getResponseCode();
				if (status==401) System.out.println("Authentication error");
				else System.out.println("HTTP Status code:"+status);
			}
			json = Json.createReader(conn.getInputStream()).readObject();
	    	conn.disconnect();
	    	return json;
	    }
	 
	 /**
	  * 
	  * @param link
	  * @return
	  * @throws IOException
	  */
	 static final JsonObject DeleteData(String link) throws IOException{
	    	JsonObject json = null;
	    	URL url = null;
	    	int status;
	    	HttpsURLConnection conn = null;
			Authenticator.setDefault(new MyAuthenticator());
			try {
			url = new URL(link);
			
				conn = (HttpsURLConnection) url.openConnection();
				conn.setRequestMethod("DELETE");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setDoOutput(true);
				status = conn.getResponseCode();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				status = conn.getResponseCode();
				if (status==401) System.out.println("Authentication error");
				else System.out.println("HTTP Status code:"+status);
			}
			json = Json.createReader(conn.getInputStream()).readObject();
	    	conn.disconnect();
	    	return json;
	    }
	 
	 /**
	  * 
	  * @param link
	  * @param json
	  * @return
	  * @throws IOException
	  */
	 public static final JsonObject PutData (String link, JsonObject json) throws IOException{
	    	URL url = null;
	    	HttpsURLConnection conn = null;
			Authenticator.setDefault(new MyAuthenticator());
			try {
			url = new URL(link);
			
				conn = (HttpsURLConnection) url.openConnection();
				conn.setRequestMethod("PUT");
				//conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setDoOutput(true);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.toString());
			}
			
			//write!!!!!!!!!!
			JsonWriter writer = Json.createWriter(conn.getOutputStream());
			writer.writeObject(json);
			writer.close();
			int status = conn.getResponseCode();
			System.out.println("status "+status);
			JsonObject returnJson = Json.createReader(conn.getInputStream()).readObject();
	    	conn.disconnect();
	    	return returnJson;
	    }
	    

}
