package com.riverbed.sconask.beans;

import java.util.Arrays;

public class SconSsid  extends SconObject{

	
		private String ssid;
		private String security;
		private String key;
		private String authentication;
		private String eapolVersion;
		private String dtimPeriod;
		private String[] bcasts;
		
		public static final String WPA2P = "wpa2personal";
		public static final String WPA2E = "wpa2enterprise";
		public static final String OPEN = "open";
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
		 * @return the security
		 */
		public String getSecurity() {
			return security;
		}
		/**
		 * @param security the security to set
		 */
		public void setSecurity(String security) {
			this.security = security;
		}
		/**
		 * @return the key
		 */
		public String getKey() {
			return key;
		}
		/**
		 * @param key the key to set
		 */
		public void setKey(String key) {
			this.key = key;
		}
		/**
		 * @return the authentication
		 */
		public String getAuthentication() {
			return authentication;
		}
		/**
		 * @param authentication the authentication to set
		 */
		public void setAuthentication(String authentication) {
			this.authentication = authentication;
		}
		/**
		 * @return the eapolVersion
		 */
		public String getEapolVersion() {
			return eapolVersion;
		}
		/**
		 * @param eapolVersion the eapolVersion to set
		 */
		public void setEapolVersion(String eapolVersion) {
			this.eapolVersion = eapolVersion;
		}
		/**
		 * @return the dtimPeriod
		 */
		public String getDtimPeriod() {
			return dtimPeriod;
		}
		/**
		 * @param dtimPeriod the dtimPeriod to set
		 */
		public void setDtimPeriod(String dtimPeriod) {
			this.dtimPeriod = dtimPeriod;
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
		 * @param ssid
		 * @param security
		 * @param key
		 */
		public SconSsid(String ssid, String security, String key) {
			super();
			this.ssid = ssid;
			this.security = security;
			this.key = key;
		}
		
		public SconSsid(String id,String ssid, String security, String key) {
			super();
			this.setId(id);
			this.ssid = ssid;
			this.security = security;
			this.key = key;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "SconSsid [ssid=" + ssid + ", security=" + security + ", key=" + key + ", authentication="
					+ authentication + ", eapolVersion=" + eapolVersion + ", dtimPeriod=" + dtimPeriod + ", bcasts="
					+ Arrays.toString(bcasts) + ", getId()=" + getId() + "]";
		}
			
		
		
}
