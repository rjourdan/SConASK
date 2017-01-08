package com.riverbed.sconask.beans;

public class SconPathRules extends SconObject {

	
	public static final String DST_APPS = "apps";
	public static final String DST_SEGMENTS = "segments";
	public static final String DST_DSCP = "dscp";
	public static final String DST_ANY = "any";
	
	public static final String SRC_ALL = "all";
	public static final String SRC_SEGMENTS = "segments";
	public static final String SRC_CVPN = "cvpnrnets";
	public static final String SRC_REGISTERED_USERS_DEVICES = "users";
	public static final String SRC_GUESTS = "guests";
	public static final String SRC_SELECTED_ITEMS = "select";
	
	public static final String QOS_AUTO = "auto";
	public static final String QOS_CUSTOM = "custom";
	public static final String QOS_URGENT = "urgent";
	public static final String QOS_HIGH = "high";
	public static final String QOS_NORMAL = "normal";
	public static final String QOS_LOW = "low";
	
	private String dsttype;
	private String srctype;
	private String qos;
	private String marking;
	private String[] zones;
	private String[] sites;
	private String[] path_preference;
	private boolean active;
	private String dscp;
	private String[] apps;
	private String[] devices;
	private String tags;
	private String[] users;
	private String sapps;
	
	
	
	/**
	 * @return the dsttype
	 */
	public String getDsttype() {
		return dsttype;
	}



	/**
	 * @param dsttype the dsttype to set
	 */
	public void setDsttype(String dsttype) {
		this.dsttype = dsttype;
	}



	/**
	 * @return the srctype
	 */
	public String getSrctype() {
		return srctype;
	}



	/**
	 * @param srctype the srctype to set
	 */
	public void setSrctype(String srctype) {
		this.srctype = srctype;
	}



	/**
	 * @return the qos
	 */
	public String getQos() {
		return qos;
	}



	/**
	 * @param qos the qos to set
	 */
	public void setQos(String qos) {
		this.qos = qos;
	}



	/**
	 * @return the marking
	 */
	public String getMarking() {
		return marking;
	}



	/**
	 * @param marking the marking to set
	 */
	public void setMarking(String marking) {
		this.marking = marking;
	}



	/**
	 * @return the zones
	 */
	public String[] getZones() {
		return zones;
	}



	/**
	 * @param zones the zones to set
	 */
	public void setZones(String[] zones) {
		this.zones = zones;
	}


	/**
	 * @return the sites
	 */
	public String[] getSites() {
		return sites;
	}



	/**
	 * @param sites the sites to set
	 */
	public void setSites(String[] sites) {
		this.sites = sites;
	}



	/**
	 * @return the path_preference
	 */
	public String[] getPath_preference() {
		return path_preference;
	}



	/**
	 * @param path_preference the path_preference to set
	 */
	public void setPath_preference(String[] path_preference) {
		this.path_preference = path_preference;
	}



	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}



	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}



	/**
	 * @return the dscp
	 */
	public String getDscp() {
		return dscp;
	}



	/**
	 * @param dscp the dscp to set
	 */
	public void setDscp(String dscp) {
		this.dscp = dscp;
	}



	/**
	 * @return the apps
	 */
	public String[] getApps() {
		return apps;
	}



	/**
	 * @param apps the apps to set
	 */
	public void setApps(String[] apps) {
		this.apps = apps;
	}



	/**
	 * @return the devices
	 */
	public String[] getDevices() {
		return devices;
	}



	/**
	 * @param devices the devices to set
	 */
	public void setDevices(String[] devices) {
		this.devices = devices;
	}



	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}



	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}



	/**
	 * @return the users
	 */
	public String[] getUsers() {
		return users;
	}



	/**
	 * @param users the users to set
	 */
	public void setUsers(String[] users) {
		this.users = users;
	}



	/**
	 * @return the sapps
	 */
	public String getSapps() {
		return sapps;
	}



	/**
	 * @param sapps the sapps to set
	 */
	public void setSapps(String sapps) {
		this.sapps = sapps;
	}




	public SconPathRules(String id, String dsttype, String srctype, String qos, String marking, String[] zones, String uid,
			String[] sites, String[] path_preference, boolean active, String dscp, String[] apps, String[] devices,
			String tags, String[] users, String sapps) {
		super();
		this.setId(id);
		this.dsttype = dsttype;
		this.srctype = srctype;
		this.qos = qos;
		this.marking = marking;
		this.zones = zones;
		this.setUid(uid);
		this.sites = sites;
		this.path_preference = path_preference;
		this.active = active;
		this.dscp = dscp;
		this.apps = apps;
		this.devices = devices;
		this.tags = tags;
		this.users = users;
		this.sapps = sapps;
	}



	/**
	 * @param dsttype
	 * @param srctype
	 * @param qos
	 * @param marking
	 * @param zones
	 * @param iud
	 * @param sites
	 * @param path_preference
	 * @param active
	 * @param dscp
	 * @param apps
	 * @param devices
	 * @param tags
	 * @param users
	 */
	public SconPathRules(String dsttype, String srctype, String qos, String marking, String[] zones, String uid,
			String[] sites, String[] path_preference, boolean active, String dscp, String[] apps, String[] devices,
			String tags, String[] users) {
		super();
		this.dsttype = dsttype;
		this.srctype = srctype;
		this.qos = qos;
		this.marking = marking;
		this.zones = zones;
		this.setUid(uid);
		this.sites = sites;
		this.path_preference = path_preference;
		this.active = active;
		this.dscp = dscp;
		this.apps = apps;
		this.devices = devices;
		this.tags = tags;
		this.users = users;
	}

	/**
	 * 
	 * @param dsttype
	 * @param srctype
	 * @param qos
	 * @param marking
	 * @param zones
	 * @param sites
	 * @param path_preference
	 * @param active
	 * @param dscp
	 * @param apps
	 * @param devices
	 * @param tags
	 * @param users
	 */
	public SconPathRules(String dsttype, String srctype, String qos, String marking, String[] zones,
			String[] sites, String[] path_preference, boolean active, String dscp, String[] apps, String[] devices,
			String tags, String[] users, String sapps) {
		super();
		this.dsttype = dsttype;
		this.srctype = srctype;
		this.qos = qos;
		this.marking = marking;
		this.zones = zones;
		this.sites = sites;
		this.path_preference = path_preference;
		this.active = active;
		this.dscp = dscp;
		this.apps = apps;
		this.devices = devices;
		this.tags = tags;
		this.users = users;
		this.sapps = sapps;
	}


	public SconPathRules() {
		// TODO Auto-generated constructor stub
	}

}
