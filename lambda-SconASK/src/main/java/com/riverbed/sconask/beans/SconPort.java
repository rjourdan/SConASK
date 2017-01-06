package com.riverbed.sconask.beans;

public class SconPort extends SconObject{
	

	  private String portId;
	  private String node;
	  private String tag;
	  private String type;
	  private String speeds;
	  private String speed;
	  private String patchlabel;
	  private String segment;
	  private String uplink;
	  private String portal;
	  private String mac;
	  private String virtualMac;
	  private String switchId;
	  private boolean autotrunk;
	  private String bridge_with;
	  private String ifname;
	  private String dcinterface;
	  private boolean auto;
	  private boolean autocfg;
	/**
	 * @return the portId
	 */
	public String getPortId() {
		return portId;
	}
	/**
	 * @param portId the portId to set
	 */
	public void setPortId(String portId) {
		this.portId = portId;
	}
	/**
	 * @return the node
	 */
	public String getNode() {
		return node;
	}
	/**
	 * @param node the node to set
	 */
	public void setNode(String node) {
		this.node = node;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the speeds
	 */
	public String getSpeeds() {
		return speeds;
	}
	/**
	 * @param speeds the speeds to set
	 */
	public void setSpeeds(String speeds) {
		this.speeds = speeds;
	}
	/**
	 * @return the speed
	 */
	public String getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	/**
	 * @return the patchlabel
	 */
	public String getPatchlabel() {
		return patchlabel;
	}
	/**
	 * @param patchlabel the patchlabel to set
	 */
	public void setPatchlabel(String patchlabel) {
		this.patchlabel = patchlabel;
	}
	/**
	 * @return the zone/segment
	 */
	public String getSegment() {
		return segment;
	}
	/**
	 * @param zone the zone/segment to set
	 */
	public void setSegment(String segment) {
		this.segment = segment;
	}
	/**
	 * @return the uplink
	 */
	public String getUplink() {
		return uplink;
	}
	/**
	 * @param uplink the uplink to set
	 */
	public void setUplink(String uplink) {
		this.uplink = uplink;
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
	 * @return the mac
	 */
	public String getMac() {
		return mac;
	}
	/**
	 * @param mac the mac to set
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}
	/**
	 * @return the virtualMac
	 */
	public String getVirtualMac() {
		return virtualMac;
	}
	/**
	 * @param virtualMac the virtualMac to set
	 */
	public void setVirtualMac(String virtualMac) {
		this.virtualMac = virtualMac;
	}
	/**
	 * @return the switchId
	 */
	public String getSwitchId() {
		return switchId;
	}
	/**
	 * @param switchId the switchId to set
	 */
	public void setSwitchId(String switchId) {
		this.switchId = switchId;
	}
	/**
	 * @return the autotrunk
	 */
	public boolean isAutotrunk() {
		return autotrunk;
	}
	/**
	 * @param autotrunk the autotrunk to set
	 */
	public void setAutotrunk(boolean autotrunk) {
		this.autotrunk = autotrunk;
	}
	/**
	 * @return the bridge_with
	 */
	public String getBridge_with() {
		return bridge_with;
	}
	/**
	 * @param bridge_with the bridge_with to set
	 */
	public void setBridge_with(String bridge_with) {
		this.bridge_with = bridge_with;
	}
	/**
	 * @return the ifname
	 */
	public String getIfname() {
		return ifname;
	}
	/**
	 * @param ifname the ifname to set
	 */
	public void setIfname(String ifname) {
		this.ifname = ifname;
	}
	/**
	 * @return the dcinterface
	 */
	public String getDcinterface() {
		return dcinterface;
	}
	/**
	 * @param dcinterface the dcinterface to set
	 */
	public void setDcinterface(String dcinterface) {
		this.dcinterface = dcinterface;
	}
	/**
	 * @return the auto
	 */
	public boolean isAuto() {
		return auto;
	}
	/**
	 * @param auto the auto to set
	 */
	public void setAuto(boolean auto) {
		this.auto = auto;
	}
	/**
	 * @return the autocfg
	 */
	public boolean isAutocfg() {
		return autocfg;
	}
	/**
	 * @param autocfg the autocfg to set
	 */
	public void setAutocfg(boolean autocfg) {
		this.autocfg = autocfg;
	}
	/**
	 * @param portId
	 * @param node
	 * @param tag
	 * @param type
	 * @param speeds
	 * @param speed
	 * @param patchlabel
	 * @param zone
	 * @param uplink
	 * @param portal
	 * @param mac
	 * @param virtualMac
	 * @param switchId
	 * @param autotrunk
	 * @param bridge_with
	 * @param ifname
	 * @param dcinterface
	 * @param auto
	 * @param autocfg
	 */
	public SconPort(String portId, String node, String tag, String type, String speeds, String speed, String patchlabel,
			String zone, String uplink, String portal, String mac, String virtualMac, String switchId,
			boolean autotrunk, String bridge_with, String ifname, String dcinterface, boolean auto, boolean autocfg) {
		super();
		this.portId = portId;
		this.node = node;
		this.tag = tag;
		this.type = type;
		this.speeds = speeds;
		this.speed = speed;
		this.patchlabel = patchlabel;
		this.segment = zone;
		this.uplink = uplink;
		this.portal = portal;
		this.mac = mac;
		this.virtualMac = virtualMac;
		this.switchId = switchId;
		this.autotrunk = autotrunk;
		this.bridge_with = bridge_with;
		this.ifname = ifname;
		this.dcinterface = dcinterface;
		this.auto = auto;
		this.autocfg = autocfg;
	}
	/**
	 * @param portId
	 * @param node
	 * @param type
	 * @param zone
	 * @param mac
	 * @param switchId
	 */
	public SconPort(String portId, String node, String type, String zone, String mac, String switchId) {
		super();
		this.portId = portId;
		this.node = node;
		this.type = type;
		this.segment = zone;
		this.mac = mac;
		this.switchId = switchId;
	}
	
	/**
	 * @param portId
	 * @param node
	 * @param type
	 * @param zone
	 * @param mac
	 * @param switchId
	 */
	public SconPort(String id,String portId, String node, String type, String zone, String mac, String switchId) {
		super();
		this.setId(id);
		this.portId = portId;
		this.node = node;
		this.type = type;
		this.segment = zone;
		this.mac = mac;
		this.switchId = switchId;
	}

}
