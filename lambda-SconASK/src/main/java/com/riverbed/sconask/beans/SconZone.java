package com.riverbed.sconask.beans;

import java.util.Arrays;

public class SconZone extends SconObject{

	private String siteID;
    private String[] networks;
    private String mgmt;
    private String icmp;
    private String guest;
    private String[] breakoutPreference;
    private String[] routes;
    private String[] bcasts;
    private String tag;
    private String tags;
	/**
	 * @return the siteID
	 */
	public String getSiteID() {
		return siteID;
	}
	/**
	 * @param siteID the siteID to set
	 */
	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}
	/**
	 * @return the networks
	 */
	public String[] getNetworks() {
		return networks;
	}
	/**
	 * @param networks the networks to set
	 */
	public void setNetworks(String[] networks) {
		this.networks = networks;
	}
	/**
	 * @return the mgmt
	 */
	public String getMgmt() {
		return mgmt;
	}
	/**
	 * @param mgmt the mgmt to set
	 */
	public void setMgmt(String mgmt) {
		this.mgmt = mgmt;
	}
	/**
	 * @return the icmp
	 */
	public String getIcmp() {
		return icmp;
	}
	/**
	 * @param icmp the icmp to set
	 */
	public void setIcmp(String icmp) {
		this.icmp = icmp;
	}
	/**
	 * @return the guest
	 */
	public String getGuest() {
		return guest;
	}
	/**
	 * @param guest the guest to set
	 */
	public void setGuest(String guest) {
		this.guest = guest;
	}
	/**
	 * @return the breakoutPreference
	 */
	public String[] getBreakoutPreference() {
		return breakoutPreference;
	}
	/**
	 * @param breakoutPreference the breakoutPreference to set
	 */
	public void setBreakoutPreference(String[] breakoutPreference) {
		this.breakoutPreference = breakoutPreference;
	}
	/**
	 * @return the routes
	 */
	public String[] getRoutes() {
		return routes;
	}
	/**
	 * @param routes the routes to set
	 */
	public void setRoutes(String[] routes) {
		this.routes = routes;
	}
	/**
	 * @return the bcasts
	 */
	public String[] getBcasts() {
		return bcasts;
	}
	/**
	 * @param bcasts the bcasts to set
	 */
	public void setBcasts(String[] bcasts) {
		this.bcasts = bcasts;
	}
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
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
	 * 
	 * @param name
	 * @param guest
	 */
	public SconZone(String name,String guest,String site) {
		super();
		this.guest = guest;
		this.setName(name);
		this.siteID = site;
	}
	
	
	
	/**
	 * @param siteID
	 * @param networks
	 * @param mgmt
	 * @param icmp
	 * @param guest
	 * @param breakoutPreference
	 * @param routes
	 * @param bcasts
	 * @param tag
	 * @param tags
	 */
	public SconZone(String id, String name,String siteID, String[] networks, String mgmt, String icmp, String guest,
			String[] breakoutPreference, String[] routes, String[] bcasts, String tag, String tags) {
		super();
		this.setId(id);
		this.setName(name);
		this.siteID = siteID;
		this.networks = networks;
		this.mgmt = mgmt;
		this.icmp = icmp;
		this.guest = guest;
		this.breakoutPreference = breakoutPreference;
		this.routes = routes;
		this.bcasts = bcasts;
		this.tag = tag;
		this.tags = tags;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SconZone [siteID=" + siteID + ", networks=" + Arrays.toString(networks) + ", mgmt=" + mgmt + ", icmp="
				+ icmp + ", guest=" + guest + ", breakoutPreference=" + Arrays.toString(breakoutPreference)
				+ ", routes=" + Arrays.toString(routes) + ", bcasts=" + Arrays.toString(bcasts) + ", tag=" + tag
				+ ", tags=" + tags + "]";
	}
	
	
    
   
    
    

}
