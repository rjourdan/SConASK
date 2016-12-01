package com.riverbed.sconask.beans;

public class SconUplink extends SconObject{
	
	private int qos_bw_up;
	private int qos_up;
	private int qos_bw_down;
	private int qos_down;
	private String site;
	private String static_gw_v6;
	private String static_ip_v6;
	private String static_gw_v4;
	private String static_ip_v4;
	private int uin;
	private String node;
	private String wan;            
	private String port; 
	private int vlan;
	private String type;
	
	public int getQos_bw_up() {
		return qos_bw_up;
	}
	public void setQos_bw_up(int qos_bw_up) {
		this.qos_bw_up = qos_bw_up;
	}
	public int getQos_up() {
		return qos_up;
	}
	public void setQos_up(int qos_up) {
		this.qos_up = qos_up;
	}
	public int getQos_bw_down() {
		return qos_bw_down;
	}
	public void setQos_bw_down(int qos_bw_down) {
		this.qos_bw_down = qos_bw_down;
	}
	public int getQos_down() {
		return qos_down;
	}
	public void setQos_down(int qos_down) {
		this.qos_down = qos_down;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getStatic_gw_v6() {
		return static_gw_v6;
	}
	public void setStatic_gw_v6(String static_gw_v6) {
		this.static_gw_v6 = static_gw_v6;
	}
	public String getStatic_ip_v6() {
		return static_ip_v6;
	}
	public void setStatic_ip_v6(String static_ip_v6) {
		this.static_ip_v6 = static_ip_v6;
	}
	public String getStatic_gw_v4() {
		return static_gw_v4;
	}
	public void setStatic_gw_v4(String static_gw_v4) {
		this.static_gw_v4 = static_gw_v4;
	}
	public String getStatic_ip_v4() {
		return static_ip_v4;
	}
	public void setStatic_ip_v4(String static_ip_v4) {
		this.static_ip_v4 = static_ip_v4;
	}
	public int getUin() {
		return uin;
	}
	public void setUin(int uin) {
		this.uin = uin;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getWan() {
		return wan;
	}
	public void setWan(String wan) {
		this.wan = wan;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public int getVlan() {
		return vlan;
	}
	public void setVlan(int vlan) {
		this.vlan = vlan;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public SconUplink(String name,String site, String wan) {
		super();
		this.site = site;
		this.wan = wan;
		this.setName(name);
	}
	/**
	 * @param qos_bw_up
	 * @param qos_up
	 * @param qos_bw_down
	 * @param qos_down
	 * @param site
	 * @param static_gw_v6
	 * @param static_ip_v6
	 * @param static_gw_v4
	 * @param static_ip_v4
	 * @param node
	 * @param wan
	 * @param port
	 * @param vlan
	 * @param type
	 */
	public SconUplink(String id, String name,int qos_bw_up, int qos_up, int qos_bw_down, int qos_down, String site, String static_gw_v6,
			String static_ip_v6, String static_gw_v4, String static_ip_v4, String node, String wan, String port,
			int vlan, String type) {
		super();
		this.setId(id);
		this.setName(name);
		this.qos_bw_up = qos_bw_up;
		this.qos_up = qos_up;
		this.qos_bw_down = qos_bw_down;
		this.qos_down = qos_down;
		this.site = site;
		this.static_gw_v6 = static_gw_v6;
		this.static_ip_v6 = static_ip_v6;
		this.static_gw_v4 = static_gw_v4;
		this.static_ip_v4 = static_ip_v4;
		this.node = node;
		this.wan = wan;
		this.port = port;
		this.vlan = vlan;
		this.type = type;
	}
	@Override
	public String toString() {
		return "SconUplink [qos_bw_up=" + qos_bw_up + ", qos_up=" + qos_up + ", qos_bw_down=" + qos_bw_down
				+ ", qos_down=" + qos_down + ", site=" + site + ", static_gw_v6=" + static_gw_v6 + ", static_ip_v6="
				+ static_ip_v6 + ", static_gw_v4=" + static_gw_v4 + ", static_ip_v4=" + static_ip_v4 + ", uin=" + uin
				+ ", node=" + node + ", wan=" + wan + ", port=" + port + ", vlan=" + vlan + ", type=" + type
				+ ", getId()=" + getId() + ", getName()=" + getName() + "]\n";
	}
	
	

}
