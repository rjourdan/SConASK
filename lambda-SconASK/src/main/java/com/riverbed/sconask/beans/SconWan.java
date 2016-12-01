package com.riverbed.sconask.beans;

import java.util.Arrays;

public class SconWan extends SconObject {
		  	
		private String[] uplinks;
		private String[] networks;
		private String longname;  
		private String internet;
		private String sitelink;
		private String pingcheck_ips;
		private String[] dcuplinks;    
		private String breakout;
		private String[] breakout_sites;
		private String xfer_networks;
		
		public String[] getUplinks() {
			return uplinks;
		}
		public void setUplinks(String[] uplinks) {
			this.uplinks = uplinks;
		}
		public String[] getNetworks() {
			return networks;
		}
		public void setNetworks(String[] networks) {
			this.networks = networks;
		}
		public String getLongname() {
			return longname;
		}
		public void setLongname(String longname) {
			this.longname = longname;
		}
		public String isInternet() {
			return internet;
		}
		public void setInternet(String internet) {
			this.internet = internet;
		}
		public String isSitelink() {
			return sitelink;
		}
		public void setSitelink(String sitelink) {
			this.sitelink = sitelink;
		}
		public String getPingcheck_ips() {
			return pingcheck_ips;
		}
		public void setPingcheck_ips(String pingcheck_ips) {
			this.pingcheck_ips = pingcheck_ips;
		}
		public String[] getDcuplinks() {
			return dcuplinks;
		}
		public void setDcuplinks(String[] dcuplinks) {
			this.dcuplinks = dcuplinks;
		}
		public String isBreakout() {
			return breakout;
		}
		public void setBreakout(String breakout) {
			this.breakout = breakout;
		}
		public String[] getBreakout_sites() {
			return breakout_sites;
		}
		public void setBreakout_sites(String[] breakout_sites) {
			this.breakout_sites = breakout_sites;
		}
		public String getXfer_networks() {
			return xfer_networks;
		}
		public void setXfer_networks(String xfer_networks) {
			this.xfer_networks = xfer_networks;
		}
		/**
		 * @param longname
		 * @param internet
		 */
		public SconWan(String name,String longname, String internet) {
			super();
			this.longname = longname;
			this.internet = internet;
			this.setName(name);
		}
		/**
		 * @param uplinks
		 * @param networks
		 * @param longname
		 * @param internet
		 * @param sitelink
		 * @param breakout
		 * @param breakout_sites
		 */
		public SconWan(String id, String name,String[] uplinks, String[] networks, String longname, String internet, String sitelink,
				String breakout, String[] breakout_sites) {
			super();
			this.setId(id);
			this.setName(name);
			this.uplinks = uplinks;
			this.networks = networks;
			this.longname = longname;
			this.internet = internet;
			this.sitelink = sitelink;
			this.breakout = breakout;
			this.breakout_sites = breakout_sites;
		}
		
		@Override
		public String toString() {
			return "SconWan [uplinks=" + Arrays.toString(uplinks) + ", networks=" + Arrays.toString(networks)
					+ ", longname=" + longname + ", internet=" + internet + ", sitelink=" + sitelink
					+ ", pingcheck_ips=" + pingcheck_ips + ", dcuplinks=" + Arrays.toString(dcuplinks) + ", breakout="
					+ breakout + ", breakout_sites=" + Arrays.toString(breakout_sites) + ", xfer_networks="
					+ xfer_networks + ", getId()=" + getId() + ", getName()=" + getName() + "]\n";
		}
		 
		
		
		
}
