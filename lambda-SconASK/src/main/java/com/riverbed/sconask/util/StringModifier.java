package com.riverbed.sconask.util;

public class StringModifier {
	
	public static String removeBrackets(String string){
		
		
		if(string.charAt(0)=='\"') string = string.substring(1);
		if(string.charAt(string.length()-1)=='\"') string = string.substring(0,string.length()-1); 
			
		return string;
		
	}
}
