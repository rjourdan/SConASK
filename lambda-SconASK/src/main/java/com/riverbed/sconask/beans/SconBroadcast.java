package com.riverbed.sconask.beans;

public class SconBroadcast  extends SconObject{

	private String site;
	private String zone;
	private String ssid;
	private boolean inactive;
	private boolean dynzone;
	private String portal;
	private boolean hide_ssid;
	private String band;
	
	public static final String DUAL_BAND="2.4GHZ and 5GHZ";
	public static final String LOW_BAND ="2.4GHZ only";
	public static final String HIGH_BAND ="5GHZ only";
	
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
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}
	/**
	 * @param zone the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}
	/**
	 * @return the ssid
	 */
	public String getSsid() {
		return ssid;
	}
	/**
	 * @param ssid the ssid to set
	 */
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	/**
	 * @return the inactive
	 */
	public boolean isInactive() {
		return inactive;
	}
	/**
	 * @param inactive the inactive to set
	 */
	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}
	/**
	 * @return the dynzone
	 */
	public boolean isDynzone() {
		return dynzone;
	}
	/**
	 * @param dynzone the dynzone to set
	 */
	public void setDynzone(boolean dynzone) {
		this.dynzone = dynzone;
	}
	/**
	 * @return the portal
	 */
	public String getPortal() {
		return portal;
	}
	/**
	 * @param portal the portal to set
	 */
	public void setPortal(String portal) {
		this.portal = portal;
	}
	/**
	 * @return the hide_ssid
	 */
	public boolean isHide_ssid() {
		return hide_ssid;
	}
	/**
	 * @param hide_ssid the hide_ssid to set
	 */
	public void setHide_ssid(boolean hide_ssid) {
		this.hide_ssid = hide_ssid;
	}
	/**
	 * @return the band
	 */
	public String getBand() {
		return band;
	}
	/**
	 * @param band the band to set
	 */
	public void setBand(String band) {
		this.band = band;
	}
	/**
	 * @param site
	 * @param zone
	 * @param ssid
	 */
	public SconBroadcast(String site, String zone, String ssid) {
		super();
		this.site = site;
		this.zone = zone;
		this.ssid = ssid;
	}
	
	public SconBroadcast(String id,String site, String zone, String ssid) {
		super();
		this.setId(id);
		this.site = site;
		this.zone = zone;
		this.ssid = ssid;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SconBroadcast [site=" + site + ", zone=" + zone + ", ssid=" + ssid + ", inactive=" + inactive
				+ ", dynzone=" + dynzone + ", portal=" + portal + ", hide_ssid=" + hide_ssid + ", band=" + band
				+ ", getId()=" + getId() + "]";
	}
	
	
}
