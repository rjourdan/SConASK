package com.riverbed.sconask.beans;

public class SconAP extends SconNode {

	public SconAP(String name, String model, String simulated, String site,String serial) {
		super(name, model, simulated, site,serial);
		// TODO Auto-generated constructor stub
	}

	public SconAP(String id, String[] uplinks, String model, String simulated, String[] ports, String site) {
		super(id, uplinks, model, simulated, ports, site);
		// TODO Auto-generated constructor stub
	}

	public SconAP(String id, String[] uplinks, String localAS, String model, String[] radios, String simulated,
			String routerId, String disableStp, String location, String serial, String license,
			String inventoryVersionCC, String[] ports, String site, String sitelink) {
		super(id, uplinks, localAS, model, radios, simulated, routerId, disableStp, location, serial, license,
				inventoryVersionCC, ports, site, sitelink);
		// TODO Auto-generated constructor stub
	}

}
