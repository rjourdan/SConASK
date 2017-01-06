package com.riverbed.sconask.test;

import java.io.IOException;

import com.riverbed.sconask.beans.SconNode;
import com.riverbed.sconask.beans.SconPort;
import com.riverbed.sconask.beans.SconSite;
import com.riverbed.sconask.rest.SconObjectCallApi;

public class DemoUNICC {

	public DemoUNICC() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
			 String url = "https://riverbed-se03.riverbed.cc";
			 String orgId = "org-Orgrvbd018-1f5a460fb82f09a9";
			 String nodeId = "node-581ba7a75e3a1833";
			 String zoneId = "segment-LAN-21fc2569de805fda";
			 
			 SconNode node;
			 //look for the node
			 node = (SconNode) SconObjectCallApi.findSconObject(url, SconObjectCallApi.NODE, nodeId);
			 System.out.println("node "+node);
			 if(node==null){
				 System.out.println("Object "+nodeId+" not found");
			 }
			 else{
				 
			 String[] ports = node.getPorts();
			 for(int i=0;i < ports.length;i++){
				 System.out.println("ports "+ports[i]+"\n");
				 SconPort port = (SconPort) SconObjectCallApi.findSconObject(url, SconObjectCallApi.PORT, ports[i]);
				 port.setSegment(zoneId);
				 try {
						port = (SconPort) SconObjectCallApi.updateSconObject(url,orgId, port);
						
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	 
			 }
			  
		 }
	}

}
