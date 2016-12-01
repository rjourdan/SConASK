package com.riverbed.sconask.beans;

import java.util.Arrays;
import java.util.Locale;

import com.riverbed.sconask.util.SconTimeZone;


public class SconSite extends SconObject{

	private String longName;
	private String address;
	private String city;
	private String country;
	private String countryCode;
	private String[] uplinks;
	private String timezone;
	private String[] networks;
	private int size;
	
	public static final String BRANCH = "branch";
	public static final String PLANT = "plant";
	public static final String HQ = "headquarter";
	public static final String SHOP = "shop";
	public static final String BOUTIQUE = "boutique";
	
	
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getUplinks() {
		return uplinks;
	}
	public void setUplinks(String[] uplinks) {
		this.uplinks = uplinks;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String[] getNetworks() {
		return networks;
	}
	public void setNetworks(String[] networks) {
		this.networks = networks;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	/**
	 * @param name
	 * @param longName
	 * @param address
	 * @param city
	 * @param country
	 */
	public SconSite(String name, String longName, String address, String city, String country) {
		super();
		this.setName(name);
		this.longName = longName;
		this.address = address;
		this.city = city;
		this.country = country;
		
		String[] locales = Locale.getISOCountries();
		if(country.equals("US")|| country.equals("USA")) this.country = "United States";
		if(country.equals("UK")|| country.equals("England")|| country.equals("Scotland")|| country.equals("Wales")) this.country = "United Kingdom";
		for (String countryCode : locales) {

			Locale obj = new Locale("", countryCode);
			
			if(obj.getDisplayCountry().equals(this.country)){
				this.countryCode=obj.getCountry();
				this.timezone = SconTimeZone.getTimeZoneID(countryCode);
				break;
			}
		}
	}
	/**
	 * @param longName
	 * @param address
	 * @param city
	 * @param country
	 * @param countryCode
	 * @param uplinks
	 * @param timezone
	 * @param networks
	 * @param size
	 */
	public SconSite(String id,String name, String longName, String address, String city,String countryCode,
			String[] uplinks, String timezone, String[] networks, int size) {
		super();
		this.setId(id);
		this.setName(name);
		this.longName = longName;
		this.address = address;
		this.city = city;
		this.countryCode = countryCode;
		this.uplinks = uplinks;
		this.timezone = timezone;
		this.networks = networks;
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "SconSite [id="+this.getId()+" name="+this.getName()+" longName=" + longName + ", address=" + address + ", city=" + city + ", country=" + country
				+ ", countryCode=" + countryCode + ", uplinks=" + Arrays.toString(uplinks) + ", timezone=" + timezone
				+ ", networks=" + Arrays.toString(networks) + ", size=" + size + "]\n";
	}
	
	/**
	 * Give a Text-to-Speech message to describe a SconSite object for Alexa Skill
	 * @return String message
	 */
	public String toStringAlexa() {
		return this.getName()+"located in" + city;
	}
	
	
	
}
