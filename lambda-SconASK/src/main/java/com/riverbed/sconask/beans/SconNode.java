package com.riverbed.sconask.beans;

import java.util.Arrays;

public class SconNode extends SconObject{
	
	 	public static final String SDI_VGW = "yogi"; 	
	 	public static final String SDI_AWS = "booboo";	
	 	public static final String SDI_SH = "baloo";		
	 	public static final String SDI_USB  = "fozzy"; 		
	 	public static final String SDI_AP3 = "raccoon"; 	
	 	public static final String SDI_AP5 = "koala";
	 	public static final String SDI_AP5r = "ursus";	
	 	public static final String SDI_130 = "panda"; 	
	 	public static final String SDI_330 = "ewok"; 	
	 	public static final String SDI_1030 = "grizzly"; 	
	 	public static final String SDI_S12 = "aardvark";
	 	public static final String SDI_S24 = "sloth";
	 	public static final String SDI_S48 = "kodiak";
	 	public static final String CX_570 = "cx570";
	 	public static final String CX_770 = "cx770";
	 	public static final String CX_3070 = "cx3070"; 		
	 	public static final String Tiger = "tiger"; 		
	 	public static final String SDI_5030 = "panther"; 

	 	private String[] uplinks;
	 	private String localAS;
	 	private String model;
	 	private String[] radios;
	 	private String simulated;
	 	private String routerId;
	 	private String disableStp;
	 	private String location;
	 	private String serial;
	 	private String license;
	 	private String inventoryVersionCC;
	 	private String[] ports;
	 	private String site;
	 	private String sitelink;
		/**
		 * @return the uplinks
		 */
		public String[] getUplinks() {
			return uplinks;
		}
		/**
		 * @param uplinks the uplinks to set
		 */
		public void setUplinks(String[] uplinks) {
			this.uplinks = uplinks;
		}
		/**
		 * @return the localAS
		 */
		public String getLocalAS() {
			return localAS;
		}
		/**
		 * @param localAS the localAS to set
		 */
		public void setLocalAS(String localAS) {
			this.localAS = localAS;
		}
		/**
		 * @return the model
		 */
		public String getModel() {
			return model;
		}
		/**
		 * @param model the model to set
		 */
		public void setModel(String model) {
			this.model = model;
		}
		/**
		 * @return the radios
		 */
		public String[] getRadios() {
			return radios;
		}
		/**
		 * @param radios the radios to set
		 */
		public void setRadios(String[] radios) {
			this.radios = radios;
		}
		/**
		 * @return the simulated
		 */
		public String getSimulated() {
			return simulated;
		}
		/**
		 * @param simulated the simulated to set
		 */
		public void setSimulated(String simulated) {
			this.simulated = simulated;
		}
		/**
		 * @return the routerId
		 */
		public String getRouterId() {
			return routerId;
		}
		/**
		 * @param routerId the routerId to set
		 */
		public void setRouterId(String routerId) {
			this.routerId = routerId;
		}
		/**
		 * @return the disableStp
		 */
		public String getDisableStp() {
			return disableStp;
		}
		/**
		 * @param disableStp the disableStp to set
		 */
		public void setDisableStp(String disableStp) {
			this.disableStp = disableStp;
		}
		/**
		 * @return the location
		 */
		public String getLocation() {
			return location;
		}
		/**
		 * @param location the location to set
		 */
		public void setLocation(String location) {
			this.location = location;
		}
		/**
		 * @return the serial
		 */
		public String getSerial() {
			return serial;
		}
		/**
		 * @param serial the serial to set
		 */
		public void setSerial(String serial) {
			this.serial = serial;
		}
		/**
		 * @return the license
		 */
		public String getLicense() {
			return license;
		}
		/**
		 * @param license the license to set
		 */
		public void setLicense(String license) {
			this.license = license;
		}
		/**
		 * @return the inventoryVersionCC
		 */
		public String getInventoryVersionCC() {
			return inventoryVersionCC;
		}
		/**
		 * @param inventoryVersionCC the inventoryVersionCC to set
		 */
		public void setInventoryVersionCC(String inventoryVersionCC) {
			this.inventoryVersionCC = inventoryVersionCC;
		}
		/**
		 * @return the ports
		 */
		public String[] getPorts() {
			return ports;
		}
		/**
		 * @param ports the ports to set
		 */
		public void setPorts(String[] ports) {
			this.ports = ports;
		}
		/**
		 * @return the site
		 */
		public String getSite() {
			return site;
		}
		/**
		 * @param site the site to set
		 */
		public void setSite(String site) {
			this.site = site;
		}
		/**
		 * @return the sitelink
		 */
		public String getSitelink() {
			return sitelink;
		}
		/**
		 * @param sitelink the sitelink to set
		 */
		public void setSitelink(String sitelink) {
			this.sitelink = sitelink;
		}
		
		
		/**
		 * 
		 * @param name
		 * @param model
		 * @param simulated
		 * @param site
		 */
		public SconNode(String name,String model, String simulated, String site,String serial) {
			super();
			this.setName(name);
			this.model = model;
			this.simulated = simulated;
			this.site = site;
			this.serial = serial;
		}
		/**
		 * 
		 * @param name
		 * @param id
		 * @param uplinks
		 * @param model
		 * @param simulated
		 * @param ports
		 * @param site
		 */
		
		public SconNode(String id,String[] uplinks, String model, String simulated, String[] ports, String site) {
			super();
			this.setId(id);
			this.uplinks = uplinks;
			this.model = model;
			this.simulated = simulated;
			this.ports = ports;
			this.site = site;
		}
		
		/**
		 * @param uplinks
		 * @param localAS
		 * @param model
		 * @param radios
		 * @param simulated
		 * @param routerId
		 * @param disableStp
		 * @param location
		 * @param serial
		 * @param license
		 * @param inventoryVersionCC
		 * @param ports
		 * @param site
		 * @param sitelink
		 */
		public SconNode(String id,String[] uplinks, String localAS, String model, String[] radios, String simulated,
				String routerId, String disableStp, String location, String serial, String license,
				String inventoryVersionCC, String[] ports, String site, String sitelink) {
			super();
			this.setId(id);
			this.uplinks = uplinks;
			this.localAS = localAS;
			this.model = model;
			this.radios = radios;
			this.simulated = simulated;
			this.routerId = routerId;
			this.disableStp = disableStp;
			this.location = location;
			this.serial = serial;
			this.license = license;
			this.inventoryVersionCC = inventoryVersionCC;
			this.ports = ports;
			this.site = site;
			this.sitelink = sitelink;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "SconNode [uplinks=" + Arrays.toString(uplinks) + ", localAS=" + localAS + ", model=" + model
					+ ", radios=" + Arrays.toString(radios) + ", simulated=" + simulated + ", routerId=" + routerId
					+ ", disableStp=" + disableStp + ", location=" + location + ", serial=" + serial + ", license="
					+ license + ", inventoryVersionCC=" + inventoryVersionCC + ", ports=" + Arrays.toString(ports)
					+ ", site=" + site + ", sitelink=" + sitelink + ", getId()=" + getId() + "\n]";
		}
}
