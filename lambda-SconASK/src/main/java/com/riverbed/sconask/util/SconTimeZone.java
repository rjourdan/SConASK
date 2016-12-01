package com.riverbed.sconask.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public class SconTimeZone {
	
	private static Map<String, Set<TimeZone>> availableTimezones; 
	
	private static void loadAvailableTimeZones()
	{
		availableTimezones = new HashMap<String, Set<TimeZone>>();
		
		// Loop through all available locales
		
		for (Locale locale : Locale.getAvailableLocales())
		{
		
			final String countryCode = locale.getCountry();
		
		// Locate the timezones added for this country so far
		// (This can be moved to inside the loop if depending
		// on whether country with no available timezones should
		// be in the result map with an empty set,
		// or not included at all)
		
			Set<TimeZone> timezones = availableTimezones.get(countryCode);
			if (timezones==null)
			{
				timezones = new HashSet<TimeZone>();
				availableTimezones.put(countryCode, timezones);
			}
		
			// Find all timezones for that country (code) using ICU4J
		
			for (String id :com.ibm.icu.util.TimeZone.getAvailableIDs(countryCode))
			{
		
				// Add timezone to result map
				timezones.add(TimeZone.getTimeZone(id));
			}	
		
		}
		
		}
	
	public static String getTimeZoneID (String country){
		String timeZoneID="America/Los_Angeles";
		if(availableTimezones==null){
			loadAvailableTimeZones();
		}
		Set<TimeZone> countryTimeZones = availableTimezones.get(country);
		Iterator<TimeZone> it = countryTimeZones.iterator();
		if (it.hasNext()) timeZoneID = it.next().getID();
		while(it.hasNext() && timeZoneID.length()<4) timeZoneID = it.next().getID();
	
		return timeZoneID;
	}
}
